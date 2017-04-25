package com.example.infiny.ezrent.ui.splash;

import com.example.infiny.ezrent.di.PerActivity;
import com.example.infiny.ezrent.ui.base.MvpPresenter;

/**
 * Created by infiny on 18/4/17.
 */
@PerActivity
public interface SplashMvpPresenter<V extends SplashMvpView> extends MvpPresenter<V> {
    void setLocationDetails(String text);

    String getLocationDetails();

    Boolean connectionSubscribe();



}
