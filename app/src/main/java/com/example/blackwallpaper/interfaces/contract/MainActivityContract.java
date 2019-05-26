package com.example.blackwallpaper.interfaces.contract;

public interface MainActivityContract {
    interface View{
        void changeFragment();
    }
    interface Presenter{
        void onCreate();
        void onDoneClicked();
    }
    interface Model{

    }
}
