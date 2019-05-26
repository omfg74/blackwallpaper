package com.example.blackwallpaper.utils;

import android.content.SharedPreferences;

import com.example.blackwallpaper.Logger;
import com.example.blackwallpaper.ServiceApplication;
import com.example.blackwallpaper.model.CarClass;
import com.example.blackwallpaper.model.City;
import com.example.blackwallpaper.model.ShowRoom;
import com.example.blackwallpaper.model.UserInfo;

import java.util.HashMap;

public class DataSaver {
    public void saveData(UserInfo userInfo, City city, ShowRoom showRoom, CarClass carClass) {
        SharedPreferences sharedPreferences = ServiceApplication.getContext().getSharedPreferences("temp", ServiceApplication.getContext().MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name", userInfo.getFirstName());
        editor.putString("surname", userInfo.getLastName());
        editor.putString("fname", userInfo.getMiddleName());
        editor.putString("phone", userInfo.getPhone());
        editor.putString("email", userInfo.getEmail());
        editor.putString("vin", userInfo.getVin());
        editor.putString("year", userInfo.getYear());
        editor.putInt("cityid", city.getId());
        editor.putString("cityname", city.getName());
        editor.putInt("delerid", showRoom.getId());
        editor.putString("delername", showRoom.getName());
        editor.putInt("dealercityid", showRoom.getCityId());
        editor.putString("classname", carClass.getName());
        editor.putInt("classid", carClass.getId());
        editor.apply();
    }


    public SharedPreferences load() {
        SharedPreferences sharedPreferences = ServiceApplication.getContext().getSharedPreferences("temp", ServiceApplication.getContext().MODE_PRIVATE);
        return sharedPreferences;
    }
}
