package com.davidcryer.mvpandroid.platformindependent.presenter.presenters;

import com.davidcryer.mvpandroid.platformindependent.view.TemplateView;

public class TemplatePresenter extends Presenter<TemplateView.EventsListener> {
    private final TemplateView viewWrapper;

    private TemplatePresenter(final TemplateView viewWrapper) {
        this.viewWrapper = viewWrapper;
    }

    public static Presenter<TemplateView.EventsListener> newInstance(
            final TemplateView viewWrapper
    ) {
        return new TemplatePresenter(viewWrapper);
    }

    @Override
    public TemplateView.EventsListener eventsListener() {
        return new TemplateView.EventsListener() {

            @Override
            public void someEvent() {
                viewWrapper.someScreenChange();
            }
        };
    }

    @Override
    public void releaseResources() {

    }
}
