package com.davidcryer.androidmvptemplate.android.framework.application;

import com.davidcryer.androidmvptemplate.android.framework.viewwrapperrepositories.ViewWrapperRepositoryFactory;
import com.davidcryer.androidmvptemplate.android.framework.viewwrapperrepositories.ViewWrapperRepositoryFactoryImpl;
import com.davidcryer.androidmvptemplate.android.view.models.factories.TemplateAndroidViewModelFactory;
import com.davidcryer.androidmvptemplate.android.view.models.factories.TemplateAndroidViewModelFactoryImpl;
import com.davidcryer.androidmvptemplate.android.view.viewwrapperfactories.ViewWrapperFactory;
import com.davidcryer.androidmvptemplate.android.view.viewwrapperfactories.ViewWrapperFactoryImpl;
import com.davidcryer.androidmvptemplate.platformindependent.presenter.factories.PresenterFactory;
import com.davidcryer.androidmvptemplate.platformindependent.presenter.factories.PresenterFactoryImpl;

class ApplicationDependencyProvider {

    static ViewWrapperRepositoryFactory viewWrapperRepositoryFactory() {
        return ViewWrapperRepositoryFactoryImpl.newInstance(createViewStateFactory());
    }

    private static ViewWrapperFactory createViewStateFactory() {
        return ViewWrapperFactoryImpl.newInstance(createPresenterFactory(), createTemplateAndroidViewModelFactory());
    }

    private static PresenterFactory createPresenterFactory() {
        return PresenterFactoryImpl.newInstance();
    }

    private static TemplateAndroidViewModelFactory createTemplateAndroidViewModelFactory() {
        return TemplateAndroidViewModelFactoryImpl.newInstance();
    }
}
