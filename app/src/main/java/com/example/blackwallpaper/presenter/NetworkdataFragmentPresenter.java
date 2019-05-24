package com.example.blackwallpaper.presenter;

import android.os.Bundle;

import com.example.blackwallpaper.interfaces.RequestCallBack;
import com.example.blackwallpaper.interfaces.contract.NetworkdataFragmentContract;
import com.example.blackwallpaper.model.network.BaseRequest;
import com.example.blackwallpaper.model.YearListGenerator;
import com.example.blackwallpaper.model.network.CityRequest;
import com.example.blackwallpaper.model.network.ClassRequest;
import com.example.blackwallpaper.model.network.DealerRequest;

import java.util.List;

public class NetworkdataFragmentPresenter implements NetworkdataFragmentContract.Presenter, RequestCallBack {
    NetworkdataFragmentContract.Viev viev;
    NetworkdataFragmentContract.Model model;
    BaseRequest request;
    public NetworkdataFragmentPresenter(NetworkdataFragmentContract.Viev viev) {
        this.viev = viev;
    }


    @Override
    public void onCreate(Bundle bundle) {
        makeRequest(bundle);
    }

    @Override
    public void makeRequest(Bundle bundle) {
        if (bundle.containsKey("type")){
            if(bundle.getString("type",null).equalsIgnoreCase("city")){
                request = new CityRequest(this);
                request.makeRequest();
            }else if(bundle.getString("type",null).equalsIgnoreCase("dealer")){
                request = new DealerRequest(this);
                request.makeRequest(bundle.getInt("id"));
            }else if(bundle.getString("type",null).equalsIgnoreCase("class")){
                request = new ClassRequest(this);
                request.makeRequest();
            }else if(bundle.getString("type",null).equalsIgnoreCase("year")){
                YearListGenerator yearListGenerator = new YearListGenerator();
                List<Integer>yearList = yearListGenerator.getYearList();
                callback(yearList);
            }
        }

    }


    @Override
    public void callback(List list) {
        String type;
        if (request instanceof CityRequest){
            type="city";
            viev.placeItamsTorecyclerView(list, type);
        }else
        if (request instanceof DealerRequest){
            type="dealer";
            viev.placeItamsTorecyclerView(list, type);
        }else
        if (request instanceof ClassRequest){
            type="class";
            viev.placeItamsTorecyclerView(list, type);
        }else {
            type="year";
            viev.placeItamsTorecyclerView(list, type);
        }

    }
}
