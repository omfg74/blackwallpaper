package com.example.blackwallpaper.model.reposytory;

import com.example.blackwallpaper.interfaces.contract.MainFragmentyContract;
import com.example.blackwallpaper.model.LayoutModel;

import java.util.ArrayList;
import java.util.List;

public class ModelProvider implements MainFragmentyContract.Model{
    List<LayoutModel> layoutModels = new ArrayList<>();
    private void dataSet(){
        layoutModels.add(new LayoutModel("switch",1));
        layoutModels.add(new LayoutModel("Surname",4));
        layoutModels.add(new LayoutModel("name",2));
        layoutModels.add(new LayoutModel("Second name ",3));
        layoutModels.add(new LayoutModel("phone", 5));
        layoutModels.add(new LayoutModel("email",6));
        layoutModels.add(new LayoutModel("VIN",7));
        layoutModels.add(new LayoutModel("City",8));
        layoutModels.add(new LayoutModel("Dealer",9));
        layoutModels.add(new LayoutModel("Year",10));
        layoutModels.add(new LayoutModel("Class ",11));
    }

    @Override
    public List<LayoutModel> laoutmodels() {
        dataSet();
        return layoutModels;
    }
}
