package com.example.blackwallpaper.presenter;

import android.util.Log;

import com.example.blackwallpaper.model.reposytory.ModelProvider;
import com.example.blackwallpaper.interfaces.contract.MainFragmentyContract;
import com.example.blackwallpaper.model.LayoutModel;

import java.util.List;

public class MainFragmentPresenter implements MainFragmentyContract.Presenter {
    MainFragmentyContract.View view;
    MainFragmentyContract.Model layoutProvider;
    List<LayoutModel>layoutModels;
    public MainFragmentPresenter(MainFragmentyContract.View view) {
        this.view = view;
        this.layoutProvider = new ModelProvider();
    }

    @Override
    public void onCreate() {
        fillSampleDataSet();
        view.initRecyclerView();
        provideDataSet();
    }

    private void fillSampleDataSet() {
        layoutModels=layoutProvider.laoutmodels();
    }

    @Override
    public void provideDataSet() {
        Log.d("Log ",""+layoutModels.size());
        view.fillRecyclerView(layoutModels);
    }
}
