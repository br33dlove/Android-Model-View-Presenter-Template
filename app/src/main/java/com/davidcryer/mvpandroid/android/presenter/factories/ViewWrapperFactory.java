package com.davidcryer.mvpandroid.android.presenter.factories;

import android.os.Bundle;

import com.davidcryer.mvpandroid.android.view.ViewWrapper;
import com.davidcryer.mvpandroid.android.view.ui.AddressAndroidView;
import com.davidcryer.mvpandroid.android.view.ui.EditAddressAndroidView;

public interface ViewWrapperFactory {
    ViewWrapper<AddressAndroidView, AddressAndroidView.EventsListener> createAddressViewWrapper();
    ViewWrapper<AddressAndroidView, AddressAndroidView.EventsListener> createAddressViewWrapper(final Bundle savedState);
    ViewWrapper<EditAddressAndroidView, EditAddressAndroidView.EventsListener> createEditAddressViewWrapper();
    ViewWrapper<EditAddressAndroidView, EditAddressAndroidView.EventsListener> createEditAddressViewWrapper(final Bundle savedState);
}
