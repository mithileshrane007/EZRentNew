package com.example.infiny.ezrent.di.module;

import android.app.Activity;
import android.content.Context;

import com.example.infiny.ezrent.di.ActivityContext;
import com.example.infiny.ezrent.di.PerActivity;
import com.example.infiny.ezrent.ui.login.LoginMvpPresenter;
import com.example.infiny.ezrent.ui.login.LoginMvpView;
import com.example.infiny.ezrent.ui.login.LoginPresenter;
import com.example.infiny.ezrent.ui.splash.SplashMvpPresenter;
import com.example.infiny.ezrent.ui.splash.SplashMvpView;
import com.example.infiny.ezrent.ui.splash.SplashPresenter;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by infiny on 18/4/17.
 */

@Module
public class ActivityModule  {
    private Activity mActivity;
    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    Activity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    @PerActivity
    LoginMvpPresenter<LoginMvpView> provideLoginPresenter(LoginPresenter<LoginMvpView>
                                                                  presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    SplashMvpPresenter<SplashMvpView> provideSplashPresenter(SplashPresenter<SplashMvpView>
                                                                  presenter) {
        return presenter;
    }
}
