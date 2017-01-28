package com.davidcryer.mvpandroid.android.view.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.davidcryer.mvpandroid.android.activities.EditAddressActivity;
import com.davidcryer.mvpandroid.R;
import com.davidcryer.mvpandroid.android.presenter.repositories.ViewBindingFragment;
import com.davidcryer.mvpandroid.android.presenter.repositories.ViewWrapperRepository;

public class AddressFragment extends ViewBindingFragment<AddressAndroidView.EventsListener> implements AddressAndroidView {
    //TODO import and use butterknife instead of initialising view references and setting on click listeners manually
    private TextView houseTextView;
    private TextView streetTextView;
    private TextView townTextView;
    private TextView cityTextView;
    private TextView postCodeTextView;

    public static AddressFragment newInstance() {
        return new AddressFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_address, container, false);
        initialiseViewReferences(view);
        return view;
    }

    private void initialiseViewReferences(final View root) {
        houseTextView = (TextView) root.findViewById(R.id.house);
        streetTextView = (TextView) root.findViewById(R.id.street);
        townTextView = (TextView) root.findViewById(R.id.town);
        cityTextView = (TextView) root.findViewById(R.id.city);
        postCodeTextView = (TextView) root.findViewById(R.id.postCode);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.address_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.edit: {
                eventsListener.onClickEdit();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showHouse(String house) {
        houseTextView.setText(house);
    }

    @Override
    public void showStreet(String street) {
        streetTextView.setText(street);
    }

    @Override
    public void showTown(String town) {
        townTextView.setText(town);
    }

    @Override
    public void showCity(String city) {
        cityTextView.setText(city);
    }

    @Override
    public void showPostCode(String postCode) {
        postCodeTextView.setText(postCode);
    }

    @Override
    public void startEditAddressView(final Intent intent, final int requestCode) {
        startActivityForResult(intent, requestCode);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        eventsListener.onReturnResult(requestCode, resultCode, data);
    }

    @Override
    protected AddressAndroidView.EventsListener bind(ViewWrapperRepository viewWrapperRepository, final Bundle savedState) {
        return viewWrapperRepository.bind(this, savedState);
    }

    @Override
    protected void unbind(ViewWrapperRepository viewWrapperRepository, boolean isLeaving) {
        viewWrapperRepository.unbind(this, isLeaving);
    }

    @Override
    public Activity activity() {
        return getActivity();
    }
}
