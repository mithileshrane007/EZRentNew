package com.example.infiny.ezrent.ui.splash;

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
}
