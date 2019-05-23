package com.example.blackwallpaper.interfaces.contract;

import com.example.blackwallpaper.model.LayoutModel;

import java.util.List;

public interface MainFragmentyContract {
    interface View{
        void initRecyclerView();
        void fillRecyclerView(List<LayoutModel>layoutModels);
        void attachCityFragment();
        void attachDealerFragment();
        void attachYearFragment();
        void makeToast(String s);
    }
    interface Model{
        List<LayoutModel>laoutmodels();
    }
    interface Presenter{
        void onCreate();
        void provideDataSet();
        void onReciclerViewItemClicked(int i, String s);


    }
}
