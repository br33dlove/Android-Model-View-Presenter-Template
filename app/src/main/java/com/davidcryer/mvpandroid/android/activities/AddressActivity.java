package com.davidcryer.mvpandroid.android.activities;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

import com.davidcryer.mvpandroid.R;
import com.davidcryer.mvpandroid.android.helpers.FragmentManagerHelper;
import com.davidcryer.mvpandroid.android.view.ui.AddressFragment;

import static com.davidcryer.mvpandroid.android.helpers.FragmentManagerHelper.addFragment;
import static com.davidcryer.mvpandroid.android.helpers.FragmentManagerHelper.noFragmentBoundToView;

public class AddressActivity extends ViewWrapperRepoProviderActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_bar_with_content);
        setupToolbar();
        addAddressFragment();
    }

    private void setupToolbar() {
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowHomeEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(false);
        }
    }

    private void addAddressFragment() {
        final FragmentManager fragmentManager = getSupportFragmentManager();
        if (noFragmentBoundToView(fragmentManager, getAddressFragmentViewContainer())) {
            addFragment(fragmentManager, AddressFragment.newInstance(), getAddressFragmentViewContainer());
        }
    }

    @IdRes
    private int getAddressFragmentViewContainer() {
        return R.id.content;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        final FragmentManager fragmentManager = getSupportFragmentManager();
        if (FragmentManagerHelper.hasMoreThanOneNonRetainedFragment(fragmentManager)) {
            fragmentManager.popBackStack();
            return;
        }
        super.onBackPressed();
    }
}
