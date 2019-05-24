package com.example.blackwallpaper.model.network;

import com.example.blackwallpaper.interfaces.RequestCallBack;
import com.example.blackwallpaper.interfaces.RetrofitInterface;
import com.example.blackwallpaper.model.ShowRoom;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DealerRequest extends BaseRequest {
    RequestCallBack requestCallBack;
    public DealerRequest(RequestCallBack callBack) {
       this.requestCallBack = callBack;
    }
    @Override
    public void makeRequest(int id) {
        RetrofitInterface retrofit =RetrofitClient.getInstance().create(RetrofitInterface.class);
        try{
            Call<List<ShowRoom>> call = retrofit.getShorooms(id);
            call.enqueue(new Callback<List<ShowRoom>>() {
                @Override
                public void onResponse(Call<List<ShowRoom>> call, Response<List<ShowRoom>> response) {
                    makeCallback(response.body(),requestCallBack);
                }

                @Override
                public void onFailure(Call<List<ShowRoom>> call, Throwable t) {

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
        super.makeCallback(list, requestCallBack);

    }
}
