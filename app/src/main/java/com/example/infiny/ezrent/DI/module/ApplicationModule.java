/*
 * Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://mindorks.com/license/apache-v2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package com.example.infiny.ezrent.DI.module;

import android.app.Application;
import android.content.Context;

import com.example.infiny.ezrent.DI.ApiInfo;
import com.example.infiny.ezrent.DI.ApplicationContext;
import com.example.infiny.ezrent.DI.DatabaseInfo;
import com.example.infiny.ezrent.DI.PreferenceInfo;
import com.example.infiny.ezrent.data.AppDataManager;
import com.example.infiny.ezrent.data.DataManager;
import com.example.infiny.ezrent.data.db.AppDbHelper;
import com.example.infiny.ezrent.data.db.DbHelper;
import com.example.infiny.ezrent.data.network.ApiHeader;
import com.example.infiny.ezrent.data.network.ApiHelper;
import com.example.infiny.ezrent.data.network.AppApiHelper;
import com.example.infiny.ezrent.data.prefs.AppPreferencesHelper;
import com.example.infiny.ezrent.data.prefs.PreferencesHelper;
import com.example.infiny.ezrent.utils.AppConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


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
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

//    @Provides
//    @ApiInfo
//    String provideApiKey() {
//        return BuildConfig.API_KEY;
//    }

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
    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @Singleton
    ApiHeader.ProtectedApiHeader provideProtectedApiHeader(@ApiInfo String apiKey,
                                                           PreferencesHelper preferencesHelper) {
        return new ApiHeader.ProtectedApiHeader(
                apiKey,
                preferencesHelper.getCurrentUserId(),
                preferencesHelper.getAccessToken());
    }


}
