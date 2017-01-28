package com.davidcryer.mvpandroid.android.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.davidcryer.mvpandroid.android.helpers.FragmentManagerHelper;
import com.davidcryer.mvpandroid.android.presenter.repositories.ViewWrapperRepository;
import com.davidcryer.mvpandroid.android.presenter.repositories.ViewWrapperRepositoryProvider;

class ViewWrapperRepositoryProviderActivity extends AppCompatActivity implements ViewWrapperRepositoryProvider {
    private final static String FRAGMENT_TAG_VIEW_WRAPPER_REPOSITORY = "view wrapper repository";
    private ViewWrapperRepositoryFragment viewWrapperRepositoryFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialisePresenterRepoFragment();
    }

    private void initialisePresenterRepoFragment() {
        viewWrapperRepositoryFragment = (ViewWrapperRepositoryFragment) getSupportFragmentManager().findFragmentByTag(FRAGMENT_TAG_VIEW_WRAPPER_REPOSITORY);
        if (viewWrapperRepositoryFragment == null) {
            viewWrapperRepositoryFragment = ViewWrapperRepositoryFragment.newInstance();
            FragmentManagerHelper.addFragment(getSupportFragmentManager(), viewWrapperRepositoryFragment, FRAGMENT_TAG_VIEW_WRAPPER_REPOSITORY);
        }
    }

    @Override
    public ViewWrapperRepository viewWrapperRepository() {
        return viewWrapperRepositoryFragment.viewWrapperRepository();
    }
}
