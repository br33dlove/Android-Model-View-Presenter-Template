package com.davidcryer.mvpandroid.android.presenter.repositories;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.davidcryer.mvpandroid.platformindependent.javahelpers.CastHelper;
import com.davidcryer.mvpandroid.android.view.ui.AndroidMvpView;

public abstract class ViewBindingFragment<EventsListenerType extends AndroidMvpView.EventsListener> extends Fragment {
    private ViewWrapperRepository viewWrapperRepository;
    protected EventsListenerType eventsListener;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialisePresenterRepository();
        eventsListener = bind(viewWrapperRepository, savedInstanceState);
    }

    private void initialisePresenterRepository() {
        viewWrapperRepository = getViewWrapperRepository();
    }

    private ViewWrapperRepository getViewWrapperRepository() {
        return getPresenterRepositoryProvider().viewWrapperRepository();
    }

    private ViewWrapperRepositoryProvider getPresenterRepositoryProvider() {
        return CastHelper.riskyCastToInterface(getActivity(), ViewWrapperRepositoryProvider.class);
    }

    protected abstract EventsListenerType bind(final ViewWrapperRepository viewWrapperRepository, final Bundle savedState);

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbind(viewWrapperRepository, !getActivity().isChangingConfigurations());
    }

    protected abstract void unbind(final ViewWrapperRepository viewWrapperRepository, final boolean isLeaving);
}
