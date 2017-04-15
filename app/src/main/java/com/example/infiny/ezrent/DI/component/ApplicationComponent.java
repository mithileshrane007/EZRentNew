
package com.example.infiny.ezrent.DI.component;


import android.app.Application;
import android.content.Context;

import com.example.infiny.ezrent.DI.ApplicationContext;
import com.example.infiny.ezrent.DI.module.ApplicationModule;
import com.example.infiny.ezrent.EZRentApp;
import com.example.infiny.ezrent.data.DataManager;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(EZRentApp app);


    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();
}