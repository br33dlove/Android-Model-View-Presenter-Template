package com.davidcryer.androidmvptemplate.platformindependent.presenter.factories;

import com.davidcryer.androidmvptemplate.platformindependent.presenter.presenters.Presenter;
import com.davidcryer.androidmvptemplate.platformindependent.view.TemplateView;

public interface PresenterFactory {
    Presenter<TemplateView.EventsListener> createTemplatePresenter(final TemplateView viewWrapper);
}
