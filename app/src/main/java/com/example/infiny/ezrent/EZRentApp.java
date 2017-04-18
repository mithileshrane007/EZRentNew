package com.example.infiny.ezrent;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.example.infiny.ezrent.data.DataManager;
import com.example.infiny.ezrent.di.component.ApplicationComponent;
import com.example.infiny.ezrent.di.component.DaggerApplicationComponent;
import com.example.infiny.ezrent.di.module.ApplicationModule;

import javax.inject.Inject;


public class EZRentApp extends MultiDexApplication {

    @Inject
    DataManager mDataManager;

    private ApplicationComponent mApplicationComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationComponent= DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();
        mApplicationComponent.inject(this);
    }


    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }

}
