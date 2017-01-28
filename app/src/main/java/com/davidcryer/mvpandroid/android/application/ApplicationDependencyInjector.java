package com.davidcryer.mvpandroid.android.application;

import com.davidcryer.mvpandroid.android.presenter.factories.ViewWrapperFactory;
import com.davidcryer.mvpandroid.android.presenter.factories.ViewWrapperFactoryImpl;
import com.davidcryer.mvpandroid.platformindependent.presenter.businesslogic.validators.ValidationResultFactory;
import com.davidcryer.mvpandroid.platformindependent.presenter.businesslogic.validators.ValidationResultFactoryImpl;
import com.davidcryer.mvpandroid.platformindependent.presenter.factories.PresenterFactory;
import com.davidcryer.mvpandroid.platformindependent.presenter.factories.PresenterFactoryImpl;
import com.davidcryer.mvpandroid.android.presenter.repositories.ViewWrapperRepositoryFactory;
import com.davidcryer.mvpandroid.android.presenter.repositories.ViewWrapperRepositoryFactoryImpl;

class ApplicationDependencyInjector {

    static void inject(final MvpApplication application) {
        application.viewWrapperRepositoryFactory = createPresenterRepositoryFactory();
    }

    private static ViewWrapperRepositoryFactory createPresenterRepositoryFactory() {
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
