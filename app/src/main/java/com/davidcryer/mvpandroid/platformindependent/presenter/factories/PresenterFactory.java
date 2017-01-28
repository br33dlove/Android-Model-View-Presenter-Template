package com.davidcryer.mvpandroid.platformindependent.presenter.factories;

import com.davidcryer.mvpandroid.platformindependent.presenter.presenters.Presenter;
import com.davidcryer.mvpandroid.platformindependent.view.AddressView;
import com.davidcryer.mvpandroid.platformindependent.view.EditAddressView;

public interface PresenterFactory {
    Presenter<AddressView.EventsListener> createAddressPresenter(final AddressView viewWrapper);
    Presenter<EditAddressView.EventsListener> createEditAddressPresenter(final EditAddressView viewWrapper);
}
