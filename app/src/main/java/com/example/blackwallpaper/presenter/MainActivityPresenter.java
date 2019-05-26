package com.example.blackwallpaper.presenter;

import android.content.Intent;

import com.example.blackwallpaper.ServiceApplication;
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

    @Override
    public void onDoneClicked() {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND_DATA");
        ServiceApplication.getContext().sendBroadcast(intent);

    }
}
