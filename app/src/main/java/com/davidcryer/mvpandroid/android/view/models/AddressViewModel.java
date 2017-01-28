package com.davidcryer.mvpandroid.android.view.models;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.davidcryer.mvpandroid.android.framework.activities.EditAddressActivity;
import com.davidcryer.mvpandroid.android.view.ui.AddressAndroidView;

public class AddressViewModel implements AddressAndroidViewModel {
    private String house;
    private String street;
    private String town;
    private String city;
    private String postCode;
    private boolean startEditAddressView;

    private AddressViewModel(
            final String house,
            final String street,
            final String town,
            final String city,
            final String postCode
    ) {
        this.house = house;
        this.street = street;
        this.town = town;
        this.city = city;
        this.postCode = postCode;
    }

    private AddressViewModel(final Parcel parcel) {
        house = parcel.readString();
        street = parcel.readString();
        town = parcel.readString();
        city = parcel.readString();
        postCode = parcel.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(house);
        dest.writeString(street);
        dest.writeString(town);
        dest.writeString(city);
        dest.writeString(postCode);
    }

    final static Parcelable.Creator<AddressViewModel> CREATOR = new Parcelable.Creator<AddressViewModel>() {
        @Override
        public AddressViewModel createFromParcel(Parcel source) {
            return new AddressViewModel(source);
        }

        @Override
        public AddressViewModel[] newArray(int size) {
            return new AddressViewModel[size];
        }
    };

    public static AddressViewModel newInstance(
            final String house,
            final String street,
            final String town,
            final String city,
            final String postCode
    ) {
        return new AddressViewModel(house, street, town, city, postCode);
    }

    @Override
    public void onto(AddressAndroidView view) {
        view.showHouse(house);
        view.showStreet(street);
        view.showTown(town);
        view.showCity(city);
        view.showPostCode(postCode);
        if (startEditAddressView) {
            launchEditAddressView(view);
        }
    }

    private void launchEditAddressView(final AddressAndroidView view) {
        final Intent intent = new Intent(view.activity(), EditAddressActivity.class);
        view.startEditAddressView(intent, 0);//TODO intdef code
    }

    @Override
    public void house(AddressAndroidView view, String house) {
        this.house = house;
        if (view != null) {
            view.showHouse(house);
        }
    }

    @Override
    public void street(AddressAndroidView view, String street) {
        this.street = street;
        if (view != null) {
            view.showStreet(street);
        }
    }

    @Override
    public void town(AddressAndroidView view, String town) {
        this.town = town;
        if (view != null) {
            view.showTown(town);
        }
    }

    @Override
    public void city(AddressAndroidView view, String city) {
        this.city = city;
        if (view != null) {
            view.showCity(city);
        }
    }

    @Override
    public void postCode(AddressAndroidView view, String postCode) {
        this.postCode = postCode;
        if (view != null) {
            view.showPostCode(postCode);
        }
    }

    @Override
    public void startEditAddressView(@Nullable AddressAndroidView view) {
        if (view != null) {
            launchEditAddressView(view);
        } else {
            startEditAddressView = true;
        }
    }
}
