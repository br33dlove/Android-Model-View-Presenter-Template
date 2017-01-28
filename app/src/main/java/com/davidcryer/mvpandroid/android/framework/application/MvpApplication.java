package com.davidcryer.mvpandroid.android.framework.application;

import android.app.Application;

import com.davidcryer.mvpandroid.android.framework.viewwrapperrepositories.ViewWrapperRepositoryFactory;
import com.davidcryer.mvpandroid.android.framework.viewwrapperrepositories.ViewWrapperRepositoryFactoryProvider;

public class MvpApplication extends Application implements ViewWrapperRepositoryFactoryProvider {
    private final ViewWrapperRepositoryFactory viewWrapperRepositoryFactory;

    public MvpApplication() {
        super();
        viewWrapperRepositoryFactory = ApplicationDependencyProvider.viewWrapperRepositoryFactory();
    }

    @Override
    public ViewWrapperRepositoryFactory viewWrapperRepositoryFactory() {
        return viewWrapperRepositoryFactory;
    }
}
