package com.davidcryer.androidmvptemplate.android.view.models;

import com.davidcryer.androidmvptemplate.android.view.ui.TemplateAndroidView;
import com.davidcryer.androidmvptemplate.platformindependent.view.models.TemplateMvpViewModel;

public interface TemplateAndroidViewModel extends TemplateMvpViewModel, AndroidViewModel<TemplateAndroidView> {
    void screenChanged(final TemplateAndroidView view);
}
