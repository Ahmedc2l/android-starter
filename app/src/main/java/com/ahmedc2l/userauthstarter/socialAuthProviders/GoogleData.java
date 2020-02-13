package com.ahmedc2l.userauthstarter.socialAuthProviders;

import android.app.Activity;
import android.content.Intent;

import androidx.fragment.app.Fragment;

import com.ahmedc2l.userauthstarter.utils.Constants;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;


/**
 * <h1>GoogleData</h1>
 * <p>Make sure to add implementation 'com.google.android.gms:play-services-auth:17.0.0'</p>
 *
 * @author Ahmed Fathy
 * @version 1.0
 * @since 20-Jul-2019
 * */
public class GoogleData implements IAuthProviderStrategy {
    private Activity activity;
    private Fragment fragment;

    public GoogleData(Activity activity, Fragment fragment) {
        this.activity = activity;
        this.fragment = fragment;
    }

    @Override
    public void getUserData(final AuthProviderCallback callback) {
        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .requestId()
                .requestProfile()
                .build();

        GoogleSignInClient signInClient = GoogleSignIn.getClient(activity, googleSignInOptions);

        Intent signInIntent = signInClient.getSignInIntent();
        fragment.startActivityForResult(signInIntent, Constants.GOOGLE_SIGN_IN_REQUEST_CODE);
    }

    // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        /*if (requestCode == RC_SIGN_IN) {
        // The Task returned from this call is always completed, no need to attach a listener.
        Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);*/
}