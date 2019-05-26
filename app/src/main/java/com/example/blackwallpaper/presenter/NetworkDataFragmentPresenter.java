package com.example.blackwallpaper.presenter;

import android.os.Bundle;

import com.example.blackwallpaper.interfaces.RequestCallBack;
import com.example.blackwallpaper.interfaces.contract.NetworkdataFragmentContract;
import com.example.blackwallpaper.model.Constants;
import com.example.blackwallpaper.model.network.BaseRequest;
import com.example.blackwallpaper.model.YearListGenerator;
import com.example.blackwallpaper.model.network.CityRequest;
import com.example.blackwallpaper.model.network.ClassRequest;
import com.example.blackwallpaper.model.network.DealerRequest;

import java.util.List;

public class NetworkDataFragmentPresenter implements NetworkdataFragmentContract.Presenter, RequestCallBack {
    NetworkdataFragmentContract.Viev viev;
    NetworkdataFragmentContract.Model model;
    BaseRequest request;

    public NetworkDataFragmentPresenter(NetworkdataFragmentContract.Viev viev) {
        this.viev = viev;
    }


    @Override
    public void onCreate(Bundle bundle) {
        makeRequest(bundle);
    }

    @Override
    public void makeRequest(Bundle bundle) {
        if (bundle.containsKey(Constants.TYPE)) {
            if (bundle.getString(Constants.TYPE, null).equalsIgnoreCase(Constants.CITY)) {
                request = new CityRequest(this);
                request.makeRequest();
            } else if (bundle.getString(Constants.TYPE, null).equalsIgnoreCase(Constants.DEALER)) {
                request = new DealerRequest(this);
                request.makeRequest(bundle.getInt("id"));
            } else if (bundle.getString(Constants.TYPE, null).equalsIgnoreCase(Constants.CLASS)) {
                request = new ClassRequest(this);
                request.makeRequest();
            } else if (bundle.getString(Constants.TYPE, null).equalsIgnoreCase(Constants.YEAR)) {
                YearListGenerator yearListGenerator = new YearListGenerator();
                List<Integer> yearList = yearListGenerator.getYearList();
                callback(yearList);
            }
        }

    }


    @Override
    public void callback(List list) {
        String type;
        if (request instanceof CityRequest) {
            type = Constants.CITY;
        } else if (request instanceof DealerRequest) {
            type = Constants.DEALER;
        } else if (request instanceof ClassRequest) {
            type = Constants.CLASS;
        } else {
            type = Constants.YEAR;
        }
        viev.placeItamsTorecyclerView(list, type);
    }
}
