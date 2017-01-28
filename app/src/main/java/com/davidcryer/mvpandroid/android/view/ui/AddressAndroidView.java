package com.davidcryer.mvpandroid.android.view.ui;

import android.content.Intent;

public interface AddressAndroidView extends AndroidMvpView {
    void showHouse(final String house);
    void showStreet(final String street);
    void showTown(final String town);
    void showCity(final String city);
    void showPostCode(final String postCode);
    void startEditAddressView(final Intent intent, final int requestCode);

    interface EventsListener extends AndroidMvpView.EventsListener {
        void onClickEdit();
        void onReturnResult(final int requestCode, final int resultCode, final Intent intent);
    }
}
