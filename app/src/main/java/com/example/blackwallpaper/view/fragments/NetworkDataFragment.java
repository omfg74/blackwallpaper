package com.example.blackwallpaper.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.blackwallpaper.interfaces.contract.NetworkdataFragmentContract;
import com.example.blackwallpaper.presenter.NetworkdataFragmentPresenter;

public class NetworkDataFragment extends Fragment implements NetworkdataFragmentContract.Viev {

    NetworkdataFragmentContract.Presenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new NetworkdataFragmentPresenter(this);
        presenter.onCreate(getArguments());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void placeItamsTorecyclerView() {

    }
}
