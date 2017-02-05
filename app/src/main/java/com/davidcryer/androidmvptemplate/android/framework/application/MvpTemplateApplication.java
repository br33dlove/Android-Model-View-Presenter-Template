package com.davidcryer.androidmvptemplate.android.framework.application;

import android.app.Application;

import com.davidcryer.androidmvptemplate.android.framework.viewwrapperrepositories.ViewWrapperRepositoryFactory;

public class MvpTemplateApplication extends Application implements ViewWrapperRepositoryFactoryProvider {
    private final ViewWrapperRepositoryFactory viewWrapperRepositoryFactory;

    public MvpTemplateApplication() {
        super();
        viewWrapperRepositoryFactory = ApplicationDependencyProvider.viewWrapperRepositoryFactory();
    }

    @Override
    public ViewWrapperRepositoryFactory viewWrapperRepositoryFactory() {
        return viewWrapperRepositoryFactory;
    }
}
