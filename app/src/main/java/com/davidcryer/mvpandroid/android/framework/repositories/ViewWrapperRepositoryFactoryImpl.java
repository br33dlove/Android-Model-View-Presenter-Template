package com.davidcryer.mvpandroid.android.framework.repositories;

import com.davidcryer.mvpandroid.android.view.factories.ViewWrapperFactory;

public class ViewWrapperRepositoryFactoryImpl implements ViewWrapperRepositoryFactory {
    private final ViewWrapperFactory viewWrapperFactory;

    private ViewWrapperRepositoryFactoryImpl(final ViewWrapperFactory viewWrapperFactory) {
        this.viewWrapperFactory = viewWrapperFactory;
    }

    public static ViewWrapperRepositoryFactory newInstance(final ViewWrapperFactory viewWrapperFactory) {
        return new ViewWrapperRepositoryFactoryImpl(viewWrapperFactory);
    }

    @Override
    public ViewWrapperRepository create() {
        return ViewWrapperRepositoryImpl.newInstance(viewWrapperFactory);
    }
}