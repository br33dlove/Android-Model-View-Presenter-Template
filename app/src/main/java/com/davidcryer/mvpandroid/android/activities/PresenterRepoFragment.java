package com.davidcryer.mvpandroid.android.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.davidcryer.mvpandroid.platformindependent.javahelpers.CastHelper;
import com.davidcryer.mvpandroid.android.presenter.repositories.ViewWrapperRepository;
import com.davidcryer.mvpandroid.android.presenter.repositories.ViewWrapperRepositoryFactory;
import com.davidcryer.mvpandroid.android.presenter.repositories.ViewWrapperRepositoryFactoryProvider;

@SuppressLint("ValidFragment")//TODO check if valid to have package-private fragment (may cause trouble with FragmentManager?)
class PresenterRepoFragment extends Fragment {
    private ViewWrapperRepository viewWrapperRepository;

    public static PresenterRepoFragment newInstance() {
        return new PresenterRepoFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        initialisePresenterRepository();
    }

    private void initialisePresenterRepository() {
        viewWrapperRepository = getPresenterRepositoryFactory().create();
    }

    private ViewWrapperRepositoryFactory getPresenterRepositoryFactory() {
        return getPresenterRepositoryFactoryProvider().providePresenterRepositoryFactory();
    }

    private ViewWrapperRepositoryFactoryProvider getPresenterRepositoryFactoryProvider() {
        return CastHelper.riskyCastToInterface(getActivity().getApplication(), ViewWrapperRepositoryFactoryProvider.class);
    }

    ViewWrapperRepository getViewWrapperRepository() {
        return viewWrapperRepository;
    }
}
