package com.example.infiny.ezrent.di.component;

import android.app.Application;
import android.content.Context;

import com.example.infiny.ezrent.EZRentApp;
import com.example.infiny.ezrent.data.DataManager;
import com.example.infiny.ezrent.di.ApplicationContext;
import com.example.infiny.ezrent.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by infiny on 17/4/17.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(EZRentApp ezRentApp);

    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();

}
