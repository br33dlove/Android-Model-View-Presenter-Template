package com.davidcryer.mvpandroid.platformindependent.view;

import com.davidcryer.mvpandroid.platformindependent.view.models.AddressMvpViewModel;

public interface AddressView extends MvpView<AddressMvpViewModel> {
    void showHouse(final String house);
    void showStreet(final String street);
    void showTown(final String town);
    void showCity(final String city);
    void showPostCode(final String postCode);
    void startEditAddressView();

    interface EventsListener extends MvpView.EventsListener {
        void onClickEdit();
        void onReturnAddress(final String house, final String street, final String town, final String city, final String postCode);
    }
}
