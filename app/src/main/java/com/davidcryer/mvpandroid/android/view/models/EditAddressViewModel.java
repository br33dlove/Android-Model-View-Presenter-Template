package com.davidcryer.mvpandroid.android.view.models;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.davidcryer.mvpandroid.android.view.helpers.AddressResultParameters;
import com.davidcryer.mvpandroid.android.view.ui.EditAddressAndroidView;
import com.davidcryer.mvpandroid.platformindependent.presenter.businesslogic.validators.AddressLineValidator;
import com.davidcryer.mvpandroid.platformindependent.presenter.businesslogic.validators.PostCodeValidator;

public class EditAddressViewModel implements EditAddressAndroidViewModel {
    private String house;
    private String street;
    private String town;
    private String city;
    private String postCode;
    private String houseError;
    private String streetError;
    private String townError;
    private String cityError;
    private String postCodeError;
    private boolean returnAddress;
    private String returnHouse;
    private String returnStreet;
    private String returnTown;
    private String returnCity;
    private String returnPostCode;
    private Integer returnCode;
    private Integer requestCode;

    private EditAddressViewModel(
            final String house,
            final String street,
            final String town,
            final String city,
            final String postCode,
            final String houseError,
            final String streetError,
            final String townError,
            final String cityError,
            final String postCodeError,
            final boolean returnAddress,
            final Integer returnCode
    ) {
        this.house = house;
        this.street = street;
        this.town = town;
        this.city = city;
        this.postCode = postCode;
        this.houseError = houseError;
        this.streetError = streetError;
        this.townError = townError;
        this.cityError = cityError;
        this.postCodeError = postCodeError;
        this.returnAddress = returnAddress;
        this.returnCode = returnCode;
    }

    private EditAddressViewModel(final Parcel parcel) {
        house = parcel.readString();
        street = parcel.readString();
        town = parcel.readString();
        city = parcel.readString();
        postCode = parcel.readString();
        houseError = parcel.readString();
        streetError = parcel.readString();
        townError = parcel.readString();
        cityError = parcel.readString();
        postCodeError = parcel.readString();
        returnAddress = parcel.readByte() != 0;
        returnCode = parcel.readInt();
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
        dest.writeString(houseError);
        dest.writeString(streetError);
        dest.writeString(townError);
        dest.writeString(cityError);
        dest.writeString(postCodeError);
        dest.writeByte((byte) (returnAddress ? 1 : 0));
        dest.writeInt(returnCode);
    }

    final static Parcelable.Creator<EditAddressViewModel> CREATOR = new Parcelable.Creator<EditAddressViewModel>() {
        @Override
        public EditAddressViewModel createFromParcel(Parcel source) {
            return new EditAddressViewModel(source);
        }

        @Override
        public EditAddressViewModel[] newArray(int size) {
            return new EditAddressViewModel[size];
        }
    };

    public static EditAddressViewModel newInstance(
            final String house,
            final String street,
            final String town,
            final String city,
            final String postCode
    ) {
        return new EditAddressViewModel(house, street, town, city, postCode, null, null, null, null, null, false, null);
    }

    @Override
    public void onto(EditAddressAndroidView view) {
        view.showHouse(house);
        view.showStreet(street);
        view.showTown(town);
        view.showCity(city);
        view.showPostCode(postCode);
        view.showHouseError(houseError);
        view.showStreetError(streetError);
        view.showTownError(townError);
        view.showCityError(cityError);
        view.showPostCodeError(postCodeError);
        if (returnAddress) {
            returnAddress(view);
        }
    }

    private void returnAddress(final EditAddressAndroidView view) {
        final Intent intent = new Intent();
        intent.putExtra(AddressResultParameters.KEY_HOUSE, returnHouse);
        intent.putExtra(AddressResultParameters.KEY_STREET, returnStreet);
        intent.putExtra(AddressResultParameters.KEY_TOWN, returnTown);
        intent.putExtra(AddressResultParameters.KEY_CITY, returnCity);
        intent.putExtra(AddressResultParameters.KEY_POST_CODE, returnPostCode);
        view.returnAddressForCode(intent, returnCode);
    }

    @Override
    public String house() {
        return house;
    }

    @Override
    public String street() {
        return street;
    }

    @Override
    public String town() {
        return town;
    }

    @Override
    public String city() {
        return city;
    }

    @Override
    public String postCode() {
        return postCode;
    }

    @Override
    public String houseError() {
        return houseError;
    }

    @Override
    public String streetError() {
        return streetError;
    }

    @Override
    public String townError() {
        return townError;
    }

    @Override
    public String cityError() {
        return cityError;
    }

    @Override
    public String postCodeError() {
        return postCodeError;
    }

    @Override
    public void house(String house) {
        this.house = house;
    }

    @Override
    public void street(String street) {
        this.street = street;
    }

    @Override
    public void town(String town) {
        this.town = town;
    }

    @Override
    public void city(String city) {
        this.city = city;
    }

    @Override
    public void postCode(String postCode) {
        this.postCode = postCode;
    }

    @Override
    public void house(EditAddressAndroidView view, String house) {
        house(house);
        if (view != null) {
            view.showHouse(house);
        }
    }

    @Override
    public void street(EditAddressAndroidView view, String street) {
        street(street);
        if (view != null) {
            view.showStreet(street);
        }
    }

    @Override
    public void town(EditAddressAndroidView view, String town) {
        town(town);
        if (view != null) {
            view.showTown(town);
        }
    }

    @Override
    public void city(EditAddressAndroidView view, String city) {
        city(city);
        if (view != null) {
            view.showCity(city);
        }
    }

    @Override
    public void postCode(EditAddressAndroidView view, String postCode) {
        postCode(postCode);
        if (view != null) {
            view.showPostCode(postCode);
        }
    }

    @Override
    public void houseError(EditAddressAndroidView view, final String houseError) {
        this.houseError = houseError;
        if (view != null) {
            view.showHouseError(houseError);
        }
    }

    @Override
    public void streetError(EditAddressAndroidView view, final String streetError) {
        this.streetError = streetError;
        if (view != null) {
            view.showStreetError(streetError);
        }
    }

    @Override
    public void townError(EditAddressAndroidView view, final String townError) {
        this.townError = townError;
        if (view != null) {
            view.showTownError(townError);
        }
    }

    @Override
    public void cityError(EditAddressAndroidView view, final String cityError) {
        this.cityError = cityError;
        if (view != null) {
            view.showCityError(cityError);
        }
    }

    @Override
    public void postCodeError(EditAddressAndroidView view, final String postCodeError) {
        this.postCodeError = postCodeError;
        if (view != null) {
            view.showPostCodeError(postCodeError);
        }
    }

    @Override
    public void returnAddress(@Nullable EditAddressAndroidView view, String house, String street, String town, String city, String postCode, int returnCode) {
        returnAddress = true;
        this.returnHouse = house;
        this.returnStreet = street;
        this.returnTown = town;
        this.returnCity = city;
        this.returnPostCode = postCode;
        this.returnCode = returnCode;
        if (view != null) {
            returnAddress(view);
        }
    }
}
