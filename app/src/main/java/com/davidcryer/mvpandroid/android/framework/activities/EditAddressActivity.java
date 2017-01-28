package com.davidcryer.mvpandroid.android.framework.activities;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

import com.davidcryer.mvpandroid.R;
import com.davidcryer.mvpandroid.android.helpers.DrawableHelper;
import com.davidcryer.mvpandroid.android.helpers.FragmentManagerHelper;
import com.davidcryer.mvpandroid.android.view.ui.EditAddressFragment;

import static com.davidcryer.mvpandroid.android.helpers.FragmentManagerHelper.addFragment;
import static com.davidcryer.mvpandroid.android.helpers.FragmentManagerHelper.noFragmentBoundToView;

public class EditAddressActivity extends ViewWrapperRepositoryProviderActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_bar_with_content);
        setupToolbar();
        addInputFieldFragment();
    }

    private void setupToolbar() {
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(DrawableHelper.drawable(this, R.drawable.ic_arrow_back_white_24dp, android.R.color.white));
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }
    }

    private void addInputFieldFragment() {
        final FragmentManager fragmentManager = getSupportFragmentManager();
        if (noFragmentBoundToView(fragmentManager, getInputFieldFragmentViewContainer())) {
            addFragment(fragmentManager, getInputFieldFragment(), getInputFieldFragmentViewContainer());
        }
    }

    protected Fragment getInputFieldFragment() {
        return EditAddressFragment.newInstance();
    }

    @IdRes
    protected int getInputFieldFragmentViewContainer() {
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
