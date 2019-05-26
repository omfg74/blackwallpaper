package com.example.blackwallpaper.interfaces;

import com.example.blackwallpaper.model.BaseNetworkObject;

public interface FromNetworkCallBack<T> {
    void callBack(T baseNetworkObject, String type);
}
