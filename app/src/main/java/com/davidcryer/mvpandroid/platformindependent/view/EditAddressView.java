package com.davidcryer.mvpandroid.platformindependent.view;

import com.davidcryer.mvpandroid.platformindependent.view.models.EditAddressMvpViewModel;

public interface EditAddressView extends MvpView<EditAddressMvpViewModel> {
    void showHouse(final String house);
    void showStreet(final String street);
    void showTown(final String town);
    void showCity(final String city);
    void showPostCode(final String postCode);
    void showHouseError(final String errorText);
    void showStreetError(final String errorText);
    void showTownError(final String errorText);
    void showCityError(final String errorText);
    void showPostCodeError(final String errorText);
    void returnAddress(final String house, final String street, final String town, final String city, final String postCode, final int code);//TODO use intdef?

    interface EventsListener extends MvpView.EventsListener {
        void onFocusHouseField();
        void onFocusStreetField();
        void onFocusTownField();
        void onFocusCityField();
        void onFocusPostCodeField();
        void onClickDone();
    }
}
