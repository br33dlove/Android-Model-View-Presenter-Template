package com.davidcryer.mvpandroid.android.view.models;

import android.support.annotation.Nullable;

import com.davidcryer.mvpandroid.android.view.ui.EditAddressAndroidView;
import com.davidcryer.mvpandroid.platformindependent.view.models.EditAddressMvpViewModel;

public interface EditAddressAndroidViewModel extends EditAddressMvpViewModel, AndroidViewModel<EditAddressAndroidView> {
    void house(final String house);
    void street(final String street);
    void town(final String town);
    void city(final String city);
    void postCode(final String postCode);
    void house(@Nullable final EditAddressAndroidView view, final String house);
    void street(@Nullable final EditAddressAndroidView view, final String street);
    void town(@Nullable final EditAddressAndroidView view, final String town);
    void city(@Nullable final EditAddressAndroidView view, final String city);
    void postCode(@Nullable final EditAddressAndroidView view, final String postCode);
    void houseError(@Nullable final EditAddressAndroidView view, final String houseError);
    void streetError(@Nullable final EditAddressAndroidView view, final String streetError);
    void townError(@Nullable final EditAddressAndroidView view, final String townError);
    void cityError(@Nullable final EditAddressAndroidView view, final String cityError);
    void postCodeError(@Nullable final EditAddressAndroidView view, final String postCodeError);
    void returnAddress(@Nullable final EditAddressAndroidView view, final String house, final String street, final String town, final String city, final String postCode, final int returnCode);
}
