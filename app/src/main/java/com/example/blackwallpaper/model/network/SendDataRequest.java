package com.example.blackwallpaper.model.network;

import com.example.blackwallpaper.interfaces.RetrofitInterface;
import com.example.blackwallpaper.interfaces.SendDataCallBackInterface;
import com.example.blackwallpaper.model.UserInfo;
import com.example.blackwallpaper.presenter.MainFragmentPresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SendDataRequest {

    SendDataCallBackInterface sendDataCallBackInterface;

    public SendDataRequest(SendDataCallBackInterface sendDataCallBackInterface) {
        this.sendDataCallBackInterface = sendDataCallBackInterface;
    }

    public void makeRequest(UserInfo userInfo) {
        RetrofitInterface retrofit = RetrofitClient.getInstance().create(RetrofitInterface.class);
        final Call<Void> request = retrofit.sendData(userInfo);
        request.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

                sendDataCallBackInterface.Callback(String.valueOf(response.code()));
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                sendDataCallBackInterface.Callback(String.valueOf(t.getMessage()));
            }
        });

    }
}
