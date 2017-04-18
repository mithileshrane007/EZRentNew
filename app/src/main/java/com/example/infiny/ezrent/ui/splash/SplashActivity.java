package com.example.infiny.ezrent.ui.splash;

import android.os.Bundle;

import com.example.infiny.ezrent.R;
import com.example.infiny.ezrent.ui.base.BaseActivity;

public class SplashActivity extends BaseActivity implements SplashMvpView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


    }

    @Override
    protected void onResume() {
        super.onResume();
    }


}
