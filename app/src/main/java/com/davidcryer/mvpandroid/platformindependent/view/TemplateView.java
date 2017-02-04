package com.davidcryer.mvpandroid.platformindependent.view;

import com.davidcryer.mvpandroid.platformindependent.view.models.TemplateMvpViewModel;

public interface TemplateView extends MvpView<TemplateMvpViewModel> {

    interface EventsListener extends MvpView.EventsListener {

    }
}
