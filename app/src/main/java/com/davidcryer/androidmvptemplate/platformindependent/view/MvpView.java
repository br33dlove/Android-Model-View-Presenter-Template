package com.davidcryer.androidmvptemplate.platformindependent.view;

import com.davidcryer.androidmvptemplate.platformindependent.view.models.MvpViewModel;

public interface MvpView<ViewModelType extends MvpViewModel> {
    ViewModelType viewModel();

    interface EventsListener {
        void onReleaseResources();
    }
}
