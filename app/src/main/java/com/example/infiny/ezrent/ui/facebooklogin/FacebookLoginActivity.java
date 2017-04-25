package com.example.infiny.ezrent.ui.facebooklogin;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.infiny.ezrent.R;
import com.example.infiny.ezrent.ui.base.BaseActivity;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.util.Arrays;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FacebookLoginActivity extends BaseActivity implements FacebookLoginMvpView  {

    @BindView(R.id.ivbtnCancel)
    ImageButton ivbtnCancel;
    @BindView(R.id.btnFBLoginReplica)
    Button btnFBLoginReplica;
    @BindView(R.id.btnFBLogin)
    LoginButton btnFBLogin;
    @BindView(R.id.btnSignUp)
    Button btnSignUp;
    @BindView(R.id.btnLogin)
    Button btnLogin;
    private CallbackManager callbackManager;

    @Inject
    FacebookLoginMvpPresenter<FacebookLoginMvpView> mPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_facebook_login);
        ButterKnife.bind(this);
        callbackManager = CallbackManager.Factory.create();

        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(FacebookLoginActivity.this);

        btnFBLogin.setReadPermissions(Arrays.asList("public_profile", "email"));
        // Callback registration
        btnFBLogin.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
                Log.d("res",loginResult.toString());
            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
            }
        });

    }

    @OnClick({R.id.ivbtnCancel, R.id.btnFBLoginReplica, R.id.btnSignUp, R.id.btnLogin})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ivbtnCancel:
                break;
            case R.id.btnFBLoginReplica:
                mPresenter.onFacebookLoginClick();
                break;
            case R.id.btnSignUp:
                mPresenter.onSignUpClick();
                break;
            case R.id.btnLogin:
                mPresenter.onLoginClick();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }
}
