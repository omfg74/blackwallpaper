package com.example.blackwallpaper.presenter;

import com.example.blackwallpaper.interfaces.contract.MainActivityContract;

public class MainActivityPresenter implements MainActivityContract.Presenter {

    MainActivityContract.View view;
    public MainActivityPresenter(MainActivityContract.View view) {
        this.view = view;

    }

    @Override
    public void onCreate() {
        view.changeFragment();
    }
}
