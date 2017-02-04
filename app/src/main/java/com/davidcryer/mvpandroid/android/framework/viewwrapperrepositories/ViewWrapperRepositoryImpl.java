package com.davidcryer.mvpandroid.android.framework.viewwrapperrepositories;

import android.os.Bundle;

import com.davidcryer.mvpandroid.android.view.ViewWrapper;
import com.davidcryer.mvpandroid.android.view.ui.TemplateAndroidView;
import com.davidcryer.mvpandroid.android.view.viewwrapperfactories.ViewWrapperFactory;

class ViewWrapperRepositoryImpl implements ViewWrapperRepository {
    private final ViewWrapperFactory viewWrapperFactory;
    private ViewWrapper<TemplateAndroidView, TemplateAndroidView.EventsListener> addressViewWrapper;

    private ViewWrapperRepositoryImpl(final ViewWrapperFactory viewWrapperFactory) {
        this.viewWrapperFactory = viewWrapperFactory;
    }

    static ViewWrapperRepository newInstance(final ViewWrapperFactory viewWrapperFactory) {
        return new ViewWrapperRepositoryImpl(viewWrapperFactory);
    }

    @Override
    public TemplateAndroidView.EventsListener bind(TemplateAndroidView view, Bundle savedState) {
        if (addressViewWrapper == null) {
            addressViewWrapper = savedState == null ? viewWrapperFactory.createAddressViewWrapper() : viewWrapperFactory.createAddressViewWrapper(savedState);
        }
        addressViewWrapper.register(view);
        return addressViewWrapper.viewEventsListener();
    }

    @Override
    public void unbind(TemplateAndroidView view, boolean isLeaving) {//TODO boolean needs changing - three options: config change, non-config change, view finished
        if (addressViewWrapper != null) {
            addressViewWrapper.unregister();
            if (isLeaving) {
                addressViewWrapper = null;
            }
        }
    }
}
