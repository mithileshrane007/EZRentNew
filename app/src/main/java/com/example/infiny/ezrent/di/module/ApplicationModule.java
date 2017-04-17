package com.example.infiny.ezrent.di.module;

import android.app.Application;
import android.content.Context;

import com.example.infiny.ezrent.di.ApplicationContext;

import dagger.Module;
import dagger.Provides;

/**
 * Created by infiny on 17/4/17.
 */
@Module
public class ApplicationModule {
    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }


    @Provides
    Application provideApplication() {
        return mApplication;
    }

}
