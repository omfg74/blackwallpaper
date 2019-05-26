package com.example.blackwallpaper.interfaces.contract;

import android.os.Bundle;

import java.util.List;

public interface NetworkdataFragmentContract {
    interface Viev {
        void placeItamsTorecyclerView(List list, String type);
    }

    interface Model {
    }

    interface Presenter {
        void onCreate(Bundle bundle);

        void makeRequest(Bundle bundle);
    }
}
