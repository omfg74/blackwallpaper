package com.example.blackwallpaper.model.network;

import com.example.blackwallpaper.interfaces.RequestCallBack;
import com.example.blackwallpaper.interfaces.RetrofitInterface;
import com.example.blackwallpaper.model.CarClass;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ClassRequest extends BaseRequest {
    RequestCallBack requestCallBack;
    public ClassRequest(RequestCallBack callBack) {
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
                    makeCallback(response.body(), requestCallBack);
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
    public void makeCallback(List list, RequestCallBack requestCallBack) {
        super.makeCallback(list,requestCallBack);

    }
}
