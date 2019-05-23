package com.example.blackwallpaper.presenter;

import android.os.Bundle;

import com.example.blackwallpaper.interfaces.RequestCallBack;
import com.example.blackwallpaper.interfaces.contract.NetworkdataFragmentContract;
import com.example.blackwallpaper.model.BaseRequest;
import com.example.blackwallpaper.model.network.CityRequest;
import com.example.blackwallpaper.model.network.ClassRequest;
import com.example.blackwallpaper.model.network.DealerRequest;

import java.util.List;

public class NetworkdataFragmentPresenter implements NetworkdataFragmentContract.Presenter, RequestCallBack {
    NetworkdataFragmentContract.Viev viev;
    NetworkdataFragmentContract.Model model;

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
                BaseRequest request = new CityRequest(this);
            }else if(bundle.getString("type",null).equalsIgnoreCase("dealer")){
                BaseRequest request = new DealerRequest(this);
            }else if(bundle.getString("type",null).equalsIgnoreCase("class")){
                BaseRequest request = new ClassRequest(this);
            }else if(bundle.getString("type",null).equalsIgnoreCase("year")){

            }
        }
    }


    @Override
    public void callback(List list) {

    }
}
