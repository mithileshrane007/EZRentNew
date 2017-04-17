package com.example.infiny.ezrent;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.example.infiny.ezrent.di.component.ApplicationComponent;
import com.example.infiny.ezrent.di.component.DaggerApplicationComponent;
import com.example.infiny.ezrent.di.module.ApplicationModule;


public class EZRentApp extends MultiDexApplication {


    private ApplicationComponent applicationComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent= DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
        applicationComponent.injectApplication(this);


    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

}
