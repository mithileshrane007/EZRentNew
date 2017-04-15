

package com.example.infiny.ezrent.DI.component;


import com.example.infiny.ezrent.DI.PerActivity;
import com.example.infiny.ezrent.DI.module.ActivityModule;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

//    void inject(MainActivity activity);
//
//    void inject(LoginActivity activity);
//
//    void inject(SplashActivity activity);
//
//    void inject(AboutFragment fragment);
}
