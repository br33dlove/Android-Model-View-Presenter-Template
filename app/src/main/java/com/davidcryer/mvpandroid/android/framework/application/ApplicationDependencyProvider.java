package com.davidcryer.mvpandroid.android.framework.application;

import com.davidcryer.mvpandroid.android.view.factories.ViewWrapperFactory;
import com.davidcryer.mvpandroid.android.view.factories.ViewWrapperFactoryImpl;
import com.davidcryer.mvpandroid.platformindependent.presenter.businesslogic.validators.ValidationResultFactory;
import com.davidcryer.mvpandroid.platformindependent.presenter.businesslogic.validators.ValidationResultFactoryImpl;
import com.davidcryer.mvpandroid.platformindependent.presenter.factories.PresenterFactory;
import com.davidcryer.mvpandroid.platformindependent.presenter.factories.PresenterFactoryImpl;
import com.davidcryer.mvpandroid.android.framework.repositories.ViewWrapperRepositoryFactory;
import com.davidcryer.mvpandroid.android.framework.repositories.ViewWrapperRepositoryFactoryImpl;

class ApplicationDependencyProvider {

    static ViewWrapperRepositoryFactory viewWrapperRepositoryFactory() {
        return ViewWrapperRepositoryFactoryImpl.newInstance(createViewStateFactory());
    }

    private static ViewWrapperFactory createViewStateFactory() {
        return ViewWrapperFactoryImpl.newInstance(createPresenterFactory());
    }

    private static PresenterFactory createPresenterFactory() {
        return PresenterFactoryImpl.newInstance(createValidationResultFactory());
    }

    private static ValidationResultFactory createValidationResultFactory() {
        return ValidationResultFactoryImpl.newInstance();
    }
}