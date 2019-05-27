package com.example.blackwallpaper.presenter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.example.blackwallpaper.Logger;
import com.example.blackwallpaper.R;
import com.example.blackwallpaper.ServiceApplication;
import com.example.blackwallpaper.interfaces.SendDataCallBackInterface;
import com.example.blackwallpaper.model.CarClass;
import com.example.blackwallpaper.model.City;
import com.example.blackwallpaper.model.Constants;
import com.example.blackwallpaper.model.ShowRoom;
import com.example.blackwallpaper.model.UserInfo;
import com.example.blackwallpaper.model.network.SendDataRequest;
import com.example.blackwallpaper.model.reposytory.ModelProvider;
import com.example.blackwallpaper.interfaces.contract.MainFragmentyContract;
import com.example.blackwallpaper.model.LayoutModel;
import com.example.blackwallpaper.utils.DataSaver;
import com.example.blackwallpaper.utils.EmailChecker;

import java.util.ArrayList;
import java.util.List;

public class MainFragmentPresenter extends BroadcastReceiver implements MainFragmentyContract.Presenter, SendDataCallBackInterface {
    MainFragmentyContract.View view;
    MainFragmentyContract.Model layoutProvider;
    List<LayoutModel> layoutModels;
    City city = null;

//    public MainFragmentPresenter() {
//    }

    public MainFragmentPresenter(MainFragmentyContract.View view) {
        this.view = view;
        this.layoutProvider = new ModelProvider();
    }

    @Override
    public void onCreate() {
        ServiceApplication.getContext().registerReceiver(this, new IntentFilter("android.intent.action.SEND_DATA"));
        fillSampleDataSet();

    }

    private void fillSampleDataSet() {
        DataSaver dataSaver = new DataSaver();
        SharedPreferences sharedPreferences = null;
            sharedPreferences = dataSaver.load();
            if (sharedPreferences.getString("name",null )==null) {
                layoutModels = layoutProvider.laoytmodels();
                view.fillRecyclerView(layoutModels);
            } else {
                sharedPreferences = dataSaver.load();
                layoutModels = new ArrayList<LayoutModel>();
                layoutModels.add(new LayoutModel(ServiceApplication.getContext().getString(R.string.gender), 1, null));
                layoutModels.add(new LayoutModel(ServiceApplication.getContext().getString(R.string.surname), 4, sharedPreferences.getString("surname", null)));
                layoutModels.add(new LayoutModel(ServiceApplication.getContext().getString(R.string.name), 2, sharedPreferences.getString("name", null)));
                layoutModels.add(new LayoutModel(ServiceApplication.getContext().getString(R.string.fname), 3, sharedPreferences.getString("fname", null)));
                layoutModels.add(new LayoutModel(ServiceApplication.getContext().getString(R.string.telephone), 5, sharedPreferences.getString("phone", null)));
                layoutModels.add(new LayoutModel(ServiceApplication.getContext().getString(R.string.email), 6, sharedPreferences.getString("email", null)));
                layoutModels.add(new LayoutModel(ServiceApplication.getContext().getString(R.string.vin), 7, sharedPreferences.getString("vin", null)));
                layoutModels.add(new LayoutModel(ServiceApplication.getContext().getString(R.string.city), 8, ServiceApplication.getContext().getString(R.string.choose_your_city_title)));
                layoutModels.add(new LayoutModel(ServiceApplication.getContext().getString(R.string.dealer), 9, ServiceApplication.getContext().getString(R.string.choose_your_city_dealer)));
                layoutModels.add(new LayoutModel(ServiceApplication.getContext().getString(R.string.year), 10, sharedPreferences.getString("year", null)));
                layoutModels.add(new LayoutModel(ServiceApplication.getContext().getString(R.string.carClass), 11, ServiceApplication.getContext().getString(R.string.choose_class)));
                City city = new City();
                ShowRoom showRoom = new ShowRoom();
                CarClass carClass = new CarClass();
                city.setId(sharedPreferences.getInt("cityid", 0));
                city.setName(sharedPreferences.getString("cityname", null));
                showRoom.setCityId(sharedPreferences.getInt("delerid", 0));
                showRoom.setId(sharedPreferences.getInt("dealercityid", 0));
                showRoom.setName(sharedPreferences.getString("delername", null));
                carClass.setName(sharedPreferences.getString("classname", null));
                carClass.setId(sharedPreferences.getInt("classid", 0));
                view.fillRecyclerView(layoutModels);
                view.setCityText(city);
                view.setClassText(carClass);
                view.setDealerText(showRoom);
                view.setYearText(Integer.parseInt(sharedPreferences.getString("year", null)));

        }
    }

    @Override
    public void onReciclerViewItemClicked(int i, String s) {
        Log.d("Log ", "number " + i + " " + s);
        switch (i) {
            case 7:
                view.attachCityFragment();
                break;
            case 8:

                if (s.equalsIgnoreCase(ServiceApplication.getContext().getString(R.string.choose_your_city_title))) {
                    view.makeToast("Пожалуйста сначала выберите город  ");
                } else {
                    if (this.city != null) {
                        view.attachDealerFragment(city.getId());
                    }
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
    }

    @Override
    public void onActivityResult(Intent data) {
        Bundle bundle = data.getExtras();
        String type = bundle.getString("type");
        if (type.equalsIgnoreCase(Constants.CITY)) {
            City city = (City) bundle.getSerializable(Constants.OBJECT);
            this.city = city;
            Logger.toLog("city test result " + city.getName());
            view.setCityText(city);
        } else if (type.equalsIgnoreCase(Constants.DEALER)) {
            ShowRoom showRoom = (ShowRoom) bundle.getSerializable(Constants.OBJECT);
            view.setDealerText(showRoom);
        } else if (type.equalsIgnoreCase(Constants.YEAR)) {
            int year = (int) bundle.getSerializable(Constants.OBJECT);
            view.setYearText(year);
        } else if (type.equalsIgnoreCase(Constants.CLASS)) {
            CarClass carClass = (CarClass) bundle.getSerializable(Constants.OBJECT);
            view.setClassText(carClass);
        }

    }

    @Override
    public void onDetach() {
        try {
            ServiceApplication.getContext().unregisterReceiver(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onResume() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Logger.toLog("intent " + intent);
        UserInfo userInfo = view.fetchData();
        if (userInfo != null) {
            EmailChecker emailChecker = new EmailChecker();
            if (emailChecker.check(userInfo.getEmail())) {
                if (userInfo.getVin().toCharArray().length == 17) {
                    Logger.toLog("DEALER ID " + String.valueOf(userInfo.getShowRoomId()));
                    SendDataRequest sendDataRequest = new SendDataRequest(this);
                    sendDataRequest.makeRequest(userInfo);
                } else {
                    view.makeToast(ServiceApplication.getContext().getString(R.string.enter_correct_vin));
                }
            } else {
                view.makeToast(ServiceApplication.getContext().getString(R.string.enter_correct_email));
            }
        } else {
            view.makeToast(ServiceApplication.getContext().getString(R.string.fill_all));
        }
    }

    @Override
    public void Callback(String s) {
        view.makeToast(s);
    }
}
