package com.davidcryer.androidmvptemplate.android.view.models.factories;

import com.davidcryer.androidmvptemplate.android.view.models.TemplateAndroidViewModel;
import com.davidcryer.androidmvptemplate.android.view.models.TemplateViewModel;

public class TemplateAndroidViewModelFactoryImpl implements TemplateAndroidViewModelFactory {
    private final static boolean DEFAULT_SCREEN_CHANGED = false;

    private TemplateAndroidViewModelFactoryImpl() {

    }

    public static TemplateAndroidViewModelFactory newInstance() {
        return new TemplateAndroidViewModelFactoryImpl();
    }

    @Override
    public TemplateAndroidViewModel create() {
        return TemplateViewModel.newInstance(DEFAULT_SCREEN_CHANGED);
    }
}
