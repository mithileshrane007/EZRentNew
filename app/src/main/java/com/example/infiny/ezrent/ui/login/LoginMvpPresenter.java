package com.example.infiny.ezrent.ui.login;

import com.example.infiny.ezrent.di.PerActivity;
import com.example.infiny.ezrent.ui.base.MvpPresenter;

/**
 * Created by infiny on 18/4/17.
 */
@PerActivity
public interface LoginMvpPresenter<V extends LoginMvpView> extends MvpPresenter<V> {
}
