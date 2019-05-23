package com.example.blackwallpaper.model;

import com.example.blackwallpaper.interfaces.RequestCallBack;

import java.util.List;

public  abstract class BaseRequest<T> {
    RequestCallBack requestCallBack;
    public BaseRequest(RequestCallBack callBack) {
        this.requestCallBack = callBack;
    }

    public void makeCallback(List<T>list){
        requestCallBack.callback(list);
    }
    public  void makeRequest(){}
    public void makeRequest(int id){}
}
