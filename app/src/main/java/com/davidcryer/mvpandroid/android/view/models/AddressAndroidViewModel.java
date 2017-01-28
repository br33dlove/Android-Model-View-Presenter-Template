package com.davidcryer.mvpandroid.android.view.models;

import android.support.annotation.Nullable;

import com.davidcryer.mvpandroid.android.view.ui.AddressAndroidView;
import com.davidcryer.mvpandroid.platformindependent.view.models.AddressMvpViewModel;

public interface AddressAndroidViewModel extends AddressMvpViewModel, AndroidViewModel<AddressAndroidView> {
    void house(@Nullable final AddressAndroidView view, final String house);
    void street(@Nullable final AddressAndroidView view, final String street);
    void town(@Nullable final AddressAndroidView view, final String town);
    void city(@Nullable final AddressAndroidView view, final String city);
    void postCode(@Nullable final AddressAndroidView view, final String postCode);
    void startEditAddressView(@Nullable final AddressAndroidView view);
}
