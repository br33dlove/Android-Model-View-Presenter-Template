package com.davidcryer.mvpandroid.android.view.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.davidcryer.mvpandroid.android.framework.viewwrapperrepositories.ViewWrapperRepository;
import com.davidcryer.mvpandroid.android.framework.activities.ViewWrapperRepositoryProvider;
import com.davidcryer.mvpandroid.platformindependent.javahelpers.CastHelper;
import com.davidcryer.mvpandroid.android.view.ui.AndroidMvpView;

abstract class ViewBindingFragment<EventsListenerType extends AndroidMvpView.EventsListener> extends Fragment {
    private ViewWrapperRepository viewWrapperRepository;
    EventsListenerType eventsListener;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialiseViewWrapperRepositoryReference();
        eventsListener = bind(viewWrapperRepository, savedInstanceState);
    }

    private void initialiseViewWrapperRepositoryReference() {
        viewWrapperRepository = getViewWrapperRepository();
    }

    private ViewWrapperRepository getViewWrapperRepository() {
        return getViewWrapperRepositoryProvider().viewWrapperRepository();
    }

    private ViewWrapperRepositoryProvider getViewWrapperRepositoryProvider() {
        return CastHelper.riskyCastToInterface(getActivity(), ViewWrapperRepositoryProvider.class);
    }

    abstract EventsListenerType bind(final ViewWrapperRepository viewWrapperRepository, final Bundle savedState);

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbind(viewWrapperRepository, !getActivity().isChangingConfigurations());
    }

    abstract void unbind(final ViewWrapperRepository viewWrapperRepository, final boolean isLeaving);
}
