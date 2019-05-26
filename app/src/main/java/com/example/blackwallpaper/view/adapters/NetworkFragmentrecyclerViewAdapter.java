package com.example.blackwallpaper.view.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blackwallpaper.interfaces.FromNetworkCallBack;
import com.example.blackwallpaper.Logger;
import com.example.blackwallpaper.R;
import com.example.blackwallpaper.model.CarClass;
import com.example.blackwallpaper.model.City;
import com.example.blackwallpaper.model.Constants;
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
                    City city = new City();
                    city.setId(cityList.get(position).getId());
                    city.setName(cityList.get(position).getName());
                    callFromAdapterInterface.callBack(city, Constants.CITY);
                }
            });

        }else if (showRoomList!=null){
            holder.textView.setText(showRoomList.get(position).getName());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ShowRoom showRoom = new ShowRoom();
                    showRoom.setCityId(showRoomList.get(position).getCityId());
                    showRoom.setId(showRoomList.get(position).getId());
                    showRoom.setName(showRoomList.get(position).getName());
                    callFromAdapterInterface.callBack(showRoom, Constants.DEALER);
                }
            });
        }else if (yearList!=null){
            Logger.toLog("year "+yearList.get(position));
            holder.textView.setText(String.valueOf(yearList.get(position)));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callFromAdapterInterface.callBack(yearList.get(position),Constants.YEAR);
                }
            });
        }else if(carClassList!=null){
            Logger.toLog("Class "+carClassList.get(position).getName());
            holder.textView.setText(carClassList.get(position).getName());
           holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CarClass carClass = new CarClass();
                    carClass.setId(carClassList.get(position).getId());
                    carClass.setName(carClassList.get(position).getName());
                    callFromAdapterInterface.callBack(carClass, Constants.CLASS);
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

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.networkDataTextView);
        }
    }


}
