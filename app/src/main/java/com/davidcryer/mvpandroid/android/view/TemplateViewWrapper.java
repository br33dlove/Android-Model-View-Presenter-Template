package com.davidcryer.mvpandroid.android.view;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

import com.davidcryer.mvpandroid.android.view.models.TemplateAndroidViewModel;
import com.davidcryer.mvpandroid.android.view.models.TemplateViewModel;
import com.davidcryer.mvpandroid.android.view.ui.TemplateAndroidView;
import com.davidcryer.mvpandroid.platformindependent.presenter.factories.PresenterFactory;
import com.davidcryer.mvpandroid.platformindependent.view.TemplateView;
import com.davidcryer.mvpandroid.platformindependent.view.models.TemplateMvpViewModel;

public class TemplateViewWrapper extends ViewWrapper<TemplateAndroidView, TemplateAndroidView.EventsListener> {
    private final static String ARG_SAVED_STATE = TemplateViewWrapper.class.getSimpleName();
    private final TemplateAndroidViewModel viewModel;
    private final TemplateView.EventsListener wrapperEventsListener;

    private TemplateViewWrapper(
            final TemplateAndroidViewModel viewModel,
            final PresenterFactory presenterFactory
    ) {
        this.viewModel = viewModel;
        wrapperEventsListener = presenterFactory.createAddressPresenter(viewWrapper).eventsListener();
    }

    public static ViewWrapper<TemplateAndroidView, TemplateAndroidView.EventsListener> newInstance(
            final PresenterFactory presenterFactory
    ) {
        return new TemplateViewWrapper(newViewModel(), presenterFactory);
    }

    private static TemplateAndroidViewModel newViewModel() {//TODO get passed through newInstance method
        return TemplateViewModel.newInstance();
    }

    public static ViewWrapper<TemplateAndroidView, TemplateAndroidView.EventsListener> retrieveInstanceOrGetNew(
            final Bundle savedState,
            final PresenterFactory presenterFactory
    ) {
        final TemplateViewWrapper.StateSaver stateSaver = savedState.getParcelable(ARG_SAVED_STATE);
        return stateSaver == null ? newInstance(presenterFactory) : stateSaver.restoreViewState(presenterFactory);
    }

    private final TemplateView viewWrapper = new TemplateView() {

        @Override
        public TemplateMvpViewModel viewModel() {
            return viewModel;
        }
    };

    @Override
    public void saveInstance(final Bundle outState) {
        outState.putParcelable(ARG_SAVED_STATE, new TemplateViewWrapper.StateSaver(viewModel));
    }

    @Override
    protected void showCurrentState(final TemplateAndroidView view) {
        viewModel.onto(view);
    }

    @Override
    public TemplateAndroidView.EventsListener viewEventsListener() {
        return new TemplateAndroidView.EventsListener() {

        };
    }

    private static class StateSaver implements Parcelable {
        private final TemplateAndroidViewModel viewModel;

        private StateSaver(final TemplateAndroidViewModel viewModel) {
            this.viewModel = viewModel;
        }

        private StateSaver(final Parcel parcel) {
            viewModel = parcel.readParcelable(TemplateViewModel.class.getClassLoader());
        }

        private TemplateViewWrapper restoreViewState(final PresenterFactory presenterFactory) {
            return new TemplateViewWrapper(viewModel, presenterFactory);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeParcelable(viewModel, PARCELABLE_WRITE_RETURN_VALUE);//TODO check flag
        }

        final static Creator<TemplateViewWrapper.StateSaver> CREATOR = new Creator<TemplateViewWrapper.StateSaver>() {
            @Override
            public TemplateViewWrapper.StateSaver createFromParcel(Parcel source) {
                return new TemplateViewWrapper.StateSaver(source);
            }

            @Override
            public TemplateViewWrapper.StateSaver[] newArray(int size) {
                return new TemplateViewWrapper.StateSaver[size];
            }
        };
    }
}
