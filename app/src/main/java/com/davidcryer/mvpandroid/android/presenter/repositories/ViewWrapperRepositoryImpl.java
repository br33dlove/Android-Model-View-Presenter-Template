package com.davidcryer.mvpandroid.android.presenter.repositories;

import android.os.Bundle;

import com.davidcryer.mvpandroid.android.view.ViewWrapper;
import com.davidcryer.mvpandroid.android.view.ui.AddressAndroidView;
import com.davidcryer.mvpandroid.android.view.ui.EditAddressAndroidView;
import com.davidcryer.mvpandroid.android.presenter.factories.ViewWrapperFactory;

class ViewWrapperRepositoryImpl implements ViewWrapperRepository {
    private final ViewWrapperFactory viewWrapperFactory;
    private ViewWrapper<AddressAndroidView, AddressAndroidView.EventsListener> addressViewWrapper;
    private ViewWrapper<EditAddressAndroidView, EditAddressAndroidView.EventsListener> editAddressViewWrapper;

    private ViewWrapperRepositoryImpl(final ViewWrapperFactory viewWrapperFactory) {
        this.viewWrapperFactory = viewWrapperFactory;
    }

    static ViewWrapperRepository newInstance(final ViewWrapperFactory viewWrapperFactory) {
        return new ViewWrapperRepositoryImpl(viewWrapperFactory);
    }

    @Override
    public AddressAndroidView.EventsListener bind(AddressAndroidView view, Bundle savedState) {
        if (addressViewWrapper == null) {
            addressViewWrapper = savedState == null ? viewWrapperFactory.createAddressViewWrapper() : viewWrapperFactory.createAddressViewWrapper(savedState);
        }
        addressViewWrapper.register(view);
        return addressViewWrapper.viewEventsListener();
    }

    @Override
    public EditAddressAndroidView.EventsListener bind(EditAddressAndroidView view, Bundle savedState) {
        if (editAddressViewWrapper == null) {
            editAddressViewWrapper = savedState == null ? viewWrapperFactory.createEditAddressViewWrapper() : viewWrapperFactory.createEditAddressViewWrapper(savedState);
        }
        editAddressViewWrapper.register(view);
        return editAddressViewWrapper.viewEventsListener();
    }

    @Override
    public void unbind(AddressAndroidView view, boolean isLeaving) {//TODO boolean needs changing - three options: config change, non-config change, view finished
        if (addressViewWrapper != null) {
            addressViewWrapper.unregister();
            if (isLeaving) {
                addressViewWrapper = null;
            }
        }
    }

    @Override
    public void unbind(EditAddressAndroidView view, boolean isLeaving) {
        if (editAddressViewWrapper != null) {
            editAddressViewWrapper.unregister();
            if (isLeaving) {
                editAddressViewWrapper = null;
            }
        }
    }
}
