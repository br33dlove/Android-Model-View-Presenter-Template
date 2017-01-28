package com.davidcryer.mvpandroid.android.application;

import android.app.Application;

import com.davidcryer.mvpandroid.android.presenter.repositories.ViewWrapperRepositoryFactory;
import com.davidcryer.mvpandroid.android.presenter.repositories.ViewWrapperRepositoryFactoryProvider;

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
