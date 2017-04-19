package com.example.infiny.ezrent.ui.splash;

import android.location.Location;
import android.os.Bundle;
import android.util.Log;

import com.example.infiny.ezrent.R;
import com.example.infiny.ezrent.ui.base.LocationBaseActivity;
import com.example.infiny.ezrent.ui.base.LocationPresenter;
import com.yayandroid.locationmanager.configuration.Configurations;
import com.yayandroid.locationmanager.configuration.LocationConfiguration;
import com.yayandroid.locationmanager.constants.FailType;
import com.yayandroid.locationmanager.constants.ProcessType;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class SplashActivity extends LocationBaseActivity implements SplashMvpView,LocationPresenter.LocationView {
    private static final String TAG = "SplashActivity";

    @Inject
    SplashMvpPresenter<SplashMvpView> mPresenter;
    private LocationPresenter locationPresenter;


    @Override
    public LocationConfiguration getLocationConfiguration() {
        return Configurations.defaultConfiguration("Gimme the permission!", "Would you mind to turn GPS on?");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(SplashActivity.this);
        locationPresenter = new LocationPresenter(this);
        getLocation();

    }


    @Override
    protected void onResume() {
        super.onResume();

        if (getLocationManager().isWaitingForLocation()
                && !getLocationManager().isAnyDialogShowing()) {
            showLoading();
        }
    }


    @Override
    protected void onPause() {
        super.onPause();

        dismissProgress();
    }

    @Override
    public void onLocationChanged(Location location) {
        super.onLocationChanged(location);
        locationPresenter.onLocationChanged(location);

    }
    @Override
    public void onLocationFailed(@FailType int failType) {
        locationPresenter.onLocationFailed(failType);
    }

    @Override
    public void onProcessTypeChanged(@ProcessType int processType) {
        locationPresenter.onProcessTypeChanged(processType);
    }

    @Override
    public String getLocationDetails() {
        return mPresenter.getLocationDetails();
    }

    @Override
    public void setLocationDetails(String location) {
        Log.d("locv",location+TAG);
        mPresenter.setLocationDetails(location);

    }

    @Override
    public void updateProgress(String location) {
        Log.d("locv",location);

    }

    @Override
    public void dismissProgress() {
        hideLoading();
    }


}
