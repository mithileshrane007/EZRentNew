package com.example.infiny.ezrent.di.module;

import android.app.Application;
import android.content.Context;

import com.example.infiny.ezrent.data.AppDataManager;
import com.example.infiny.ezrent.data.DataManager;
import com.example.infiny.ezrent.data.preference.AppPreferencesHelper;
import com.example.infiny.ezrent.data.preference.PreferencesHelper;
import com.example.infiny.ezrent.di.ApplicationContext;
import com.example.infiny.ezrent.di.PreferenceInfo;
import com.example.infiny.ezrent.utils.AppConstants;

import javax.inject.Singleton;

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

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

}
