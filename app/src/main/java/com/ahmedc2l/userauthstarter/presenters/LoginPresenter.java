package com.ahmedc2l.userauthstarter.presenters;

import android.util.Log;

import androidx.annotation.NonNull;

import com.ahmedc2l.userauthstarter.contracts.BaseContract;
import com.ahmedc2l.userauthstarter.contracts.LoginContract;
import com.ahmedc2l.userauthstarter.network.ApiEndPointsUtils;
import com.ahmedc2l.userauthstarter.utils.GenericData;
import com.ahmedc2l.userauthstarter.utils.Constants;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.twitter.sdk.android.core.models.User;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        baseView.showLoadingDialog();

        // TODO add different request headers if needed
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json");

        ApiEndPointsUtils.getAPIService().LOGIN(headers, body)
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
                        baseView.hideLoadingDialog();
                        // TODO handel api response
                    }

                    @Override
                    public void onFailure(@NonNull Call<ResponseBody> call, @NonNull Throwable t) {
                        baseView.hideLoadingDialog();
                        baseView.showErrorMessage(t.getMessage());
                    }
                });
    }

    @Override
    public void loginWithSocial(GenericData genericData, Constants.SocialProviders socialAuthProvider) {
        baseView.showLoadingDialog();

        Map<String, Object> body = new HashMap<>();

        // TODO fill the body data based on the social auth provider
        switch (socialAuthProvider) {
            case FACEBOOK:
                JSONObject jsonObject = (JSONObject) genericData.getValue();
                Log.i(TAG, "loginWithSocial: FACEBOOK: " + jsonObject.toString());
                break;
            case TWITTER:
                User user = (User) genericData.getValue();
                Log.i(TAG, "loginWithSocial: TWITTER: " + user.toString());
                break;
            case GOOGLE:
                GoogleSignInAccount account = (GoogleSignInAccount) genericData.getValue();
                Log.i(TAG, "loginWithSocial: GOOGLE: " + account.toString());
                break;
        }

        // TODO add different request headers if needed
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json");

        ApiEndPointsUtils.getAPIService().LOGIN_SOCIAL(headers, body)
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
                        baseView.hideLoadingDialog();
                        // TODO handel api response
                    }

                    @Override
                    public void onFailure(@NonNull Call<ResponseBody> call, @NonNull Throwable t) {
                        baseView.hideLoadingDialog();
                        baseView.showErrorMessage(t.getMessage());
                    }
                });
    }
}
