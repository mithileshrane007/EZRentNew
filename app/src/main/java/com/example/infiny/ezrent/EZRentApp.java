package com.example.infiny.ezrent;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.example.infiny.ezrent.DI.component.ApplicationComponent;
import com.example.infiny.ezrent.DI.module.ApplicationModule;
import com.example.infiny.ezrent.data.DataManager;

import javax.inject.Inject;


public class EZRentApp extends MultiDexApplication {
    private ApplicationComponent mApplicationComponent;
    @Inject
    DataManager mDataManager;

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

    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }
}
