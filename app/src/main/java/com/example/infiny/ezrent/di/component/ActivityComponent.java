package com.example.infiny.ezrent.di.component;

import com.example.infiny.ezrent.di.PerActivity;
import com.example.infiny.ezrent.di.module.ActivityModule;
import com.example.infiny.ezrent.ui.login.LoginActivity;
import com.example.infiny.ezrent.ui.splash.SplashActivity;

import dagger.Component;

/**
 * Created by infiny on 18/4/17.
 */


@PerActivity
@Component(dependencies=ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(LoginActivity activity);
    void inject(SplashActivity splashActivity);

}
