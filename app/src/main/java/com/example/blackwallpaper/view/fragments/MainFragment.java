package com.example.blackwallpaper.view.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blackwallpaper.R;
import com.example.blackwallpaper.interfaces.CallFromAdapterInterface;
import com.example.blackwallpaper.interfaces.contract.MainFragmentyContract;
import com.example.blackwallpaper.model.CarClass;
import com.example.blackwallpaper.model.City;
import com.example.blackwallpaper.model.Constants;
import com.example.blackwallpaper.model.LayoutModel;
import com.example.blackwallpaper.model.ShowRoom;
import com.example.blackwallpaper.model.UserInfo;
import com.example.blackwallpaper.presenter.MainFragmentPresenter;
import com.example.blackwallpaper.view.adapters.MainRecyclerViewAdapter;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class MainFragment extends Fragment implements MainFragmentyContract.View, CallFromAdapterInterface {
    RecyclerView recyclerView;
    MainRecyclerViewAdapter adapter;
    MainFragmentyContract.Presenter presenter;
    View view;
    LinearLayoutManager linearLayoutManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new MainFragmentPresenter(this);
        presenter.onCreate();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.main_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerView);
        presenter.onViewCreated();

    }

    @Override
    public void initRecyclerView() {
        linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void fillRecyclerView(List<LayoutModel> layoutModels) {
        adapter = new MainRecyclerViewAdapter(layoutModels, this);

    }

    @Override
    public void attachCityFragment() {
        changeFragment("city");
    }


    @Override
    public void attachDealerFragment(int id) {
        changeFragment("dealer", id);
    }

    private void changeFragment(String type, int id) {
        Bundle bundle = new Bundle();
        bundle.putString(Constants.TYPE, type);
        bundle.putInt("id", id);
        DialogFragment networkDataFragment = new NetworkDataFragment();
        networkDataFragment.setArguments(bundle);
        networkDataFragment.setTargetFragment(this, 111);
        networkDataFragment.show(getFragmentManager(), networkDataFragment.getClass().getName());
    }

    @Override
    public void attachYearFragment() {
        changeFragment("year");
    }

    @Override
    public void attachClassFragment() {
        changeFragment("class");
    }

    @Override
    public void makeToast(String s) {
        Snackbar.make(view, s, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void setCityText(City city) {
        adapter.setCity(city);
    }

    @Override
    public void setDealerText(ShowRoom showRoom) {
        adapter.setDealer(showRoom);
    }

    @Override
    public void setYearText(int year) {
        adapter.setYear(year);
    }

    @Override
    public void setClassText(CarClass carClass) {
        adapter.setClass(carClass);
    }

    @Override
    public UserInfo fetchData() {

        return adapter.collectAllData();
    }

    @Override
    public void onItemClicked(int i, String s) {
        presenter.onReciclerViewItemClicked(i, s);
    }


    private void changeFragment(String type) {
        Bundle bundle = new Bundle();
        bundle.putString("type", type);
        DialogFragment networkDataFragment = new NetworkDataFragment();
        networkDataFragment.setArguments(bundle);
        networkDataFragment.setTargetFragment(this, 111);
        networkDataFragment.show(getFragmentManager(), networkDataFragment.getClass().getName());
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 111:
                presenter.onActivityResult(data);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        presenter.onDetach();
    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.onResume();
    }
}
