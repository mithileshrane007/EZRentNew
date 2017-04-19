package com.example.infiny.ezrent.ui.splash;

import android.os.Bundle;

import com.example.infiny.ezrent.R;
import com.example.infiny.ezrent.ui.base.BaseActivity;
import com.example.infiny.ezrent.ui.base.LocationPresenter;
import com.yayandroid.locationmanager.configuration.Configurations;
import com.yayandroid.locationmanager.configuration.LocationConfiguration;

public class SplashActivity extends BaseActivity implements SplashMvpView,LocationPresenter.LocationView {



    @Override
    public LocationConfiguration getLocationConfiguration() {
        return Configurations.defaultConfiguration("Gimme the permission!", "Would you mind to turn GPS on?");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


    }


    @Override
    protected void onResume() {
        super.onResume();
    }


    @Override
    public String getLocationDetails() {
        return null;
    }

    @Override
    public void setLocationDetails(String text) {

    }

    @Override
    public void updateProgress(String text) {

    }

    @Override
    public void dismissProgress() {

    }
}
