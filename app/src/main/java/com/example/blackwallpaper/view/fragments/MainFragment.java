package com.example.blackwallpaper.view.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blackwallpaper.R;
import com.example.blackwallpaper.interfaces.CallFromAdapterInterface;
import com.example.blackwallpaper.interfaces.contract.MainFragmentyContract;
import com.example.blackwallpaper.model.LayoutModel;
import com.example.blackwallpaper.presenter.MainFragmentPresenter;
import com.example.blackwallpaper.view.adapters.MainRecyclerViewAdapter;

import java.util.List;

public class MainFragment extends Fragment implements MainFragmentyContract.View, CallFromAdapterInterface {
    RecyclerView recyclerView;
    MainRecyclerViewAdapter adapter;
    MainFragmentyContract.Presenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new MainFragmentPresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerView);
        presenter.onCreate();
    }
    @Override
    public void initRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void fillRecyclerView(List<LayoutModel> layoutModels) {
        adapter = new MainRecyclerViewAdapter(layoutModels, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClicked(int s) {
        Log.d("Log", "on item clicked "+s);
    }
}
