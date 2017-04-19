package com.example.infiny.ezrent.ui.base;

import android.location.Location;
import android.text.TextUtils;

import com.yayandroid.locationmanager.constants.FailType;
import com.yayandroid.locationmanager.constants.ProcessType;

/**
 * Created by infiny on 19/4/17.
 */

public class LocationPresenter {
    private LocationView locationView;

    public LocationPresenter(LocationView view) {
        this.locationView = view;
    }

    public void destroy() {
        locationView = null;
    }

    public void onLocationChanged(Location location) {
        locationView.dismissProgress();
        setText(location);
    }

    public void onLocationFailed(@FailType int failType) {
        locationView.dismissProgress();

        switch (failType) {
            case FailType.TIMEOUT: {
                locationView.setLocationDetails("Couldn't get location, and timeout!");
                break;
            }
            case FailType.PERMISSION_DENIED: {
                locationView.setLocationDetails("Couldn't get location, because user didn't give permission!");
                break;
            }
            case FailType.NETWORK_NOT_AVAILABLE: {
                locationView.setLocationDetails("Couldn't get location, because network is not accessible!");
                break;
            }
            case FailType.GOOGLE_PLAY_SERVICES_NOT_AVAILABLE: {
                locationView.setLocationDetails("Couldn't get location, because Google Play Services not available!");
                break;
            }
            case FailType.GOOGLE_PLAY_SERVICES_CONNECTION_FAIL: {
                locationView.setLocationDetails("Couldn't get location, because Google Play Services connection failed!");
                break;
            }
            case FailType.GOOGLE_PLAY_SERVICES_SETTINGS_DIALOG: {
                locationView.setLocationDetails("Couldn't display settingsApi dialog!");
                break;
            }
            case FailType.GOOGLE_PLAY_SERVICES_SETTINGS_DENIED: {
                locationView.setLocationDetails("Couldn't get location, because user didn't activate providers via settingsApi!");
                break;
            }
            case FailType.VIEW_DETACHED: {
                locationView.setLocationDetails("Couldn't get location, because in the process view was detached!");
                break;
            }
            case FailType.VIEW_NOT_REQUIRED_TYPE: {
                locationView.setLocationDetails("Couldn't get location, "
                        + "because view wasn't sufficient enough to fulfill given configuration!");
                break;
            }
            case FailType.UNKNOWN: {
                locationView.setLocationDetails("Ops! Something went wrong!");
                break;
            }
        }
    }

    public void onProcessTypeChanged(@ProcessType int newProcess) {
        switch (newProcess) {
            case ProcessType.GETTING_LOCATION_FROM_GOOGLE_PLAY_SERVICES: {
                locationView.updateProgress("Getting Location from Google Play Services...");
                break;
            }
            case ProcessType.GETTING_LOCATION_FROM_GPS_PROVIDER: {
                locationView.updateProgress("Getting Location from GPS...");
                break;
            }
            case ProcessType.GETTING_LOCATION_FROM_NETWORK_PROVIDER: {
                locationView.updateProgress("Getting Location from Network...");
                break;
            }
            case ProcessType.ASKING_PERMISSIONS:
            case ProcessType.GETTING_LOCATION_FROM_CUSTOM_PROVIDER:
                // Ignored
                break;
        }
    }

    private void setText(Location location) {
        String appendValue = location.getLatitude() + ", " + location.getLongitude() + "\n";
        String newValue;
        CharSequence current = locationView.getLocationDetails();

        if (!TextUtils.isEmpty(current)) {
            newValue = current + appendValue;
        } else {
            newValue = appendValue;
        }

        locationView.setLocationDetails(newValue);
    }

    public interface LocationView {

        String getLocationDetails();

        void setLocationDetails(String text);

        void updateProgress(String text);

        void dismissProgress();

    }

}
