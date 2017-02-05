package com.davidcryer.androidmvptemplate.platformindependent.presenter.presenters;

import com.davidcryer.androidmvptemplate.platformindependent.view.MvpView;

public abstract class Presenter<EventsListenerType extends MvpView.EventsListener> {

    public abstract EventsListenerType eventsListener();
}
