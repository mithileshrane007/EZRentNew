package com.example.infiny.ezrent.data.preference;

import com.example.infiny.ezrent.data.DataMangerContract;

/**
 * Created by infiny on 17/4/17.
 */

public interface SharedPreferenceContract {
    int getCurrentUserLoggedInMode();

    void setCurrentUserLoggedInMode(DataMangerContract.LoggedInMode mode);

    Long getCurrentUserId();

    void setCurrentUserId(Long userId);

    String getCurrentUserName();

    void setCurrentUserName(String userName);

    String getCurrentUserEmail();

    void setCurrentUserEmail(String email);

    String getCurrentUserProfilePicUrl();

    void setCurrentUserProfilePicUrl(String profilePicUrl);

    String getAccessToken();

    void setAccessToken(String accessToken);
}
