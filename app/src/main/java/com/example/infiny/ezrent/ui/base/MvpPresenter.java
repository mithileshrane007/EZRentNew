package com.example.infiny.ezrent.ui.base;

/**
 * Created by infiny on 18/4/17.
 */

public interface MvpPresenter<V extends MvpView> {

    void onAttach(V mvpView);

    void onDetach();


}
