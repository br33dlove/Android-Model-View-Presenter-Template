package com.davidcryer.mvpandroid.android.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

import com.davidcryer.mvpandroid.android.view.models.AddressViewModel;
import com.davidcryer.mvpandroid.android.view.models.AddressAndroidViewModel;
import com.davidcryer.mvpandroid.android.view.helpers.AddressResultParameters;
import com.davidcryer.mvpandroid.android.view.ui.AddressAndroidView;
import com.davidcryer.mvpandroid.platformindependent.presenter.factories.PresenterFactory;
import com.davidcryer.mvpandroid.platformindependent.view.models.AddressMvpViewModel;
import com.davidcryer.mvpandroid.platformindependent.view.AddressView;

public class AddressViewWrapper extends ViewWrapper<AddressAndroidView, AddressAndroidView.EventsListener> {
    private final static String ARG_SAVED_STATE = AddressViewWrapper.class.getSimpleName();
    private final AddressAndroidViewModel viewModel;
    private final AddressView.EventsListener wrapperEventsListener;

    private AddressViewWrapper(
            final AddressAndroidViewModel viewModel,
            final PresenterFactory presenterFactory
    ) {
        this.viewModel = viewModel;
        wrapperEventsListener = presenterFactory.createAddressPresenter(viewWrapper).eventsListener();
    }

    public static ViewWrapper<AddressAndroidView, AddressAndroidView.EventsListener> newInstance(
            final PresenterFactory presenterFactory
    ) {
        return new AddressViewWrapper(newViewModel(), presenterFactory);
    }

    private static AddressAndroidViewModel newViewModel() {//TODO get passed through newInstance method
        return AddressViewModel.newInstance("", "", "", "", "");
    }

    public static ViewWrapper<AddressAndroidView, AddressAndroidView.EventsListener> retrieveInstanceOrGetNew(
            final Bundle savedState,
            final PresenterFactory presenterFactory
    ) {
        final AddressViewWrapper.StateSaver stateSaver = savedState.getParcelable(ARG_SAVED_STATE);
        return stateSaver == null ? newInstance(presenterFactory) : stateSaver.restoreViewState(presenterFactory);
    }

    private final AddressView viewWrapper = new AddressView() {

        @Override
        public AddressMvpViewModel viewModel() {
            return viewModel;
        }

        @Override
        public void showHouse(String house) {
            viewModel.house(view(), house);
        }

        @Override
        public void showStreet(String street) {
            viewModel.street(view(), street);
        }

        @Override
        public void showTown(String town) {
            viewModel.town(view(), town);
        }

        @Override
        public void showCity(String city) {
            viewModel.city(view(), city);
        }

        @Override
        public void showPostCode(String postCode) {
            viewModel.postCode(view(), postCode);
        }

        @Override
        public void startEditAddressView() {
            viewModel.startEditAddressView(view());
        }
    };

    @Override
    public void saveInstance(final Bundle outState) {
        outState.putParcelable(ARG_SAVED_STATE, new AddressViewWrapper.StateSaver(viewModel));
    }

    @Override
    protected void showCurrentState(final AddressAndroidView view) {
        viewModel.onto(view);
    }

    @Override
    public AddressAndroidView.EventsListener viewEventsListener() {
        return new AddressAndroidView.EventsListener() {

            @Override
            public void onClickEdit() {
                wrapperEventsListener.onClickEdit();
            }

            @Override
            public void onReturnResult(int requestCode, int resultCode, Intent intent) {
                final String house = intent.getStringExtra(AddressResultParameters.KEY_HOUSE);
                final String street = intent.getStringExtra(AddressResultParameters.KEY_STREET);
                final String town = intent.getStringExtra(AddressResultParameters.KEY_TOWN);
                final String city = intent.getStringExtra(AddressResultParameters.KEY_CITY);
                final String postCode = intent.getStringExtra(AddressResultParameters.KEY_POST_CODE);
                wrapperEventsListener.onReturnAddress(house, street, town, city, postCode);
            }
        };
    }

    private static class StateSaver implements Parcelable {
        private final AddressAndroidViewModel viewModel;

        private StateSaver(final AddressAndroidViewModel viewModel) {
            this.viewModel = viewModel;
        }

        private StateSaver(final Parcel parcel) {
            viewModel = parcel.readParcelable(AddressViewModel.class.getClassLoader());
        }

        private AddressViewWrapper restoreViewState(final PresenterFactory presenterFactory) {
            return new AddressViewWrapper(viewModel, presenterFactory);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeParcelable(viewModel, PARCELABLE_WRITE_RETURN_VALUE);//TODO check flag
        }

        final static Creator<AddressViewWrapper.StateSaver> CREATOR = new Creator<AddressViewWrapper.StateSaver>() {
            @Override
            public AddressViewWrapper.StateSaver createFromParcel(Parcel source) {
                return new AddressViewWrapper.StateSaver(source);
            }

            @Override
            public AddressViewWrapper.StateSaver[] newArray(int size) {
                return new AddressViewWrapper.StateSaver[size];
            }
        };
    }
}
