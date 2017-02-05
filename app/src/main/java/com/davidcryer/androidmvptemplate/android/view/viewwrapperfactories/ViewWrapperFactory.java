package com.davidcryer.androidmvptemplate.android.view.viewwrapperfactories;

import android.os.Bundle;

import com.davidcryer.androidmvptemplate.android.view.ViewWrapper;
import com.davidcryer.androidmvptemplate.android.view.ui.TemplateAndroidView;

public interface ViewWrapperFactory {
    ViewWrapper<TemplateAndroidView, TemplateAndroidView.EventsListener> createTemplateViewWrapper();
    ViewWrapper<TemplateAndroidView, TemplateAndroidView.EventsListener> createTemplateViewWrapper(final Bundle savedState);
}
