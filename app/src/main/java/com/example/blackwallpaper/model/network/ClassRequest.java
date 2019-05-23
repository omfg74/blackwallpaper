package com.example.blackwallpaper.model.network;

import com.example.blackwallpaper.interfaces.RequestCallBack;
import com.example.blackwallpaper.interfaces.RetrofitInterface;
import com.example.blackwallpaper.model.BaseRequest;
import com.example.blackwallpaper.model.CarClass;
import com.example.blackwallpaper.model.City;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ClassRequest extends BaseRequest {
    RequestCallBack requestCallBack;
    public ClassRequest(RequestCallBack callBack) {
        super(callBack);
        this.requestCallBack = callBack;
    }

    @Override
    public void makeRequest() {
        RetrofitInterface retrofit =RetrofitClient.getInstance().create(RetrofitInterface.class);
        try{
            Call<List<CarClass>>call = retrofit.getClasses();
            call.enqueue(new Callback<List<CarClass>>() {
                @Override
                public void onResponse(Call<List<CarClass>> call, Response<List<CarClass>> response) {
                    makeCallback(response.body());
                }

                @Override
                public void onFailure(Call<List<CarClass>> call, Throwable t) {

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
