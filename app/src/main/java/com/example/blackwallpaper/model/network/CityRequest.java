package com.example.blackwallpaper.model.network;

import com.example.blackwallpaper.interfaces.RequestCallBack;
import com.example.blackwallpaper.interfaces.RetrofitInterface;
import com.example.blackwallpaper.model.BaseRequest;
import com.example.blackwallpaper.model.City;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CityRequest extends BaseRequest {
    public CityRequest(RequestCallBack callBack) {
        super(callBack);
//        super.makeCallback(new ArrayList());
    }
    @Override
    public void makeRequest() {
        RetrofitInterface retrofit =RetrofitClient.getInstance().create(RetrofitInterface.class);
        try{
            Call<List<City>> call = retrofit.getCities();
            call.enqueue(new Callback<List<City>>() {
                @Override
                public void onResponse(Call<List<City>> call, Response<List<City>> response) {
                    makeCallback(response.body());
                }

                @Override
                public void onFailure(Call<List<City>> call, Throwable t) {

                }
            });
        }catch (Exception e ){
            e.printStackTrace();
        }
    }

//    void getcarClasses(){
//        requestCallBack.callback();
//    }

    @Override
    public void makeCallback(List list) {
        super.makeCallback(list);

    }


}
