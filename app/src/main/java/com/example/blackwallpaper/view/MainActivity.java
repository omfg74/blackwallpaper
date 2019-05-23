package com.example.blackwallpaper.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.blackwallpaper.interfaces.contract.MainActivityContract;
import com.example.blackwallpaper.interfaces.contract.MainFragmentyContract;
import com.example.blackwallpaper.presenter.MainActivityPresenter;
import com.example.blackwallpaper.presenter.MainFragmentPresenter;
import com.example.blackwallpaper.R;
import com.example.blackwallpaper.model.LayoutModel;
import com.example.blackwallpaper.view.adapters.MainRecyclerViewAdapter;
import com.example.blackwallpaper.view.fragments.MainFragment;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {


    MainActivityContract.Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MainActivityPresenter(this);
        presenter.onCreate();


    }


    @Override
    public void changeFragment() {
        MainFragment mainFragment = new MainFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.mainfragmentPlace,mainFragment)
                .commit();
    }
}
