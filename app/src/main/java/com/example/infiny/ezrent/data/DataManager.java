package com.example.infiny.ezrent.data;

import com.example.infiny.ezrent.data.preference.PreferencesHelper;

/**
 * Created by infiny on 17/4/17.
 */

public interface DataManager extends PreferencesHelper {
    enum LoggedInMode {

        LOGGED_IN_MODE_LOGGED_OUT(0),
        LOGGED_IN_MODE_FB(1),
        LOGGED_IN_MODE_SERVER(2);

        private final int mType;

        LoggedInMode(int type) {
            mType = type;
        }

        public int getType() {
            return mType;
        }
    }
}
