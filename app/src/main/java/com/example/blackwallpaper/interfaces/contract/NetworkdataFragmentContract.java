package com.example.blackwallpaper.interfaces.contract;

import android.os.Bundle;

public interface NetworkdataFragmentContract {
    interface Viev{
        void placeItamsTorecyclerView();
    }
    interface Model{}
    interface Presenter{
        void onCreate(Bundle bundle);
        void makeRequest(Bundle bundle);
    }
}
