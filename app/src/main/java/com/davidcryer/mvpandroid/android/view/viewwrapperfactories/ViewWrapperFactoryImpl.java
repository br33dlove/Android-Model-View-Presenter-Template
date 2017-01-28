package com.davidcryer.mvpandroid.android.view.viewwrapperfactories;

import android.os.Bundle;

import com.davidcryer.mvpandroid.android.view.ViewWrapper;
import com.davidcryer.mvpandroid.android.view.AddressViewWrapper;
import com.davidcryer.mvpandroid.android.view.ui.AddressAndroidView;
import com.davidcryer.mvpandroid.android.view.ui.EditAddressAndroidView;
import com.davidcryer.mvpandroid.platformindependent.presenter.factories.PresenterFactory;
import com.davidcryer.mvpandroid.android.view.EditAddressViewWrapper;

public class ViewWrapperFactoryImpl implements ViewWrapperFactory {
    private final PresenterFactory presenterFactory;

    private ViewWrapperFactoryImpl(final PresenterFactory presenterFactory) {
        this.presenterFactory = presenterFactory;
    }

    public static ViewWrapperFactoryImpl newInstance(final PresenterFactory presenterFactory) {
        return new ViewWrapperFactoryImpl(presenterFactory);
    }

    @Override
    public ViewWrapper<AddressAndroidView, AddressAndroidView.EventsListener> createAddressViewWrapper() {
        return AddressViewWrapper.newInstance(presenterFactory);
    }

    @Override
    public ViewWrapper<AddressAndroidView, AddressAndroidView.EventsListener> createAddressViewWrapper(Bundle savedState) {
        return AddressViewWrapper.retrieveInstanceOrGetNew(savedState, presenterFactory);
    }

    @Override
    public ViewWrapper<EditAddressAndroidView, EditAddressAndroidView.EventsListener> createEditAddressViewWrapper() {
        return EditAddressViewWrapper.newInstance(presenterFactory);
    }

    @Override
    public ViewWrapper<EditAddressAndroidView, EditAddressAndroidView.EventsListener> createEditAddressViewWrapper(Bundle savedState) {
        return EditAddressViewWrapper.retrieveInstanceOrGetNew(savedState, presenterFactory);
    }
}
