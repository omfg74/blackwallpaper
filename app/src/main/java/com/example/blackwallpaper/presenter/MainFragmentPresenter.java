package com.example.blackwallpaper.presenter;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.blackwallpaper.R;
import com.example.blackwallpaper.ServiceApplication;
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

    }

    private void fillSampleDataSet() {
        layoutModels=layoutProvider.laoutmodels();
    }

    @Override
    public void provideDataSet() {
        Log.d("Log ","Model size"+layoutModels.size());
        view.fillRecyclerView(layoutModels);
    }

    @Override
    public void onReciclerViewItemClicked(int i, String s) {
        Log.d("Log ","number " +i+" "+s);
        switch (i){
            case 7:
                view.attachCityFragment();
                break;
            case 8:
                if(s.equalsIgnoreCase(ServiceApplication.getContext().getString(R.string.choose_your_city_title))){
                    view.makeToast("Please select city first");
                }else {
                    view.attachDealerFragment();
                }
                break;
            case 9:
                view.attachYearFragment();
                break;
            case 10:
                view.attachClassFragment();
                break;
        }

    }

    @Override
    public void onViewCreated() {
        view.initRecyclerView();
        provideDataSet();
    }

    @Override
    public void onActivityResult(Intent data) {
        Bundle bundle= data.getExtras();
        String name  = bundle.getString("name");
        int id =  bundle.getInt("id");
        Log.d("Log", name+id);
    }

}
