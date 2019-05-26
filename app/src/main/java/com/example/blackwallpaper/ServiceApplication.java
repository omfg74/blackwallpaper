package com.example.blackwallpaper;

import android.app.Application;
import android.content.Context;

public class ServiceApplication extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        ServiceApplication.context = getApplicationContext();
    }

    public static Context getContext() {
        return ServiceApplication.context;
    }
}
