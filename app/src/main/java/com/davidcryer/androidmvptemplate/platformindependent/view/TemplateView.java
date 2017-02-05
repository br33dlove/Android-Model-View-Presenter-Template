package com.davidcryer.androidmvptemplate.platformindependent.view;

import com.davidcryer.androidmvptemplate.platformindependent.view.models.TemplateMvpViewModel;

public interface TemplateView extends MvpView<TemplateMvpViewModel> {
    void someScreenChange();

    interface EventsListener extends MvpView.EventsListener {
        void onSomeEvent();
    }
}
