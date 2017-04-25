package com.example.infiny.ezrent.ui.facebooklogin;

import com.example.infiny.ezrent.data.DataManager;
import com.example.infiny.ezrent.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;
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
        if (getMvpView().isNetworkConnected()) {

        }else {

        }

    }

    @Override
    public void onLoginClick() {
        getMvpView().showLoading();
        if (getMvpView().isNetworkConnected()) {
            login();
        }else {

        }



    }



    @Override
    public void onSignUpClick() {
        getMvpView().showLoading();
        if (getMvpView().isNetworkConnected()) {

        }else {

        }
    }


    private void login() {
        Observable<String> fetchFromGoogle = Observable.create(new ObservableOnSubscribe<String>(){
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> subscriber) throws Exception {

                try {
//                    String data = fetchData(Constants.getLoginSignUrl());
//                    subscriber.onNext(data); // Emit the contents of the URL
//                    subscriber.onComplete(); // Nothing more to emit
                }catch(Exception e){
                    subscriber.onError(e); // In case there are network errors
                }
            }


        });
    }

//    private String fetchData(String url) {
//
//        Retrofit retrofit=new Retrofit.Builder().baseUrl(url)
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .build();
//
//        retrofit.create()
//        return s;
//    }


}
