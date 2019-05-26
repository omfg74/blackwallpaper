package com.example.blackwallpaper.utils;

import com.example.blackwallpaper.R;
import com.example.blackwallpaper.ServiceApplication;
import com.example.blackwallpaper.model.UserInfo;

public class DataValidator {
    public boolean check(UserInfo userInfo) {
        if (userInfo.getLastName().equalsIgnoreCase(ServiceApplication.getContext().getString(R.string.text_field_enter_your_surname))) {
            return false;
        }
        if (userInfo.getFirstName().equalsIgnoreCase(ServiceApplication.getContext().getString(R.string.text_field_enter_your_name))) {
            return false;
        }
        if (userInfo.getMiddleName().equalsIgnoreCase(ServiceApplication.getContext().getString(R.string.text_field_enter_your_fname))) {
            return false;
        }
        if (userInfo.getPhone().equalsIgnoreCase("+7")) {
            return false;
        }
        if (userInfo.getEmail().equalsIgnoreCase(ServiceApplication.getContext().getString(R.string.text_field_enter_your_email))) {
            return false;
        }
        if (userInfo.getVin().equalsIgnoreCase(ServiceApplication.getContext().getString(R.string.text_field_enter_your_vin))) {
            return false;
        }
        if (userInfo.getYear().equalsIgnoreCase(ServiceApplication.getContext().getString(R.string.text_field_enter_year))) {
            return false;
        }
        if (userInfo.getClassId() == 0) {
            return false;
        }
        if (userInfo.getShowRoomId() == 0) {
            return false;
        }
        if (userInfo.getCity().equalsIgnoreCase(ServiceApplication.getContext().getString(R.string.choose_your_city_title))) {
            return false;
        }

        return true;
    }
}
