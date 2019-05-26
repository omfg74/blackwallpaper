package com.example.blackwallpaper.view.adapters;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.blackwallpaper.Logger;
import com.example.blackwallpaper.R;
import com.example.blackwallpaper.ServiceApplication;
import com.example.blackwallpaper.interfaces.CallFromAdapterInterface;
import com.example.blackwallpaper.model.CarClass;
import com.example.blackwallpaper.model.City;
import com.example.blackwallpaper.model.LayoutModel;
import com.example.blackwallpaper.model.ShowRoom;
import com.example.blackwallpaper.model.UserInfo;
import com.example.blackwallpaper.utils.DataSaver;
import com.example.blackwallpaper.utils.DataValidator;

import java.util.List;

import static com.example.blackwallpaper.model.LayoutModel.CITY_TYPE;
import static com.example.blackwallpaper.model.LayoutModel.CLASS_TYPE;
import static com.example.blackwallpaper.model.LayoutModel.DEALER_TYPE;
import static com.example.blackwallpaper.model.LayoutModel.EMAIL_TYPE;
import static com.example.blackwallpaper.model.LayoutModel.FNAME_TYPE;
import static com.example.blackwallpaper.model.LayoutModel.NAME_TYPE;
import static com.example.blackwallpaper.model.LayoutModel.PHONE_TYPE;
import static com.example.blackwallpaper.model.LayoutModel.SURNAME_TYPE;
import static com.example.blackwallpaper.model.LayoutModel.SWITCH_TYPE;
import static com.example.blackwallpaper.model.LayoutModel.VIN_TYPE;
import static com.example.blackwallpaper.model.LayoutModel.YEAR_TYPE;

