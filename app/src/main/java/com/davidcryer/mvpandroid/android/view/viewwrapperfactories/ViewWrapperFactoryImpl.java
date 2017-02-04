package com.davidcryer.mvpandroid.android.view.viewwrapperfactories;

import android.os.Bundle;

import com.davidcryer.mvpandroid.android.view.TemplateViewWrapper;
import com.davidcryer.mvpandroid.android.view.ViewWrapper;
import com.davidcryer.mvpandroid.android.view.ui.TemplateAndroidView;
import com.davidcryer.mvpandroid.platformindependent.presenter.factories.PresenterFactory;

public class ViewWrapperFactoryImpl implements ViewWrapperFactory {
    private final PresenterFactory presenterFactory;

    private ViewWrapperFactoryImpl(final PresenterFactory presenterFactory) {
        this.presenterFactory = presenterFactory;
    }

    public static ViewWrapperFactoryImpl newInstance(final PresenterFactory presenterFactory) {
        return new ViewWrapperFactoryImpl(presenterFactory);
    }

    @Override
    public ViewWrapper<TemplateAndroidView, TemplateAndroidView.EventsListener> createAddressViewWrapper() {
        return TemplateViewWrapper.newInstance(presenterFactory);
    }

    @Override
    public ViewWrapper<TemplateAndroidView, TemplateAndroidView.EventsListener> createAddressViewWrapper(Bundle savedState) {
        return TemplateViewWrapper.retrieveInstanceOrGetNew(savedState, presenterFactory);
    }
}
