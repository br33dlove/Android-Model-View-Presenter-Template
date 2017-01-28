package com.davidcryer.mvpandroid.platformindependent.presenter.factories;

import com.davidcryer.mvpandroid.platformindependent.presenter.businesslogic.AddressLineFormatter;
import com.davidcryer.mvpandroid.platformindependent.presenter.businesslogic.PostCodeFormatter;
import com.davidcryer.mvpandroid.platformindependent.presenter.businesslogic.validators.AddressLineValidatorImpl;
import com.davidcryer.mvpandroid.platformindependent.presenter.businesslogic.validators.PostCodeValidatorImpl;
import com.davidcryer.mvpandroid.platformindependent.presenter.businesslogic.validators.ValidationResultFactory;
import com.davidcryer.mvpandroid.platformindependent.presenter.presenters.EditAddressPresenter;
import com.davidcryer.mvpandroid.platformindependent.presenter.presenters.Presenter;
import com.davidcryer.mvpandroid.platformindependent.presenter.presenters.AddressPresenter;
import com.davidcryer.mvpandroid.platformindependent.view.AddressView;
import com.davidcryer.mvpandroid.platformindependent.view.EditAddressView;

public class PresenterFactoryImpl implements PresenterFactory {
    private final ValidationResultFactory validationResultFactory;

    private PresenterFactoryImpl(final ValidationResultFactory validationResultFactory) {
        this.validationResultFactory = validationResultFactory;
    }

    public static PresenterFactory newInstance(final ValidationResultFactory validationResultFactory) {
        return new PresenterFactoryImpl(validationResultFactory);
    }

    @Override
    public Presenter<AddressView.EventsListener> createAddressPresenter(final AddressView viewWrapper) {
        return AddressPresenter.newInstance(viewWrapper);
    }

    @Override
    public Presenter<EditAddressView.EventsListener> createEditAddressPresenter(final EditAddressView viewWrapper) {
        return EditAddressPresenter.newInstance(
                viewWrapper,
                AddressLineValidatorImpl.newInstance(validationResultFactory),
                new AddressLineFormatter(),
                PostCodeValidatorImpl.newInstance(validationResultFactory),
                new PostCodeFormatter()
        );
    }
}
