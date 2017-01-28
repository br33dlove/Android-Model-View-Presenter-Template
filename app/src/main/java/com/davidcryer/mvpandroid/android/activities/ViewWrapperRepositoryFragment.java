package com.davidcryer.mvpandroid.android.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.davidcryer.mvpandroid.platformindependent.javahelpers.CastHelper;
import com.davidcryer.mvpandroid.android.presenter.repositories.ViewWrapperRepository;
import com.davidcryer.mvpandroid.android.presenter.repositories.ViewWrapperRepositoryFactory;
import com.davidcryer.mvpandroid.android.presenter.repositories.ViewWrapperRepositoryFactoryProvider;

class ViewWrapperRepositoryFragment extends Fragment {
    private ViewWrapperRepository viewWrapperRepository;

    public static ViewWrapperRepositoryFragment newInstance() {
        return new ViewWrapperRepositoryFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        initialisePresenterRepository();
    }

    private void initialisePresenterRepository() {
        viewWrapperRepository = viewWrapperRepositoryFactory().create();
    }

    private ViewWrapperRepositoryFactory viewWrapperRepositoryFactory() {
        return viewWrapperRepositoryFactoryProvider().viewWrapperRepositoryFactory();
    }

    private ViewWrapperRepositoryFactoryProvider viewWrapperRepositoryFactoryProvider() {
        return CastHelper.riskyCastToInterface(getActivity().getApplication(), ViewWrapperRepositoryFactoryProvider.class);
    }

    ViewWrapperRepository viewWrapperRepository() {
        return viewWrapperRepository;
    }
}
