package com.davidcryer.androidmvptemplate.platformindependent.presenter.factories;

import com.davidcryer.androidmvptemplate.platformindependent.presenter.presenters.Presenter;
import com.davidcryer.androidmvptemplate.platformindependent.presenter.presenters.TemplatePresenter;
import com.davidcryer.androidmvptemplate.platformindependent.view.TemplateView;

public class PresenterFactoryImpl implements PresenterFactory {

    private PresenterFactoryImpl() {

    }

    public static PresenterFactory newInstance() {
        return new PresenterFactoryImpl();
    }

    @Override
    public Presenter<TemplateView.EventsListener> createTemplatePresenter(final TemplateView viewWrapper) {
        return TemplatePresenter.newInstance(viewWrapper);
    }
}
