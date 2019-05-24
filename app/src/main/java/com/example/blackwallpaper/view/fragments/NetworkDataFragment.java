package com.example.blackwallpaper.view.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blackwallpaper.FromNetworkCallBack;
import com.example.blackwallpaper.Logger;
import com.example.blackwallpaper.R;
import com.example.blackwallpaper.interfaces.contract.NetworkdataFragmentContract;
import com.example.blackwallpaper.model.CarClass;
import com.example.blackwallpaper.model.City;
import com.example.blackwallpaper.model.ShowRoom;
import com.example.blackwallpaper.presenter.NetworkDataFragmentPresenter;
import com.example.blackwallpaper.view.adapters.NetworkFragmentrecyclerViewAdapter;

import java.io.Serializable;
import java.util.List;

public class NetworkDataFragment extends Fragment implements NetworkdataFragmentContract.Viev, FromNetworkCallBack {

    NetworkdataFragmentContract.Presenter presenter;
    RecyclerView netRecyclerView;
    NetworkFragmentrecyclerViewAdapter adapter;
    View view;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.network_data_fragment, container, false);
        return view;
//        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        netRecyclerView = view.findViewById(R.id.networkDatarecyclerView);
        netRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        presenter = new NetworkDataFragmentPresenter(this);
        presenter.onCreate(getArguments());
    }

    @Override
    public void placeItamsTorecyclerView(List list, String type) {
        Logger.toLog("Type " + type + " " + "List " + list.size());
        if (type.equalsIgnoreCase("city")) {
            List<City> cities = list;
            adapter = new NetworkFragmentrecyclerViewAdapter(this, cities, null, null, null);
        } else if (type.equalsIgnoreCase("class")) {
            adapter = new NetworkFragmentrecyclerViewAdapter(this, null, null, null, list);
        } else if (type.equalsIgnoreCase("dealer")) {
            adapter = new NetworkFragmentrecyclerViewAdapter(this, null, list, null, null);
        } else if (type.equalsIgnoreCase("year")) {
            adapter = new NetworkFragmentrecyclerViewAdapter(this, null, null, list, null);
        }
        netRecyclerView.setAdapter(adapter);
    }


    @Override
    public void callBack(Object baseNetworkObject, String type) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putSerializable("object", (Serializable) baseNetworkObject);
        bundle.putString("type",type);
        intent.putExtras(bundle);
        getTargetFragment().onActivityResult(111, 1, intent);
        getFragmentManager().popBackStack();
    }
}
