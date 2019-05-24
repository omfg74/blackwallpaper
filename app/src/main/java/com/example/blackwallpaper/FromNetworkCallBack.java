package com.example.blackwallpaper;

import com.example.blackwallpaper.model.BaseNetworkObject;

public interface FromNetworkCallBack<T> {
    void callBack(T baseNetworkObject, String type);
}
