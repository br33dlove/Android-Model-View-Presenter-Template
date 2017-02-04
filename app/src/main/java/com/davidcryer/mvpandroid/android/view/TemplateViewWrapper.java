package com.davidcryer.mvpandroid.android.view;

import android.os.Bundle;

import com.davidcryer.mvpandroid.android.view.models.TemplateAndroidViewModel;
import com.davidcryer.mvpandroid.android.view.models.factories.TemplateAndroidViewModelFactory;
import com.davidcryer.mvpandroid.android.view.ui.TemplateAndroidView;
import com.davidcryer.mvpandroid.platformindependent.presenter.factories.PresenterFactory;
import com.davidcryer.mvpandroid.platformindependent.view.TemplateView;
import com.davidcryer.mvpandroid.platformindependent.view.models.TemplateMvpViewModel;

public class TemplateViewWrapper extends ViewWrapper<TemplateAndroidView, TemplateAndroidView.EventsListener> {
    private final static String ARG_VIEW_MODEL = TemplateViewWrapper.class.getSimpleName();
    private final TemplateAndroidViewModel viewModel;
    private final TemplateView.EventsListener wrapperEventsListener;

    private TemplateViewWrapper(final PresenterFactory presenterFactory, final TemplateAndroidViewModel viewModel) {
        wrapperEventsListener = presenterFactory.createAddressPresenter(viewWrapper()).eventsListener();
        this.viewModel = viewModel;
    }

    public static ViewWrapper<TemplateAndroidView, TemplateAndroidView.EventsListener> newInstance(
            final PresenterFactory presenterFactory,
            final TemplateAndroidViewModelFactory viewModelFactory
    ) {
        return new TemplateViewWrapper(presenterFactory, viewModelFactory.create());
    }

    public static ViewWrapper<TemplateAndroidView, TemplateAndroidView.EventsListener> retrieveInstanceOrGetNew(
            final Bundle savedState,
            final PresenterFactory presenterFactory,
            final TemplateAndroidViewModelFactory viewModelFactory
    ) {
        final TemplateAndroidViewModel viewModel = savedState.getParcelable(ARG_VIEW_MODEL);
        return new TemplateViewWrapper(presenterFactory, viewModel == null ? viewModelFactory.create() : viewModel);
    }

    private TemplateView viewWrapper() {
        return new TemplateView() {

            @Override
            public void someScreenChange() {
                viewModel.screenChanged(view());
            }

            @Override
            public TemplateMvpViewModel viewModel() {
                return viewModel;
            }
        };
    }

    @Override
    public TemplateAndroidView.EventsListener viewEventsListener() {
        return new TemplateAndroidView.EventsListener() {

            @Override
            public void someEvent() {
                wrapperEventsListener.someEvent();
            }

            @Override
            public void onSaveInstance(final Bundle outState) {
                outState.putParcelable(ARG_VIEW_MODEL, viewModel);
            }
        };
    }

    @Override
    protected void showCurrentState(final TemplateAndroidView view) {
        viewModel.onto(view);
    }

    @Override
    public void releaseResources() {
        wrapperEventsListener.onReleaseResources();
    }
}
