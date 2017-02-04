package com.davidcryer.mvpandroid.android.view.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.davidcryer.mvpandroid.android.view.ui.TemplateAndroidView;

public class TemplateViewModel implements TemplateAndroidViewModel {

    private TemplateViewModel() {

    }

    private TemplateViewModel(final Parcel parcel) {

    }

    public static TemplateViewModel newInstance() {
        return new TemplateViewModel();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }

    final static Parcelable.Creator<TemplateViewModel> CREATOR = new Parcelable.Creator<TemplateViewModel>() {
        @Override
        public TemplateViewModel createFromParcel(Parcel source) {
            return new TemplateViewModel(source);
        }

        @Override
        public TemplateViewModel[] newArray(int size) {
            return new TemplateViewModel[size];
        }
    };

    @Override
    public void onto(TemplateAndroidView view) {

    }
}
