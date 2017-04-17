package com.example.infiny.ezrent.data;

import com.example.infiny.ezrent.data.preference.SharedPreferenceContract;

/**
 * Created by infiny on 17/4/17.
 */

public interface DataMangerContract extends SharedPreferenceContract{
    enum LoggedInMode {

        LOGGED_IN_MODE_LOGGED_OUT(0),
        LOGGED_IN_MODE_GOOGLE(1),
        LOGGED_IN_MODE_FB(2),
        LOGGED_IN_MODE_SERVER(3);

        private final int mType;

        LoggedInMode(int type) {
            mType = type;
        }

        public int getType() {
            return mType;
        }
    }
}
