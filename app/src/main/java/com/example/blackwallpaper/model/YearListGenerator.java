package com.example.blackwallpaper.model;

import java.util.ArrayList;
import java.util.List;

public class YearListGenerator {
    //Это сильно не идеальный код с точки зрения течения времени
    List<Integer> yearList;

    private void generateYearList() {
        yearList = new ArrayList<>();
        int year = 2010;
        for (int i = 0; i < 9; i++) {
            year++;
            yearList.add(year);

        }
    }

    public List<Integer> getYearList() {
        generateYearList();
        return yearList;
    }
}
