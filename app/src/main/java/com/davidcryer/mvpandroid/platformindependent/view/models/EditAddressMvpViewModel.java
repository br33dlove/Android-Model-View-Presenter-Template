package com.davidcryer.mvpandroid.platformindependent.view.models;

public interface EditAddressMvpViewModel extends MvpViewModel {
    String house();
    String street();
    String town();
    String city();
    String postCode();
    String houseError();
    String streetError();
    String townError();
    String cityError();
    String postCodeError();
}
