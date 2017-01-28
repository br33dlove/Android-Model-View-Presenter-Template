package com.davidcryer.mvpandroid.platformindependent.presenter.presenters;

import com.davidcryer.mvpandroid.platformindependent.javahelpers.StringHelper;
import com.davidcryer.mvpandroid.platformindependent.presenter.businesslogic.AddressLineFormatter;
import com.davidcryer.mvpandroid.platformindependent.presenter.businesslogic.validators.AddressLineValidator;
import com.davidcryer.mvpandroid.platformindependent.presenter.businesslogic.PostCodeFormatter;
import com.davidcryer.mvpandroid.platformindependent.presenter.businesslogic.validators.PostCodeValidator;
import com.davidcryer.mvpandroid.platformindependent.presenter.businesslogic.validators.ValidationResult;
import com.davidcryer.mvpandroid.platformindependent.view.models.EditAddressMvpViewModel;
import com.davidcryer.mvpandroid.platformindependent.view.EditAddressView;

public class EditAddressPresenter extends Presenter<EditAddressView.EventsListener> {
    private final EditAddressView view;
    private final AddressLineValidator addressLineValidator;
    private final AddressLineFormatter addressLineFormatter;
    private final PostCodeValidator postCodeValidator;
    private final PostCodeFormatter postCodeFormatter;

    private EditAddressPresenter(
            final EditAddressView view,
            final AddressLineValidator addressLineValidator,
            final AddressLineFormatter addressLineFormatter,
            final PostCodeValidator postCodeValidator,
            final PostCodeFormatter postCodeFormatter
    ) {
        this.view = view;
        this.addressLineValidator = addressLineValidator;
        this.addressLineFormatter = addressLineFormatter;
        this.postCodeValidator = postCodeValidator;
        this.postCodeFormatter = postCodeFormatter;
    }

    public static EditAddressPresenter newInstance(
            final EditAddressView view,
            final AddressLineValidator addressLineValidator,
            final AddressLineFormatter addressLineFormatter,
            final PostCodeValidator postCodeValidator,
            final PostCodeFormatter postCodeFormatter
    ) {
        return new EditAddressPresenter(view, addressLineValidator, addressLineFormatter, postCodeValidator, postCodeFormatter);
    }

    @Override
    public EditAddressView.EventsListener eventsListener() {
        return new EditAddressView.EventsListener() {

            @Override
            public void onFocusHouseField() {
                if (!StringHelper.nullOrEmpty(view.viewModel().houseError())) {
                    view.showHouseError(null);
                }
            }

            @Override
            public void onFocusStreetField() {
                if (!StringHelper.nullOrEmpty(view.viewModel().streetError())) {
                    view.showStreetError(null);
                }
            }

            @Override
            public void onFocusTownField() {
                if (!StringHelper.nullOrEmpty(view.viewModel().townError())) {
                    view.showTownError(null);
                }
            }

            @Override
            public void onFocusCityField() {
                if (!StringHelper.nullOrEmpty(view.viewModel().cityError())) {
                    view.showCityError(null);
                }
            }

            @Override
            public void onFocusPostCodeField() {
                if (!StringHelper.nullOrEmpty(view.viewModel().postCodeError())) {
                    view.showPostCodeError(null);
                }
            }

            @Override
            public void onClickDone() {
                EditAddressPresenter.this.onClickDone();
            }
        };
    }

    private void onClickDone() {
        if (isValidAddressElseDisplayErrors()) {
            final EditAddressMvpViewModel viewModel = view.viewModel();
            view.returnAddress(
                    addressLineFormatter.format(viewModel.house()),
                    addressLineFormatter.format(viewModel.street()),
                    addressLineFormatter.format(viewModel.town()),
                    addressLineFormatter.format(viewModel.city()),
                    postCodeFormatter.format(viewModel.postCode()),
                    200//TODO enum
            );
        }
    }

    private boolean isValidAddressElseDisplayErrors() {
        final EditAddressMvpViewModel viewModel = view.viewModel();
        final ValidationResult houseResult = addressLineValidator.isValid(viewModel.house(), false);
        final ValidationResult streetResult = addressLineValidator.isValid(viewModel.street(), false);
        final ValidationResult townResult = addressLineValidator.isValid(viewModel.town(), true);
        final ValidationResult cityResult = addressLineValidator.isValid(viewModel.city(), true);
        final ValidationResult postCodeResult = postCodeValidator.isValid(viewModel.postCode(), false);
        view.showHouseError(houseResult.error());
        view.showStreetError(streetResult.error());
        view.showTownError(townResult.error());
        view.showCityError(cityResult.error());
        view.showPostCodeError(postCodeResult.error());
        return houseResult.passed() && streetResult.passed() && townResult.passed() && cityResult.passed() && postCodeResult.passed();
    }

    @Override
    public void releaseResources() {

    }
}
