package com.example.infiny.ezrent.data.preference;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.infiny.ezrent.data.DataMangerContract;
import com.example.infiny.ezrent.di.ApplicationContext;
import com.example.infiny.ezrent.di.PreferenceInfo;

import javax.inject.Singleton;

/**
 * Created by infiny on 17/4/17.
 */

@Singleton
public class SharedPreferenceHelper implements SharedPreferenceContract{
    private static final String PREF_KEY_USER_LOGGED_IN_MODE = "PREF_KEY_USER_LOGGED_IN_MODE";
    private static final String PREF_KEY_CURRENT_USER_ID = "PREF_KEY_CURRENT_USER_ID";
    private static final String PREF_KEY_CURRENT_USER_NAME = "PREF_KEY_CURRENT_USER_NAME";
    private static final String PREF_KEY_CURRENT_USER_EMAIL = "PREF_KEY_CURRENT_USER_EMAIL";
    private static final String PREF_KEY_CURRENT_USER_PROFILE_PIC_URL
            = "PREF_KEY_CURRENT_USER_PROFILE_PIC_URL";
    private static final String PREF_KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN";

    private final SharedPreferences mPrefs;


    public SharedPreferenceHelper(@ApplicationContext Context context,
                                  @PreferenceInfo String prefFileName) {
        mPrefs = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
    }


    @Override
    public int getCurrentUserLoggedInMode() {
        return 0;
    }

    @Override
    public void setCurrentUserLoggedInMode(DataMangerContract.LoggedInMode mode) {

    }

    @Override
    public Long getCurrentUserId() {
        return null;
    }

    @Override
    public void setCurrentUserId(Long userId) {

    }

    @Override
    public String getCurrentUserName() {
        return null;
    }

    @Override
    public void setCurrentUserName(String userName) {

    }

    @Override
    public String getCurrentUserEmail() {
        return null;
    }

    @Override
    public void setCurrentUserEmail(String email) {

    }

    @Override
    public String getCurrentUserProfilePicUrl() {
        return null;
    }

    @Override
    public void setCurrentUserProfilePicUrl(String profilePicUrl) {

    }

    @Override
    public String getAccessToken() {
        return null;
    }

    @Override
    public void setAccessToken(String accessToken) {

    }
}
