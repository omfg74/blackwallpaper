package com.example.blackwallpaper.view.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blackwallpaper.FromNetworkCallBack;
import com.example.blackwallpaper.Logger;
import com.example.blackwallpaper.R;
import com.example.blackwallpaper.interfaces.CallFromAdapterInterface;
import com.example.blackwallpaper.model.CarClass;
import com.example.blackwallpaper.model.City;
import com.example.blackwallpaper.model.ShowRoom;

import java.util.List;

public class NetworkFragmentrecyclerViewAdapter extends RecyclerView.Adapter<NetworkFragmentrecyclerViewAdapter.ViewHolder> {
    List<City> cityList;
    List<ShowRoom> showRoomList;
    List<Integer> yearList;
    List<CarClass>carClassList;
    View view;
    FromNetworkCallBack callFromAdapterInterface;
    public NetworkFragmentrecyclerViewAdapter(FromNetworkCallBack callFromAdapterInterface, List<City> cityList, List<ShowRoom> showRooms,  List<Integer> yearList,  List<CarClass>carClasses ) {
        this.callFromAdapterInterface = callFromAdapterInterface;
        this.cityList = cityList;
        this.yearList=  yearList;
        this.carClassList = carClasses;
        this.showRoomList = showRooms;
    }

    @NonNull
    @Override
    public NetworkFragmentrecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.network_data_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NetworkFragmentrecyclerViewAdapter.ViewHolder holder, final int position) {
        if (cityList!=null){
            Logger.toLog("fill test "+cityList.get(position).getName());
            holder.textView.setText(cityList.get(position).getName());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callFromAdapterInterface.callBack(cityList.get(position).getId(), cityList.get(position).getName());
                }
            });

        }else if (showRoomList!=null){
            holder.textView.setText(showRoomList.get(position).getName());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callFromAdapterInterface.callBack(showRoomList.get(position).getId(), showRoomList.get(position).getName());
                }
            });
        }else if (yearList!=null){
            Logger.toLog("year "+yearList.get(position));
            holder.textView.setText(String.valueOf(yearList.get(position)));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callFromAdapterInterface.callBack(yearList.get(position),null);
                }
            });
        }else if(carClassList!=null){
            Logger.toLog("Class "+carClassList.get(position).getName());
            holder.textView.setText(carClassList.get(position).getName());
           holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callFromAdapterInterface.callBack(carClassList.get(position).getId(), carClassList.get(position).getName());
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if (cityList!=null){
        return cityList.size();
        }else if (showRoomList!=null){
            return showRoomList.size();
        }else if (yearList!=null){
            return yearList.size();
        }else if(carClassList!=null){
            return carClassList.size();
        }
      return 0;
    }
//    public void appendCityData(List list){
//        this.cityList = (List<City>) list;
//        notifyDataSetChanged();
//
//    }
//    public void appendShowRoomData(List list){
//        this.showRoomList = (List<ShowRoom>)list;
//        notifyDataSetChanged();
//    }
//    public void appendYearData(List list){
//        Logger.toLog("year size "+list.size());
//        this.yearList = (List<Integer>)list;
//        notifyDataSetChanged();
//    }
//    public void updateCarClassData(List list){
//        this.carClassList = (List<CarClass>)list;
//        notifyDataSetChanged();
//    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.networkDataTextView);
        }
    }


}
