package com.example.infiny.ezrent.ui.facebooklogin;

import com.example.infiny.ezrent.data.DataManager;
import com.example.infiny.ezrent.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by infiny on 20/4/17.
 */

public class FacebookLoginPresenter<V extends FacebookLoginMvpView> extends BasePresenter<V>
        implements FacebookLoginMvpPresenter<V> {

    @Inject
    public FacebookLoginPresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
    }

    @Override
    public void onFacebookLoginClick() {

        getMvpView().showLoading();

    }
}
