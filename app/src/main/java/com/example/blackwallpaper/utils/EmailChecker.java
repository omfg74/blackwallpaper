package com.example.blackwallpaper.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailChecker {
    public boolean check(String string) {
        Pattern pattern =
        Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern .matcher(string);
        return matcher.find();
    }
}
