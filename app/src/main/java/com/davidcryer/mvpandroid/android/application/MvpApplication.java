package com.davidcryer.mvpandroid.android.application;

import android.app.Application;

import com.davidcryer.mvpandroid.android.presenter.repositories.ViewWrapperRepositoryFactory;
import com.davidcryer.mvpandroid.android.presenter.repositories.ViewWrapperRepositoryFactoryProvider;

public class MvpApplication extends Application implements ViewWrapperRepositoryFactoryProvider {
    ViewWrapperRepositoryFactory viewWrapperRepositoryFactory;

    @Override
    public void onCreate() {
        super.onCreate();
        ApplicationDependencyInjector.inject(this);
    }

    @Override
    public ViewWrapperRepositoryFactory providePresenterRepositoryFactory() {
        return viewWrapperRepositoryFactory;
    }
}
