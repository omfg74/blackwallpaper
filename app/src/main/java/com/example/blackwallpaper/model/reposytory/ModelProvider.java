package com.example.blackwallpaper.model.reposytory;

import com.example.blackwallpaper.R;
import com.example.blackwallpaper.ServiceApplication;
import com.example.blackwallpaper.interfaces.contract.MainFragmentyContract;
import com.example.blackwallpaper.model.LayoutModel;

import java.util.ArrayList;
import java.util.List;

public class ModelProvider implements MainFragmentyContract.Model{
    List<LayoutModel> layoutModels = new ArrayList<>();
    private void dataSet(){
        layoutModels.add(new LayoutModel(ServiceApplication.getContext().getString(R.string.gender),1,null));
        layoutModels.add(new LayoutModel(ServiceApplication.getContext().getString(R.string.surname),4,ServiceApplication.getContext().getString(R.string.text_field_enter_your_surname)));
        layoutModels.add(new LayoutModel(ServiceApplication.getContext().getString(R.string.name),2, ServiceApplication.getContext().getString(R.string.text_field_enter_your_name)));
        layoutModels.add(new LayoutModel(ServiceApplication.getContext().getString(R.string.fname),3,ServiceApplication.getContext().getString(R.string.text_field_enter_your_fname)));
        layoutModels.add(new LayoutModel(ServiceApplication.getContext().getString(R.string.telephone), 5,"+7"));
        layoutModels.add(new LayoutModel(ServiceApplication.getContext().getString(R.string.email),6,ServiceApplication.getContext().getString(R.string.text_field_enter_your_email)));
        layoutModels.add(new LayoutModel(ServiceApplication.getContext().getString(R.string.vin),7, ServiceApplication.getContext().getString(R.string.text_field_enter_your_vin)));
        layoutModels.add(new LayoutModel(ServiceApplication.getContext().getString(R.string.city),8, ServiceApplication.getContext().getString(R.string.choose_your_city_title)));
        layoutModels.add(new LayoutModel(ServiceApplication.getContext().getString(R.string.dealer),9, ServiceApplication.getContext().getString(R.string.choose_your_city_dealer)));
        layoutModels.add(new LayoutModel(ServiceApplication.getContext().getString(R.string.year),10, ServiceApplication.getContext().getString(R.string.text_field_enter_year)));
        layoutModels.add(new LayoutModel(ServiceApplication.getContext().getString(R.string.carClass),11, ServiceApplication.getContext().getString(R.string.choose_class)));
    }

    @Override
    public List<LayoutModel> laoytmodels() {
        dataSet();
        return layoutModels;
    }
}
