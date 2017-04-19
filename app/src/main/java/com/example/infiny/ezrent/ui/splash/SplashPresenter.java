package com.example.infiny.ezrent.ui.splash;

import android.util.Log;

import com.example.infiny.ezrent.data.DataManager;
import com.example.infiny.ezrent.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by infiny on 18/4/17.
 */

public class SplashPresenter<V extends SplashMvpView> extends BasePresenter<V>
        implements SplashMvpPresenter<V> {
    private static final String TAG = "SplashPresenter";



    @Inject
    public SplashPresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

    @Override
    public DataManager getDataManager() {
        return super.getDataManager();
    }

    @Override
    public void setLocationDetails(String location) {
        getDataManager().setLocation(location);
        Log.d("locv",location+TAG);
    }

    @Override
    public String getLocationDetails() {
        return getDataManager().getLocation();
    }
}
