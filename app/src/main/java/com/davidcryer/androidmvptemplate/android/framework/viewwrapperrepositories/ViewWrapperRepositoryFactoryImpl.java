package com.davidcryer.androidmvptemplate.android.framework.viewwrapperrepositories;

import com.davidcryer.androidmvptemplate.android.view.viewwrapperfactories.ViewWrapperFactory;

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
