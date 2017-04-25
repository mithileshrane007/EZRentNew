package com.example.infiny.ezrent.ui.facebooklogin;

import com.example.infiny.ezrent.ui.base.MvpPresenter;

/**
 * Created by infiny on 20/4/17.
 */

public interface FacebookLoginMvpPresenter<V extends FacebookLoginMvpView> extends MvpPresenter<V> {

    void onFacebookLoginClick();

    void onLoginClick();

    void onSignUpClick();
}
