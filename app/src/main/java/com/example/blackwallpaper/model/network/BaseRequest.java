package com.example.blackwallpaper.model.network;

import com.example.blackwallpaper.Logger;
import com.example.blackwallpaper.interfaces.RequestCallBack;

import java.util.List;

public abstract class BaseRequest<T> {
    public void makeCallback(List<T> list, RequestCallBack requestCallBack) {
        try {
            Logger.toLog("List size in base request " + list.size());
            requestCallBack.callback(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void makeRequest() {
    }

    public void makeRequest(int id) {
    }
}
