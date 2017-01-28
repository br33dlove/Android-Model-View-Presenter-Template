package com.davidcryer.mvpandroid.android.view;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

import com.davidcryer.mvpandroid.android.view.models.EditAddressViewModel;
import com.davidcryer.mvpandroid.android.view.models.EditAddressAndroidViewModel;
import com.davidcryer.mvpandroid.android.view.ui.EditAddressAndroidView;
import com.davidcryer.mvpandroid.platformindependent.presenter.factories.PresenterFactory;
import com.davidcryer.mvpandroid.platformindependent.view.models.EditAddressMvpViewModel;
import com.davidcryer.mvpandroid.platformindependent.view.EditAddressView;

public class EditAddressViewWrapper extends ViewWrapper<EditAddressAndroidView, EditAddressAndroidView.EventsListener> {
    private final static String ARG_SAVED_STATE = EditAddressViewWrapper.class.getSimpleName();
    private final EditAddressAndroidViewModel viewModel;
    private final EditAddressView.EventsListener wrapperEventsListener;

    private EditAddressViewWrapper(
            final EditAddressAndroidViewModel viewModel,
            final PresenterFactory presenterFactory
    ) {
        this.viewModel = viewModel;
        wrapperEventsListener = presenterFactory.createEditAddressPresenter(viewWrapper).eventsListener();
    }

    public static ViewWrapper<EditAddressAndroidView, EditAddressAndroidView.EventsListener> newInstance(
            final PresenterFactory presenterFactory
    ) {
        return new EditAddressViewWrapper(newAddress(), presenterFactory);
    }

    private static EditAddressAndroidViewModel newAddress() {//TODO move this to outside class
        return EditAddressViewModel.newInstance("", "", "", "", "");
    }

    public static ViewWrapper<EditAddressAndroidView, EditAddressAndroidView.EventsListener> retrieveInstanceOrGetNew(
            final Bundle savedState,
            final PresenterFactory presenterFactory
    ) {
        final StateSaver stateSaver = savedState.getParcelable(ARG_SAVED_STATE);
        return stateSaver == null ? newInstance(presenterFactory) : stateSaver.restoreViewState(presenterFactory);
    }

    @Override
    protected void showCurrentState(final EditAddressAndroidView view) {
        viewModel.onto(view);
    }

    private final EditAddressView viewWrapper = new EditAddressView() {

        @Override
        public EditAddressMvpViewModel viewModel() {
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
        public void showHouseError(String errorText) {
            viewModel.houseError(view(), errorText);
        }

        @Override
        public void showStreetError(String errorText) {
            viewModel.streetError(view(), errorText);
        }

        @Override
        public void showTownError(String errorText) {
            viewModel.townError(view(), errorText);
        }

        @Override
        public void showCityError(String errorText) {
            viewModel.cityError(view(), errorText);
        }

        @Override
        public void showPostCodeError(String errorText) {
            viewModel.postCodeError(view(), errorText);
        }

        @Override
        public void returnAddress(String house, String street, String town, String city, String postCode, int code) {
            viewModel.returnAddress(view(), house, street, town, city, postCode, code);
        }
    };

    @Override
    public void saveInstance(Bundle outState) {
        outState.putParcelable(ARG_SAVED_STATE, new StateSaver(viewModel));
    }

    @Override
    public EditAddressAndroidView.EventsListener viewEventsListener() {
        return new EditAddressAndroidView.EventsListener() {

            @Override
            public void onUpdateHouse(String house) {
                viewModel.house(house);
            }

            @Override
            public void onUpdateStreet(String street) {
                viewModel.street(street);
            }

            @Override
            public void onUpdateTown(String town) {
                viewModel.town(town);
            }

            @Override
            public void onUpdateCity(String city) {
                viewModel.city(city);
            }

            @Override
            public void onUpdatePostCode(String postCode) {
                viewModel.postCode(postCode);
            }

            @Override
            public void onFocusHouseField() {
                wrapperEventsListener.onFocusHouseField();
            }

            @Override
            public void onFocusStreetField() {
                wrapperEventsListener.onFocusStreetField();
            }

            @Override
            public void onFocusTownField() {
                wrapperEventsListener.onFocusTownField();
            }

            @Override
            public void onFocusCityField() {
                wrapperEventsListener.onFocusCityField();
            }

            @Override
            public void onFocusPostCodeField() {
                wrapperEventsListener.onFocusPostCodeField();
            }

            @Override
            public void onClickDone() {
                wrapperEventsListener.onClickDone();
            }
        };
    }

    private static class StateSaver implements Parcelable {
        private final EditAddressAndroidViewModel viewModel;

        private StateSaver(EditAddressAndroidViewModel viewModel) {
            this.viewModel = viewModel;
        }

        private StateSaver(final Parcel parcel) {
            this.viewModel = parcel.readParcelable(EditAddressViewModel.class.getClassLoader());
        }

        private EditAddressViewWrapper restoreViewState(final PresenterFactory presenterFactory) {
            return new EditAddressViewWrapper(viewModel, presenterFactory);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeParcelable(viewModel, PARCELABLE_WRITE_RETURN_VALUE);//TODO check flag
        }

        final static Creator<StateSaver> CREATOR = new Creator<StateSaver>() {
            @Override
            public StateSaver createFromParcel(Parcel source) {
                return new StateSaver(source);
            }

            @Override
            public StateSaver[] newArray(int size) {
                return new StateSaver[size];
            }
        };
    }
}
