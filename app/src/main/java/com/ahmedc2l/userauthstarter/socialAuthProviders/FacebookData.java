package com.ahmedc2l.userauthstarter.socialAuthProviders;

import android.app.Activity;
import android.os.Bundle;

import com.ahmedc2l.userauthstarter.utils.GenericData;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;

import org.json.JSONObject;

import java.util.Arrays;

/**
 * <h1>FacebookData</h1>
 *
 * @author Ahmed Fathy
 * @version 1.0
 * @since 20-Jul-2019
 * */
public class FacebookData implements IAuthProviderStrategy{
    private Activity activity;
    private CallbackManager callbackManager;

    public FacebookData(Activity activity, CallbackManager callbackManager) {
        this.activity = activity;
        this.callbackManager = callbackManager;
    }

    @Override
    public void getUserData(final AuthProviderCallback callback) {
        try {
            LoginManager loginManager = LoginManager.getInstance();

            loginManager.logOut();

            loginManager.logInWithReadPermissions(activity, Arrays.asList("email", "public_profile"));
            loginManager.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
                @Override
                public void onSuccess(LoginResult loginResult) {
                    handleSuccess(loginResult.getAccessToken(), callback);
                }

                @Override
                public void onCancel() {
                    handleFailure("Facebook login cancelled :(", callback);
                }

                @Override
                public void onError(FacebookException error) {
                    handleFailure(error.getMessage(), callback);
                }
            });
        }catch (Exception e){
            handleFailure(e.getMessage(), callback);
        }
    }

    /**
     * <h2>handleSuccess</h2>
     * <p>Handles facebook success response.</p>
     *
     * @param accessToken the user's facebook access token.
     * @param callback {@link AuthProviderCallback}
     * */
    private void handleSuccess(AccessToken accessToken, AuthProviderCallback callback) {
        GraphRequest request = GraphRequest.newMeRequest(
                accessToken,
                (object, response) -> {
                    GenericData<JSONObject> myGeneric = new GenericData<>();
                    myGeneric.setValue(object);
                    callback.onCompleted(myGeneric, true);
                });

        // Add the data you want from the user's facebook account
        // Note that to get gender you'll need to request that permission from your developer account app setting
        // Check out https://developers.facebook.com/docs/apps/review/login-permissions
        // and https://developers.facebook.com/docs/apps/review/#my-permissions-and-features for more detailed info
        // to get profile image "https://graph.facebook.com/" + id + "/picture?width=500&height=500"
        // the facebook data we can get using parameters.putString
        /*{
              "id": "12345678",
              "birthday": "1/1/1950",
              "first_name": "Chris",
              "gender": "male",
              "last_name": "Colm",
              "link": "http://www.facebook.com/12345678",
              "location": {
                "id": "110843418940484",
                "name": "Seattle, Washington"
              },
              "locale": "en_US",
              "name": "Chris Colm",
              "timezone": -8,
              "updated_time": "2010-01-01T16:40:43+0000",
              "verified": true
          }
        */
        Bundle parameters = new Bundle();
        parameters.putString("fields", "id,first_name,last_name,email,link");

        request.setParameters(parameters);
        request.executeAsync();
    }

    /**
     * <h2>handleFailure</h2>
     * <p>handle facebook call failures and exceptions</p>
     *
     * @param message failure message
     * @param callback {@link AuthProviderCallback}
     * */
    private void handleFailure(String message, AuthProviderCallback callback) {
        GenericData<String> generic = new GenericData<>();
        generic.setValue(message);
        callback.onCompleted(generic, false);
    }
}