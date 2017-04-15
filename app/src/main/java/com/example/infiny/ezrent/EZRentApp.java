package com.example.infiny.ezrent;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.example.infiny.ezrent.DI.component.ApplicationComponent;
import com.example.infiny.ezrent.DI.module.ApplicationModule;

/**
 * Created by infiny on 15/4/17.
 */

public class EZRentApp extends MultiDexApplication {
    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

        mApplicationComponent.inject(this);

    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }
}
