package com.chatty.android.chattyClient.presenter.main;

import com.chatty.android.chattyClient.view.main.MainActivity;

public class MainPresenter {
    private MainActivity view;

    public MainPresenter(MainActivity view) {
        this.view = view;
    }

    public void init() {
        view.initView();
    }
}
