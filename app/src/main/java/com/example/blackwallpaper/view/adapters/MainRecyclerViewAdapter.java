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
                switchTitletextView.setText("Обращение");
                ((SwitchViewHolder) holder).mrButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                });
                ((SwitchViewHolder) holder).msButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                break;
            case SURNAME_TYPE:
                surnameTitleTextView.setText(ServiceApplication.getContext().getString(R.string.surname));
                surnameEditText.setHint(ServiceApplication.getContext().getString(R.string.text_field_enter_your_name));
                break;
            case NAME_TYPE:
                nameTitleTextView.setText(R.string.name);
                nameEditText.setHint(ServiceApplication.getContext().getString(R.string.text_field_enter_your_name));
                break;
            case FNAME_TYPE:
                fnameTitleTextView.setText(ServiceApplication.getContext().getString(R.string.fname));
                fnameEditText.setHint(ServiceApplication.getContext().getString(R.string.text_field_enter_your_fname));
                break;
            case PHONE_TYPE:
               phoneTitleTextView.setText(ServiceApplication.getContext().getString(R.string.telephone));
                phoneEditText.setHint(ServiceApplication.getContext().getString(R.string.enter_your_phone_number));
                break;
            case EMAIL_TYPE:
                emailTitleTextView.setText("Email");
                emailEdittext.setHint("Enter your email");
                break;
            case VIN_TYPE:
               vinTitleTextView.setText("VIN");
               vinEditText.setHint("Enter your VIN");
                break;
            case YEAR_TYPE:
                yearDataTextView.setText("Coose year");
//               holder.yearTitleTextView.setText("Year");
//                yearDataTextView.setText("Choose year");
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        callFromAdapterInterface.onItemClicked(position, null);
                    }
                });
                break;
            case DEALER_TYPE:
             dealerTitleTextView.setText("Deler");
                dealerDataTextView.setText(ServiceApplication.getContext().getString(R.string.choose_your_dealer_title));
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        callFromAdapterInterface.onItemClicked(position, city);
                    }
                });
                break;
            case CITY_TYPE:
             cityTitleTextView.setText("City");
               cityDataTextView.setText(ServiceApplication.getContext().getString(R.string.choose_your_city_title));
                city = cityDataTextView.getText().toString();
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        callFromAdapterInterface.onItemClicked(position, null);
                    }
                });
                break;
            case CLASS_TYPE:
                classTitleTextView.setText("Class");
                classDatatextView.setText(ServiceApplication.getContext().getString(R.string.choose_class));
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
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
        cityDataTextView.setText(city.getName());
        Logger.toLog("city test "+city.getName());
        notifyDataSetChanged();
    }

    public void setDealer(ShowRoom showRoom) {
        this.showRoomObject = showRoom;
        dealerDataTextView.setText(showRoom.getName());
        Logger.toLog(showRoom.getName());
        notifyDataSetChanged();
    }

    public void setYear(int year) {
        this.yearObject = year;
        yearDataTextView.setText(String.valueOf(yearObject));
        Logger.toLog("Y "+year);
        notifyDataSetChanged();
    }

    public void setClass(CarClass carClass) {
        this.carClassObject = carClass;
        classDatatextView.setText(carClass.getName());
        Logger.toLog(carClass.getName());
        notifyDataSetChanged();
    }

    class SwitchViewHolder extends RecyclerView.ViewHolder {
        Button mrButton, msButton;
//        TextView switchTitletextView;

        public SwitchViewHolder(@NonNull View itemView) {
            super(itemView);
            switchTitletextView = itemView.findViewById(R.id.switchTextView);
            switchTitletextView.setTextColor(ServiceApplication.getContext().getColor(R.color.colorWhite));
            mrButton = itemView.findViewById(R.id.maleButton);
            msButton = itemView.findViewById(R.id.femaleButton);
        }
    }

    class NameViewHolder extends RecyclerView.ViewHolder {
//        TextView nameTitleTextView;
//        EditText nameEditText;
        public NameViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTitleTextView = itemView.findViewById(R.id.editTextTitleTextView);
            nameTitleTextView.setTextColor(ServiceApplication.getContext().getColor(R.color.colorWhite));
            nameEditText = itemView.findViewById(R.id.dataEditText);
            nameEditText.setTextColor(ServiceApplication.getContext().getColor(R.color.colorWhite));
            nameEditText.setHintTextColor(ServiceApplication.getContext().getColor(R.color.colorGray));
        }

    }

    class SurmaneViewHolder extends RecyclerView.ViewHolder {
//        EditText surnameEditText;
//        TextView surnameTitleTextView;

        public SurmaneViewHolder(@NonNull View itemView) {
            super(itemView);
            surnameTitleTextView = itemView.findViewById(R.id.editTextTitleTextView);
            surnameTitleTextView.setTextColor(ServiceApplication.getContext().getColor(R.color.colorWhite));
            surnameEditText = itemView.findViewById(R.id.dataEditText);
            surnameEditText.setTextColor(ServiceApplication.getContext().getColor(R.color.colorWhite));
            surnameEditText.setHintTextColor(ServiceApplication.getContext().getColor(R.color.colorGray));
        }
    }

    class FnameViewHolder extends RecyclerView.ViewHolder {
//        EditText fnameEditText;
//        TextView fnameTitleTextView;

        public FnameViewHolder(@NonNull View itemView) {
            super(itemView);
            fnameTitleTextView = itemView.findViewById(R.id.editTextTitleTextView);
            fnameTitleTextView.setTextColor(ServiceApplication.getContext().getColor(R.color.colorWhite));
            fnameEditText = itemView.findViewById(R.id.dataEditText);
            fnameEditText.setTextColor(ServiceApplication.getContext().getColor(R.color.colorWhite));
            fnameEditText.setHintTextColor(ServiceApplication.getContext().getColor(R.color.colorGray));
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
