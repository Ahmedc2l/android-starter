package com.ahmedc2l.userauthstarter.presenters;

import android.util.Log;

import com.ahmedc2l.userauthstarter.contracts.BaseContract;
import com.ahmedc2l.userauthstarter.contracts.LoginContract;
import com.ahmedc2l.userauthstarter.socialAuthProviders.GenericData;
import com.ahmedc2l.userauthstarter.utils.Constants;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.twitter.sdk.android.core.models.User;

import org.json.JSONObject;

import java.util.Map;

public class LoginPresenter implements LoginContract.Presenter {
    private static final String TAG = "LoginPresenter";

    private LoginContract.View view;
    private BaseContract.View baseView;

    public LoginPresenter(LoginContract.View view, BaseContract.View baseView) {
        this.view = view;
        this.baseView = baseView;
    }

    @Override
    public void loginRegular(Map<String, Object> body) {

    }

    @Override
    public void loginWithSocial(GenericData genericData, int socialAuthProvider) {
        switch (socialAuthProvider) {
            case Constants.FACEBOOK:
                JSONObject jsonObject = (JSONObject) genericData.getValue();
                Log.i(TAG, "loginWithSocial: FACEBOOK: " + jsonObject.toString());
                break;
            case Constants.TWITTER:
                User user = (User) genericData.getValue();
                Log.i(TAG, "loginWithSocial: TWITTER: " + user.toString());
                break;
            case Constants.GOOGLE:
                GoogleSignInAccount account = (GoogleSignInAccount) genericData.getValue();
                Log.i(TAG, "loginWithSocial: GOOGLE: " + account.toString());
                break;
        }
    }
}
