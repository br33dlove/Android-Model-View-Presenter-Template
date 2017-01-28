package com.davidcryer.mvpandroid.android.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.davidcryer.mvpandroid.android.helpers.FragmentManagerHelper;
import com.davidcryer.mvpandroid.android.presenter.repositories.ViewWrapperRepository;
import com.davidcryer.mvpandroid.android.presenter.repositories.ViewWrapperRepositoryFactory;
import com.davidcryer.mvpandroid.android.presenter.repositories.ViewWrapperRepositoryFactoryProvider;
import com.davidcryer.mvpandroid.android.presenter.repositories.ViewWrapperRepositoryProvider;
import com.davidcryer.mvpandroid.platformindependent.javahelpers.CastHelper;

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

    static class ViewWrapperRepositoryFragment extends Fragment {
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
}
