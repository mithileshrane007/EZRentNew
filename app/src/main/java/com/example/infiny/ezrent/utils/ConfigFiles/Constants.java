package com.example.infiny.ezrent.utils.ConfigFiles;

/**
 * Created by infiny on 24/4/17.
 */

public class Constants {
    public static final String BASE_SITE = "http://dev2.infiny.in/ezrent/Admin_api";

    private static final String LOGIN_SIGN_URL = BASE_SITE + "/normal_login/";

    public static String getLoginSignUrl() {
        return LOGIN_SIGN_URL;
    }
}
