package com.ahmedc2l.userauthstarter.views.fragments;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ahmedc2l.userauthstarter.R;
import com.ahmedc2l.userauthstarter.contracts.BaseContract;
import com.ahmedc2l.userauthstarter.contracts.LoginContract;
import com.ahmedc2l.userauthstarter.databinding.FragmentLoginBinding;
import com.ahmedc2l.userauthstarter.presenters.LoginPresenter;
import com.ahmedc2l.userauthstarter.socialAuthProviders.AuthProvider;
import com.ahmedc2l.userauthstarter.socialAuthProviders.FacebookData;
import com.ahmedc2l.userauthstarter.socialAuthProviders.GenericData;
import com.ahmedc2l.userauthstarter.socialAuthProviders.GoogleData;
import com.ahmedc2l.userauthstarter.socialAuthProviders.TwitterData;
import com.ahmedc2l.userauthstarter.utils.Constants;
import com.ahmedc2l.userauthstarter.utils.MyDialog;
import com.ahmedc2l.userauthstarter.views.AuthActivity;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.tasks.Task;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.models.User;

import org.json.JSONObject;

import static android.app.Activity.RESULT_OK;

public class LoginFragment extends Fragment implements View.OnClickListener, BaseContract.View, LoginContract.View {

    private Activity activity;
    private LoginPresenter loginPresenter;
    private MyDialog myDialog;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity = (Activity) context;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentLoginBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false);
        binding.textViewRegister.setOnClickListener(this);
        binding.buttonFacbook.setOnClickListener(this);
        binding.buttonGoogle.setOnClickListener(this);
        binding.buttonTwitter.setOnClickListener(this);
        binding.buttonLogin.setOnClickListener(this);
        binding.textViewForgotPassword.setOnClickListener(this);

        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                activity.finish();
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        myDialog = new MyDialog(activity);
        loginPresenter = new LoginPresenter(this, this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.textView_register:
                Navigation.findNavController(activity, R.id.authHostFragment).navigate(R.id.action_loginFragment_to_registerFragment);
                break;
            case R.id.button_facbook:
                AuthProvider facebook = new AuthProvider(new FacebookData(activity, AuthActivity.callbackManager));
                facebook.getUserData((genericData, isSuccess) -> {
                    if (isSuccess)
                        loginPresenter.loginWithSocial(genericData, Constants.FACEBOOK);
                    else
                        showErrorMessage(genericData.getValue().toString());
                });
                break;
            case R.id.button_google:
                AuthProvider google = new AuthProvider(new GoogleData(activity, this));
                google.getUserData(null); // Passing null because the google data is captured in onActivityResult
                break;
            case R.id.button_twitter:
                AuthActivity.twitterAuthClient.authorize(activity, new Callback<TwitterSession>() {
                    @Override
                    public void success(Result<TwitterSession> result) {
                        AuthProvider twitter = new AuthProvider(new TwitterData(result.data));
                        twitter.getUserData((genericData, isSuccess) -> {
                            if(isSuccess)
                                loginPresenter.loginWithSocial(genericData, Constants.TWITTER);
                            else
                                showErrorMessage(genericData.getValue().toString());
                        });
                    }

                    @Override
                    public void failure(TwitterException exception) {
                        showErrorMessage(exception.getMessage());
                    }
                });
                break;
            case R.id.button_login:
                break;
            case R.id.textView_forgotPassword:
                Navigation.findNavController(activity, R.id.authHostFragment).navigate(R.id.action_loginFragment_to_forgotPasswordFragment);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constants.GOOGLE_SIGN_IN_REQUEST_CODE ) {
            if(resultCode == RESULT_OK) {
                // The Task returned from this call is always completed, no need to attach a listener.
                Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
                GoogleSignInAccount account = task.getResult();

                if (account != null) {
                    GenericData<GoogleSignInAccount> genericData = new GenericData<>();
                    genericData.setValue(account);

                    loginPresenter.loginWithSocial(genericData, Constants.GOOGLE);
                }
                else
                    showErrorMessage("Google account is null :(");
            }else
                showErrorMessage("Google result is not OK :(");
        }
    }

    @Override
    public void showLoadingDialog() {
        myDialog.showLoadingDialog();
    }

    @Override
    public void hideLoadingDialog() {
        myDialog.hideDialog();
    }

    @Override
    public void showErrorMessage(String error) {
        myDialog.showErrorMessage(error);
    }

    @Override
    public void showSuccessMessage(String message) {
        myDialog.showSuccessMessage(message);
    }
}