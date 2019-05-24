package com.example.blackwallpaper.presenter;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.blackwallpaper.R;
import com.example.blackwallpaper.ServiceApplication;
import com.example.blackwallpaper.model.CarClass;
import com.example.blackwallpaper.model.City;
import com.example.blackwallpaper.model.ShowRoom;
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
        layoutModels=layoutProvider.laoytmodels();
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
        String type= bundle.getString("type");
        if(type.equalsIgnoreCase("city")){
            City city = (City) bundle.getSerializable("object");
            view.setCityText(city);
        }else if(type.equalsIgnoreCase("dealer")){
            ShowRoom showRoom = (ShowRoom)  bundle.getSerializable("object");
            view.setDealerText(showRoom);
        }else if(type.equalsIgnoreCase("year")){
            int year = (int)  bundle.getSerializable("object");
            view.setYearText(year);
        }else if(type.equalsIgnoreCase("class")){
            CarClass carClass = (CarClass)  bundle.getSerializable("object");
            view.setClassText(carClass);
        }

    }

}
