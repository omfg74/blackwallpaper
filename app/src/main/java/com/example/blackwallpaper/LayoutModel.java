package com.example.blackwallpaper;

public class LayoutModel {
    private String title;
    private int type;

    public static final int SWITCH_TYPE = 1;
    public static final int NAME_TYPE = 2;
    public static final int FNAME_TYPE = 3;
    public static final int SURNAME_TYPE = 4;
    public static final int PHONE_TYPE = 5;
    public static final int EMAIL_TYPE  = 6;
    public static final int VIN_TYPE  = 7;
    public static final int CITY_TYPE  = 8;
    public static final int DEALER_TYPE  = 9;
    public static final int YEAR_TYPE  = 10;
    public static final int CLASS_TYPE  = 11;



    public LayoutModel(String title, int type) {
        this.title = title;
        this.type = type;
    }

    public String getTitle() {
        return title;

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
