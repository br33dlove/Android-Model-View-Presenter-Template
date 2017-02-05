package com.davidcryer.androidmvptemplate.android.view.ui;

public interface TemplateAndroidView extends AndroidMvpView {
    void someScreenChange();

    interface EventsListener extends AndroidMvpView.EventsListener {
        void onSomeEvent();
    }
}
