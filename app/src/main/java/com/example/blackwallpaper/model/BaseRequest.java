package com.example.blackwallpaper.model;

import com.example.blackwallpaper.interfaces.RequestCallBack;

public class BaseRequest {
    RequestCallBack requestCallBack;
    public BaseRequest(RequestCallBack callBack) {
        this.requestCallBack = callBack;
    }
}
