package com.example.infiny.ezrent.di.component;

import android.app.Application;
import android.content.Context;

import com.example.infiny.ezrent.EZRentApp;
import com.example.infiny.ezrent.di.ApplicationContext;
import com.example.infiny.ezrent.di.module.ApplicationModule;

import dagger.Component;

/**
 * Created by infiny on 17/4/17.
 */

@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void injectApplication(EZRentApp ezRentApp);
    Application application();

    @ApplicationContext
    Context context();
}
