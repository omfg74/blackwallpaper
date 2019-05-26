package com.example.blackwallpaper.utils;

import android.content.SharedPreferences;

import com.example.blackwallpaper.Logger;
import com.example.blackwallpaper.ServiceApplication;
import com.example.blackwallpaper.model.CarClass;
import com.example.blackwallpaper.model.City;
import com.example.blackwallpaper.model.ShowRoom;
import com.example.blackwallpaper.model.UserInfo;

import java.util.HashMap;

public class DataSaver{
    public void saveData(UserInfo userInfo, City city, ShowRoom showRoom, CarClass carClass) {
        SharedPreferences sharedPreferences = ServiceApplication.getContext().getSharedPreferences("temp", ServiceApplication.getContext().MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name",userInfo.getFirstName());
        editor.putString("surname",userInfo.getLastName());
        editor.putString("fname",userInfo.getMiddleName());
        editor.putString("phone",userInfo.getPhone());
        editor.putString("email",userInfo.getEmail());
        editor.putString("vin",userInfo.getVin());
        editor.putString("year",userInfo.getYear());
        editor.putInt("cityid",city.getId());
        editor.putString("cityname",city.getName());
        editor.putInt("delerid",showRoom.getId());
        editor.putString("delername",showRoom.getName());
        editor.putInt("dealercityid",showRoom.getCityId());
        editor.putString("classnaem",carClass.getName());
        editor.putInt("classid",carClass.getId());
        editor.apply();
    }


//    public SharedPreferences load(){
//        HashMap<String, T> hashMap = new HashMap<>();
//        UserInfo userInfo = new UserInfo();
//        City city = new City();
//        CarClass carClass =  new CarClass();
//        ShowRoom showRoom = new ShowRoom();
//        SharedPreferences sharedPreferences = ServiceApplication.getContext().getSharedPreferences("temp",ServiceApplication.getContext().MODE_PRIVATE);
//        userInfo.setFirstName(sharedPreferences.getString("name",null));
//        userInfo.setLastName(sharedPreferences.getString("surname",null));
//        userInfo.setMiddleName(sharedPreferences.getString("fname",null));
//        userInfo.setPhone(sharedPreferences.getString("phone",null));
//        userInfo.setEmail(sharedPreferences.getString("email",null));
//        userInfo.setVin(sharedPreferences.getString("vin",null));
//        userInfo.setYear(sharedPreferences.getString("year",null));
//        city.getId(sharedPreferences.getInt());
//        city.getName(sharedPreferences.getString());
//        showRoom.setName(sharedPreferences.getString());
//        showRoom.setId(sharedPreferences.getInt());
//        showRoom.setCityId(sharedPreferences.getInt());
//        carClass.setName(sharedPreferences.getString());
//        carClass.setId(sharedPreferences.getInt());
//        return sharedPreferences;
//    }
}
