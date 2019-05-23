package com.example.blackwallpaper.model.network;

import com.example.blackwallpaper.interfaces.RequestCallBack;
import com.example.blackwallpaper.model.BaseRequest;

public class ClassesRequest extends BaseRequest {
    RequestCallBack requestCallBack;
    public ClassesRequest(RequestCallBack callBack) {
        super(callBack);
        this.requestCallBack = callBack;
    }

    void getcarClasses(){
        requestCallBack.callback();
    }
}
