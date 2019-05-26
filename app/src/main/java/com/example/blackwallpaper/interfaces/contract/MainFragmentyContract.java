package com.example.blackwallpaper.interfaces.contract;

import android.content.Intent;

import com.example.blackwallpaper.model.CarClass;
import com.example.blackwallpaper.model.City;
import com.example.blackwallpaper.model.LayoutModel;
import com.example.blackwallpaper.model.ShowRoom;
import com.example.blackwallpaper.model.UserInfo;

import java.util.List;

public interface MainFragmentyContract {
    interface View{
        void initRecyclerView();
        void fillRecyclerView(List<LayoutModel>layoutModels);
        void attachCityFragment();
        void attachDealerFragment(int id);
        void attachYearFragment();
        void attachClassFragment();
        void makeToast(String s);
        void setCityText(City city);
        void setDealerText(ShowRoom showRoom);
        void setYearText(int year);
        void setClassText(CarClass carClass);
        UserInfo fetchData();
    }
    interface Model{
        List<LayoutModel> laoytmodels();
    }
    interface Presenter{
        void onCreate();
        void provideDataSet();
        void onReciclerViewItemClicked(int i, String s);
        void onViewCreated();
        void onActivityResult(Intent data);
        void onDetach();
    }
}
