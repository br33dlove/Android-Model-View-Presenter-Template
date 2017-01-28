package com.davidcryer.mvpandroid.platformindependent.presenter.presenters;

import com.davidcryer.mvpandroid.platformindependent.view.models.AddressMvpViewModel;
import com.davidcryer.mvpandroid.platformindependent.view.AddressView;

public class AddressPresenter extends Presenter<AddressView.EventsListener> {
    private final AddressView viewWrapper;

    private AddressPresenter(final AddressView viewWrapper) {
        this.viewWrapper = viewWrapper;
    }

    public static Presenter<AddressView.EventsListener> newInstance(
            final AddressView viewWrapper
    ) {
        return new AddressPresenter(viewWrapper);
    }

    @Override
    public AddressView.EventsListener eventsListener() {
        return new AddressView.EventsListener() {

            @Override
            public void onClickEdit() {
                viewWrapper.startEditAddressView();
            }

            @Override
            public void onReturnAddress(String house, String street, String town, String city, String postCode) {
                final AddressMvpViewModel viewModel = viewWrapper.viewModel();
                viewWrapper.showHouse(house);
                viewWrapper.showStreet(street);
                viewWrapper.showTown(town);
                viewWrapper.showCity(city);
                viewWrapper.showPostCode(postCode);
                //TODO save result
            }
        };
    }

    @Override
    public void releaseResources() {

    }
}
