package com.example.blackwallpaper.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.blackwallpaper.interfaces.contract.MainFragmentyContract;
import com.example.blackwallpaper.presenter.MainFragmentPresenter;
import com.example.blackwallpaper.R;
import com.example.blackwallpaper.model.LayoutModel;
import com.example.blackwallpaper.view.adapters.MainRecyclerViewAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainFragmentyContract.View {

    RecyclerView recyclerView;
    MainRecyclerViewAdapter adapter;
    MainFragmentyContract.Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MainFragmentPresenter(this);
        presenter.onCreate();


    }


    @Override
    public void initRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void fillRecyclerView(List<LayoutModel> layoutModels) {
        adapter = new MainRecyclerViewAdapter(layoutModels);
        recyclerView.setAdapter(adapter);
    }

}
