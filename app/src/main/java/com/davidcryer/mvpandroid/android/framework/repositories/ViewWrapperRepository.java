package com.davidcryer.mvpandroid.android.framework.repositories;

import android.os.Bundle;

import com.davidcryer.mvpandroid.android.view.ui.AddressAndroidView;
import com.davidcryer.mvpandroid.android.view.ui.EditAddressAndroidView;

public interface ViewWrapperRepository {
    AddressAndroidView.EventsListener bind(final AddressAndroidView view, final Bundle savedState);
    EditAddressAndroidView.EventsListener bind(final EditAddressAndroidView view, final Bundle savedState);
    void unbind(final AddressAndroidView view, final boolean isLeaving);
    void unbind(final EditAddressAndroidView view, final boolean isLeaving);
}
