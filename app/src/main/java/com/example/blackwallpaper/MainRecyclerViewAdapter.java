package com.example.blackwallpaper;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

import static com.example.blackwallpaper.LayoutModel.CITY_TYPE;
import static com.example.blackwallpaper.LayoutModel.CLASS_TYPE;
import static com.example.blackwallpaper.LayoutModel.DEALER_TYPE;
import static com.example.blackwallpaper.LayoutModel.EMAIL_TYPE;
import static com.example.blackwallpaper.LayoutModel.FNAME_TYPE;
import static com.example.blackwallpaper.LayoutModel.NAME_TYPE;
import static com.example.blackwallpaper.LayoutModel.PHONE_TYPE;
import static com.example.blackwallpaper.LayoutModel.SURNAME_TYPE;
import static com.example.blackwallpaper.LayoutModel.SWITCH_TYPE;
import static com.example.blackwallpaper.LayoutModel.VIN_TYPE;
import static com.example.blackwallpaper.LayoutModel.YEAR_TYPE;

public class MainRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<LayoutModel>list;



    public MainRecyclerViewAdapter(List<LayoutModel>list) {
        this.list = list;
    }

    @Override
    public int getItemViewType(int position) {
        LayoutModel layoutModel = list.get(position);
        if(layoutModel !=null){
            layoutModel.getType();

        }

        return 0;
//        return super.getItemViewType(position);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;// = LayoutInflater.from(parent.getContext()).inflate(R.layout)
        switch (viewType){
            case SWITCH_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.switch_layout,parent,false);
                return new SwitchViewHolder(view);
            case SURNAME_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.surname_layout,parent,false);
                return new SurmaneViewHolder(view);
            case NAME_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.name_layout,parent,false);
                return new NameViewHolder(view);
            case FNAME_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fname_layout,parent,false);
                return new FnameViewHolder(view);
            case PHONE_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.phone_layout,parent,false);
                return new PhoneViewHolder(view);
            case EMAIL_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.email_layout,parent,false);
                return new EmailViewHolder(view);
            case VIN_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vin_layout,parent,false);
                return new VINViewHolder(view);
            case YEAR_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.year_layout,parent,false);
                return new YearViewHolder(view);
            case DEALER_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dealer_layout,parent,false);
                return new DealerHolder(view);
            case CITY_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.city_layout,parent,false);
                return new CityHolder(view);
            case CLASS_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.class_layout,parent,false);
                return new ClassViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        LayoutModel layoutModel = list.get(position);
        switch (layoutModel.getType()){
            case SWITCH_TYPE:
                ((SwitchViewHolder)holder).mrButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                ((SwitchViewHolder)holder).msButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
            case SURNAME_TYPE:

            case NAME_TYPE:

            case FNAME_TYPE:

            case PHONE_TYPE:

            case EMAIL_TYPE:

            case VIN_TYPE:

            case YEAR_TYPE:

            case DEALER_TYPE:

            case CITY_TYPE:

            case CLASS_TYPE:

        }
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class SwitchViewHolder extends RecyclerView.ViewHolder{
        Button mrButton, msButton;
        public SwitchViewHolder(@NonNull View itemView) {
            super(itemView);
            mrButton = itemView.findViewById(R.id.maleButton);
            msButton = itemView.findViewById(R.id.femaleButton);

        }
    }
    class NameViewHolder extends RecyclerView.ViewHolder{
        public NameViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
    class SurmaneViewHolder extends RecyclerView.ViewHolder{
        public SurmaneViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
    class FnameViewHolder extends RecyclerView.ViewHolder{
        public FnameViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
    class PhoneViewHolder extends RecyclerView.ViewHolder{
        public PhoneViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
    class EmailViewHolder extends RecyclerView.ViewHolder{
        public EmailViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
    class VINViewHolder extends RecyclerView.ViewHolder{
        public VINViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
    class YearViewHolder extends RecyclerView.ViewHolder{
        public YearViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
    class ClassViewHolder extends RecyclerView.ViewHolder{
        public ClassViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
    class DealerHolder extends RecyclerView.ViewHolder{
        public DealerHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
    class CityHolder extends RecyclerView.ViewHolder{
        public CityHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
