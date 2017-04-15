
package com.example.infiny.ezrent.data.network;

import com.example.infiny.ezrent.data.network.model.LoginRequest;
import com.example.infiny.ezrent.data.network.model.LoginResponse;
import com.example.infiny.ezrent.data.network.model.LogoutResponse;

import io.reactivex.Observable;

public interface ApiHelper {

    ApiHeader getApiHeader();


    Observable<LoginResponse> doFacebookLoginApiCall(LoginRequest.FacebookLoginRequest request);

    Observable<LoginResponse> doServerLoginApiCall(LoginRequest.ServerLoginRequest request);

    Observable<LogoutResponse> doLogoutApiCall();
}
