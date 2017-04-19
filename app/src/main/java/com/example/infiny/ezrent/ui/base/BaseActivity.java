package com.example.infiny.ezrent.ui.base;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.infiny.ezrent.EZRentApp;
import com.example.infiny.ezrent.R;
import com.example.infiny.ezrent.di.component.ActivityComponent;
import com.example.infiny.ezrent.di.component.DaggerActivityComponent;
import com.example.infiny.ezrent.di.module.ActivityModule;
import com.example.infiny.ezrent.utils.CommonUtils;
import com.example.infiny.ezrent.utils.KeyboardUtils;
import com.example.infiny.ezrent.utils.NetworkUtils;
import com.yayandroid.locationmanager.LocationManager;
import com.yayandroid.locationmanager.configuration.LocationConfiguration;
import com.yayandroid.locationmanager.listener.LocationListener;

import butterknife.Unbinder;

/**
 * Created by infiny on 18/4/17.
 */

public abstract class BaseActivity extends AppCompatActivity
        implements MvpView,BaseFragment.Callback, LocationListener {

    private ProgressDialog mProgressDialog;

    private ActivityComponent mActivityComponent;

    private Unbinder mUnBinder;

    private LocationManager locationManager;

    public abstract LocationConfiguration getLocationConfiguration();


    @CallSuper
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(((EZRentApp) getApplication()).getComponent())
                .build();

        locationManager = new LocationManager.Builder(getApplication())
                .configuration(getLocationConfiguration())
                .activity(this)
                .notify(this)
                .build();
    }


    @CallSuper
    @Override
    protected void onResume() {
        super.onResume();
        locationManager.onResume();
    }

    @CallSuper
    @Override
    protected void onPause() {
        locationManager.onPause();
        super.onPause();
    }

    @CallSuper
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        locationManager.onActivityResult(requestCode, resultCode, data);
    }

    @CallSuper
    @Override
    protected void onDestroy() {
        if (mUnBinder != null) {
            mUnBinder.unbind();
        }
        locationManager.onDestroy();
        super.onDestroy();
    }


    @CallSuper
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        locationManager.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void showLoading() {
        hideLoading();
        mProgressDialog = CommonUtils.showLoadingDialog(this);
    }

    @Override
    public void hideLoading() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.cancel();
        }
    }


    @Override
    public void onError(@StringRes int resId) {
        onError(getString(resId));
    }

    @Override
    public void onError(String message) {
        if (message != null) {
            showSnackBar(message);
        } else {
            showSnackBar(getString(R.string.some_error));
        }
    }

    @Override
    public boolean isNetworkConnected() {
        return NetworkUtils.isNetworkConnected(getApplicationContext());
    }

    @Override
    public void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            KeyboardUtils.hideSoftInput(this);
        }
    }

    @Override
    public void onFragmentAttached() {

    }

    @Override
    public void onFragmentDetached(String tag) {

    }

    public void setUnBinder(Unbinder unBinder) {
        mUnBinder = unBinder;
    }

    @TargetApi(Build.VERSION_CODES.M)
    public void requestPermissionsSafely(String[] permissions, int requestCode) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, requestCode);
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    public boolean hasPermission(String permission) {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M ||
                checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED;
    }


    //-------------LocationManager


    @Override
    public void onProcessTypeChanged(int processType) {

    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onLocationFailed(int type) {

    }

    @Override
    public void onPermissionGranted(boolean alreadyHadPermission) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    protected void getLocation() {
        if (locationManager != null) {
            locationManager.get();
        } else {
            throw new IllegalStateException("locationManager is null. "
                    + "Make sure you call super.initialize before attempting to getLocation");
        }
    }


    protected LocationManager getLocationManager() {
        return locationManager;
    }


    //-------------LocationManager

    public ActivityComponent getActivityComponent() {
        return mActivityComponent;
    }


    private void showSnackBar(String message) {
        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content),
                message, Snackbar.LENGTH_SHORT);
        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView
                .findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(ContextCompat.getColor(this, R.color.white));
        snackbar.show();
    }

}
