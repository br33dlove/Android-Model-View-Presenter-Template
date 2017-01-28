package com.davidcryer.mvpandroid.android.view.ui;

import android.content.Intent;

public interface EditAddressAndroidView extends AndroidMvpView {
    Intent intent();//todo use
    String house();
    String street();
    String town();
    String city();
    String postCode();
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
    void returnAddressForCode(final Intent intent, final int code);//TODO use intdef?

    interface EventsListener extends AndroidMvpView.EventsListener {
        void onUpdateHouse(final String house);
        void onUpdateStreet(final String street);
        void onUpdateTown(final String town);
        void onUpdateCity(final String city);
        void onUpdatePostCode(final String postCode);
        void onFocusHouseField();
        void onFocusStreetField();
        void onFocusTownField();
        void onFocusCityField();
        void onFocusPostCodeField();
        void onClickDone();
    }
}