public class MainRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<LayoutModel> list;
    CallFromAdapterInterface callFromAdapterInterface;
    String city;
    City cityObject;
    int yearObject;
    Button mrButton, msButton;
    String buttonSeleector = ServiceApplication.getContext().getString(R.string.mr) ;
    CarClass carClassObject;
    ShowRoom showRoomObject;
    private TextView yearDataTextView,
            yearTitleTextView,
            switchTitletextView,
            surnameTitleTextView,
            fnameTitleTextView,
            nameTitleTextView,
            dealerTitleTextView,
            dealerDataTextView,
            phoneTitleTextView,
            emailTitleTextView,
            classTitleTextView,
            classDatatextView,
            cityTitleTextView,
            cityDataTextView,
            vinTitleTextView;
    private EditText surnameEditText,
            nameEditText,
            fnameEditText,
            phoneEditText,
            emailEdittext,
            vinEditText;

    public MainRecyclerViewAdapter(List<LayoutModel> list, CallFromAdapterInterface callFromAdapterInterface) {
        this.list = list;
        this.callFromAdapterInterface = callFromAdapterInterface;
    }

    @Override
    public int getItemViewType(int position) {
        LayoutModel layoutModel = list.get(position);
        if (layoutModel != null) {
            return layoutModel.getType();
        }
        return 0;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case SWITCH_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.switch_layout, parent, false);
                return new SwitchViewHolder(view);
            case SURNAME_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.edittext_layout, parent, false);
                return new SurmaneViewHolder(view);
            case NAME_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.edittext_layout, parent, false);
                return new NameViewHolder(view);
            case FNAME_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.edittext_layout, parent, false);
                return new FnameViewHolder(view);
            case PHONE_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.phone_layout, parent, false);
                return new PhoneViewHolder(view);
            case EMAIL_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.edittext_layout, parent, false);
                return new EmailViewHolder(view);
            case VIN_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vin_layout, parent, false);
                return new VINViewHolder(view);
            case YEAR_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.arrow_layout, parent, false);
                return new YearViewHolder(view);
            case DEALER_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.arrow_layout, parent, false);
                return new DealerHolder(view);
            case CITY_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.arrow_layout, parent, false);
                return new CityHolder(view);
            case CLASS_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.arrow_layout, parent, false);
                return new ClassViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {

        LayoutModel layoutModel = list.get(position);
        switch (layoutModel.getType()) {
            case SWITCH_TYPE:
                switchTitletextView.setText(list.get(position).getTitle());
                mrButton.setText(ServiceApplication.getContext().getString(R.string.mr));
                mrButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        buttonSeleector = ServiceApplication.getContext().getString(R.string.mr);
                        mrButton.setBackgroundColor(ServiceApplication.getContext().getColor(R.color.colorWhite));
                        mrButton.setTextColor(ServiceApplication.getContext().getColor(R.color.colorPrimaryDark));
                        msButton.setBackgroundColor(ServiceApplication.getContext().getColor(R.color.colorPrimaryDark));
                        msButton.setTextColor(ServiceApplication.getContext().getColor(R.color.colorWhite));
                    }
                });
                msButton.setText(ServiceApplication.getContext().getString(R.string.ms));
                msButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        buttonSeleector = ServiceApplication.getContext().getString(R.string.ms);
                        msButton.setBackgroundColor(ServiceApplication.getContext().getColor(R.color.colorWhite));
                        msButton.setTextColor(ServiceApplication.getContext().getColor(R.color.colorPrimaryDark));
                        mrButton.setBackgroundColor(ServiceApplication.getContext().getColor(R.color.colorPrimaryDark));
                        mrButton.setTextColor(ServiceApplication.getContext().getColor(R.color.colorWhite));
                    }
                });
                break;
            case SURNAME_TYPE:
                surnameTitleTextView.setText(list.get(position).getTitle());
                surnameEditText.setHint(list.get(position).getData());
                break;
            case NAME_TYPE:
                nameTitleTextView.setText(list.get(position).getTitle());
                nameEditText.setHint(list.get(position).getData());
                break;
            case FNAME_TYPE:
                fnameTitleTextView.setText(list.get(position).getTitle());
                fnameEditText.setHint(list.get(position).getData());
                break;
            case PHONE_TYPE:
               phoneTitleTextView.setText(list.get(position).getTitle());
                phoneEditText.setHint(list.get(position).getData());
                break;
            case EMAIL_TYPE:
                emailTitleTextView.setText(list.get(position).getTitle());
                emailEdittext.setHint(list.get(position).getData());
                break;
            case VIN_TYPE:
               vinTitleTextView.setText(list.get(position).getTitle());
               vinEditText.setHint(list.get(position).getData());
                break;
            case YEAR_TYPE:
                yearTitleTextView.setText(list.get(position).getTitle());
                yearDataTextView.setText(list.get(position).getData());
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        callFromAdapterInterface.onItemClicked(position, null);
                    }
                });
                break;
            case DEALER_TYPE:
             dealerTitleTextView.setText(list.get(position).getTitle());
                dealerDataTextView.setText(list.get(position).getData());
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        callFromAdapterInterface.onItemClicked(position, city);
                    }
                });
                break;
            case CITY_TYPE:
             cityTitleTextView.setText(list.get(position).getTitle());
               cityDataTextView.setText(list.get(position).getData());
                city = cityDataTextView.getText().toString();
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        callFromAdapterInterface.onItemClicked(position, null);
                    }
                });
                break;
            case CLASS_TYPE:
                classTitleTextView.setText(list.get(position).getTitle());
                classDatatextView.setText(list.get(position).getData());
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DataSaver dataSaver = new DataSaver();
                        callFromAdapterInterface.onItemClicked(position, null);
                    }
                });
                break;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setCity(City city) {
        this.cityObject = city;
        list.set(7, new LayoutModel("City",8,city.getName()));
        Logger.toLog("city test "+city.getName());
//        notifyItemPositionChanged();
        notifyDataSetChanged();
    }

    public void setDealer(ShowRoom showRoom) {
        this.showRoomObject = showRoom;
        list.set(8, new LayoutModel(ServiceApplication.getContext().getString(R.string.choose_your_dealer_title),9,showRoom.getName()));
        Logger.toLog(showRoom.getName());
        notifyDataSetChanged();
    }

    public void setYear(int year) {
        this.yearObject = year;
        list.set(9, new LayoutModel(ServiceApplication.getContext().getString(R.string.choose_year_title),10,String.valueOf(year)));
        Logger.toLog("Y "+year);
        notifyDataSetChanged();
    }

    public void setClass(CarClass carClass) {
        this.carClassObject = carClass;
        list.set(10, new LayoutModel(ServiceApplication.getContext().getString(R.string.choose_class),11,carClass.getName()));
        Logger.toLog(carClass.getName());
        notifyDataSetChanged();
    }

    public UserInfo collectAllData() {
        if (showRoomObject!=null&carClassObject!=null&cityObject!=null&yearObject!=0) {
            DataValidator dataValidator = new DataValidator();
            UserInfo userInfo = new UserInfo();
            userInfo.setLastName(buttonSeleector + " " + surnameEditText.getText().toString());
            userInfo.setFirstName(nameEditText.getText().toString());
            userInfo.setMiddleName(fnameEditText.getText().toString());
            userInfo.setPhone(phoneEditText.getText().toString());
            userInfo.setEmail(emailEdittext.getText().toString());
            userInfo.setVin(vinEditText.getText().toString());
            userInfo.setCity(cityDataTextView.getText().toString());
            userInfo.setDealerId(showRoomObject.getId());
            userInfo.setYear(yearDataTextView.getText().toString());
            userInfo.setClassId(carClassObject.getId());
            if (dataValidator.check(userInfo)) {
                return userInfo;
            }
        }
        return null;
    }

    public void saveData() {

    }

    class SwitchViewHolder extends RecyclerView.ViewHolder {

        public SwitchViewHolder(@NonNull View itemView) {
            super(itemView);
            switchTitletextView = itemView.findViewById(R.id.switchTextView);
            switchTitletextView.setTextColor(ServiceApplication.getContext().getColor(R.color.colorWhite));
            mrButton = itemView.findViewById(R.id.maleButton);
            mrButton.setBackgroundColor(ServiceApplication.getContext().getColor(R.color.colorWhite));
            mrButton.setTextColor(ServiceApplication.getContext().getColor(R.color.colorPrimaryDark));
            msButton = itemView.findViewById(R.id.femaleButton);
            msButton.setBackgroundColor(ServiceApplication.getContext().getColor(R.color.colorPrimaryDark));
            msButton.setTextColor(ServiceApplication.getContext().getColor(R.color.colorWhite));
        }
    }

    class NameViewHolder extends RecyclerView.ViewHolder {
        public NameViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTitleTextView = itemView.findViewById(R.id.editTextTitleTextView);
            nameTitleTextView.setTextColor(ServiceApplication.getContext().getColor(R.color.colorWhite));
            nameEditText = itemView.findViewById(R.id.dataEditText);
            nameEditText.setTextColor(ServiceApplication.getContext().getColor(R.color.colorWhite));
            nameEditText.setHintTextColor(ServiceApplication.getContext().getColor(R.color.colorGray));
//            nameEditText.setText(ServiceApplication.getContext().getString(R.string.text_field_enter_your_name));
        }

    }

    class SurmaneViewHolder extends RecyclerView.ViewHolder {
        public SurmaneViewHolder(@NonNull View itemView) {
            super(itemView);
            surnameTitleTextView = itemView.findViewById(R.id.editTextTitleTextView);
            surnameTitleTextView.setTextColor(ServiceApplication.getContext().getColor(R.color.colorWhite));
            surnameEditText = itemView.findViewById(R.id.dataEditText);
            surnameEditText.setTextColor(ServiceApplication.getContext().getColor(R.color.colorWhite));
            surnameEditText.setHintTextColor(ServiceApplication.getContext().getColor(R.color.colorGray));
//            surnameEditText.setText(ServiceApplication.getContext().getString(R.string.text_field_enter_your_surname));
        }
    }

    class FnameViewHolder extends RecyclerView.ViewHolder {
        public FnameViewHolder(@NonNull View itemView) {
            super(itemView);
            fnameTitleTextView = itemView.findViewById(R.id.editTextTitleTextView);
            fnameTitleTextView.setTextColor(ServiceApplication.getContext().getColor(R.color.colorWhite));
            fnameEditText = itemView.findViewById(R.id.dataEditText);
            fnameEditText.setTextColor(ServiceApplication.getContext().getColor(R.color.colorWhite));
            fnameEditText.setHintTextColor(ServiceApplication.getContext().getColor(R.color.colorGray));
//            fnameEditText.setText(ServiceApplication.getContext().getString(R.string.text_field_enter_your_fname));

        }
    }

    class PhoneViewHolder extends RecyclerView.ViewHolder {
//        TextView phoneTitleTextView;
//        EditText phoneEditText;

        public PhoneViewHolder(@NonNull View itemView) {
            super(itemView);
            phoneTitleTextView = itemView.findViewById(R.id.phoneTitleTextView);
            phoneEditText = itemView.findViewById(R.id.phoneDataEditText);
            phoneTitleTextView.setTextColor(ServiceApplication.getContext().getColor(R.color.colorWhite));
            phoneEditText.setTextColor(ServiceApplication.getContext().getColor(R.color.colorWhite));
            phoneEditText.setHintTextColor(ServiceApplication.getContext().getColor(R.color.colorGray));

        }
    }

    class EmailViewHolder extends RecyclerView.ViewHolder {
//        EditText emailEdittext;
//        TextView emailTitleTextView;

        public EmailViewHolder(@NonNull View itemView) {
            super(itemView);
            emailTitleTextView = itemView.findViewById(R.id.editTextTitleTextView);
            emailEdittext = itemView.findViewById(R.id.dataEditText);
            emailTitleTextView.setTextColor(ServiceApplication.getContext().getColor(R.color.colorWhite));
            emailEdittext.setTextColor(ServiceApplication.getContext().getColor(R.color.colorWhite));
            emailEdittext.setHintTextColor(ServiceApplication.getContext().getColor(R.color.colorGray));
//            emailEdittext.setText(ServiceApplication.getContext().getString(R.string.text_field_enter_your_email));
        }
    }

    class VINViewHolder extends RecyclerView.ViewHolder {
//        EditText vinEditText;
//        TextView vinTitleTextView;

        public VINViewHolder(@NonNull View itemView) {
            super(itemView);
            vinTitleTextView = itemView.findViewById(R.id.vinTitleTextView);
            vinEditText = itemView.findViewById(R.id.vinEditText);
            vinTitleTextView.setTextColor(ServiceApplication.getContext().getColor(R.color.colorWhite));
            vinEditText.setTextColor(ServiceApplication.getContext().getColor(R.color.colorWhite));
            vinEditText.setHintTextColor(ServiceApplication.getContext().getColor(R.color.colorGray));
//            vinEditText.setText(ServiceApplication.getContext().getString(R.string.text_field_enter_your_vin));
        }
    }

    class YearViewHolder extends RecyclerView.ViewHolder {
//         yearTitleTextView, yearDataTextView;

        public YearViewHolder(@NonNull View itemView) {
            super(itemView);
            yearTitleTextView = itemView.findViewById(R.id.arrowTitleTextView);
            yearDataTextView = itemView.findViewById(R.id.arrowDatatextView);
            yearTitleTextView.setTextColor(ServiceApplication.getContext().getColor(R.color.colorWhite));
            yearDataTextView.setTextColor(ServiceApplication.getContext().getColor(R.color.colorWhite));
            yearDataTextView.setHintTextColor(ServiceApplication.getContext().getColor(R.color.colorGray));
//            yearDataTextView.setText(ServiceApplication.getContext().getString(R.string.text_field_enter_year));
        }

    }

    class ClassViewHolder extends RecyclerView.ViewHolder {
//        TextView classTitleTextView, classDatatextView,cityTitleTextView, cityDataTextView;

        public ClassViewHolder(@NonNull View itemView) {
            super(itemView);
            classTitleTextView = itemView.findViewById(R.id.arrowTitleTextView);
            classDatatextView = itemView.findViewById(R.id.arrowDatatextView);
            classTitleTextView.setTextColor(ServiceApplication.getContext().getColor(R.color.colorWhite));
            classDatatextView.setTextColor(ServiceApplication.getContext().getColor(R.color.colorWhite));
            classDatatextView.setHintTextColor(ServiceApplication.getContext().getColor(R.color.colorGray));
//            classDatatextView.setText(ServiceApplication.getContext().getString(R.string.choose_class));
        }
    }

    class DealerHolder extends RecyclerView.ViewHolder {
//        TextView dealerTitleTextView, dealerDataTextView;

        public DealerHolder(@NonNull View itemView) {
            super(itemView);
            dealerTitleTextView = itemView.findViewById(R.id.arrowTitleTextView);
            dealerDataTextView = itemView.findViewById(R.id.arrowDatatextView);
            dealerTitleTextView.setTextColor(ServiceApplication.getContext().getColor(R.color.colorWhite));
            dealerDataTextView.setTextColor(ServiceApplication.getContext().getColor(R.color.colorWhite));
            dealerDataTextView.setHintTextColor(ServiceApplication.getContext().getColor(R.color.colorGray));
//            dealerDataTextView.setText(ServiceApplication.getContext().getString(R.string.choose_your_city_title));
        }
    }

    class CityHolder extends RecyclerView.ViewHolder {
//        TextView cityTitleTextView, cityDataTextView;

        public CityHolder(@NonNull View itemView) {
            super(itemView);
            cityTitleTextView = itemView.findViewById(R.id.arrowTitleTextView);
            cityDataTextView = itemView.findViewById(R.id.arrowDatatextView);
            cityTitleTextView.setTextColor(ServiceApplication.getContext().getColor(R.color.colorWhite));
            cityDataTextView.setTextColor(ServiceApplication.getContext().getColor(R.color.colorWhite));
            cityDataTextView.setHintTextColor(ServiceApplication.getContext().getColor(R.color.colorGray));
        }
    }


}
