package com.davidcryer.androidmvptemplate.android.view.viewwrapperfactories;

import android.os.Bundle;

import com.davidcryer.androidmvptemplate.android.view.TemplateViewWrapper;
import com.davidcryer.androidmvptemplate.android.view.ViewWrapper;
import com.davidcryer.androidmvptemplate.android.view.models.factories.TemplateAndroidViewModelFactory;
import com.davidcryer.androidmvptemplate.android.view.ui.TemplateAndroidView;
import com.davidcryer.androidmvptemplate.platformindependent.presenter.factories.PresenterFactory;

public class ViewWrapperFactoryImpl implements ViewWrapperFactory {
    private final PresenterFactory presenterFactory;
    private final TemplateAndroidViewModelFactory templateViewModelFactory;

    private ViewWrapperFactoryImpl(
            final PresenterFactory presenterFactory,
            final TemplateAndroidViewModelFactory templateViewModelFactory
    ) {
        this.presenterFactory = presenterFactory;
        this.templateViewModelFactory = templateViewModelFactory;
    }

    public static ViewWrapperFactoryImpl newInstance(
            final PresenterFactory presenterFactory,
            final TemplateAndroidViewModelFactory templateViewModelFactory
    ) {
        return new ViewWrapperFactoryImpl(presenterFactory, templateViewModelFactory);
    }

    @Override
    public ViewWrapper<TemplateAndroidView, TemplateAndroidView.EventsListener> createTemplateViewWrapper() {
        return TemplateViewWrapper.newInstance(presenterFactory, templateViewModelFactory);
    }

    @Override
    public ViewWrapper<TemplateAndroidView, TemplateAndroidView.EventsListener> createTemplateViewWrapper(Bundle savedState) {
        return TemplateViewWrapper.retrieveInstanceOrGetNew(savedState, presenterFactory, templateViewModelFactory);
    }
}
