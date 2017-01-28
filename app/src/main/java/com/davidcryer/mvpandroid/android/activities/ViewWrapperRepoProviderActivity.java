package com.davidcryer.mvpandroid.android.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.davidcryer.mvpandroid.android.helpers.FragmentManagerHelper;
import com.davidcryer.mvpandroid.android.presenter.repositories.ViewWrapperRepository;
import com.davidcryer.mvpandroid.android.presenter.repositories.ViewWrapperRepositoryProvider;

class ViewWrapperRepoProviderActivity extends AppCompatActivity implements ViewWrapperRepositoryProvider {
    private final static String FRAGMENT_TAG_PRESENTER_REPO = "presenter_repo";
    private PresenterRepoFragment presenterRepoFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialisePresenterRepoFragment();
    }

    private void initialisePresenterRepoFragment() {
        presenterRepoFragment = (PresenterRepoFragment) getSupportFragmentManager().findFragmentByTag(FRAGMENT_TAG_PRESENTER_REPO);
        if (presenterRepoFragment == null) {
            presenterRepoFragment = PresenterRepoFragment.newInstance();
            FragmentManagerHelper.addFragment(getSupportFragmentManager(), presenterRepoFragment, FRAGMENT_TAG_PRESENTER_REPO);
        }
    }

    @Override
    public ViewWrapperRepository getPresenterRepository() {
        return presenterRepoFragment.getViewWrapperRepository();
    }
}
