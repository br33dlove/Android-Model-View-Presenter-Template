package com.davidcryer.mvpandroid.android.view.viewwrapperfactories;

import android.os.Bundle;

import com.davidcryer.mvpandroid.android.view.ViewWrapper;
import com.davidcryer.mvpandroid.android.view.ui.TemplateAndroidView;

public interface ViewWrapperFactory {
    ViewWrapper<TemplateAndroidView, TemplateAndroidView.EventsListener> createAddressViewWrapper();
    ViewWrapper<TemplateAndroidView, TemplateAndroidView.EventsListener> createAddressViewWrapper(final Bundle savedState);
}
