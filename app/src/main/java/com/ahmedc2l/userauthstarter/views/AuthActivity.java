package com.ahmedc2l.userauthstarter.views;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.ahmedc2l.userauthstarter.R;
import com.ahmedc2l.userauthstarter.models.AppUser;
import com.ahmedc2l.userauthstarter.utils.MyStringRegexp;
import com.facebook.CallbackManager;
import com.twitter.sdk.android.core.DefaultLogger;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterConfig;
import com.twitter.sdk.android.core.identity.TwitterAuthClient;

public class AuthActivity extends AppCompatActivity {

    public static final CallbackManager callbackManager = CallbackManager.Factory.create();
    public static TwitterAuthClient twitterAuthClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Here we are setting the theme back to the app theme instead of the SplashScreenTheme
        setTheme(R.style.AppTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        // Twitter initialization
        TwitterConfig config = new TwitterConfig.Builder(this.getApplicationContext())
                .logger(new DefaultLogger(Log.DEBUG))
                .twitterAuthConfig(new TwitterAuthConfig(getString(R.string.twitter_key), getString(R.string.twitter_secret)))
                .debug(true)
                .build();
        Twitter.initialize(config);
        twitterAuthClient = new TwitterAuthClient();

        /*if (MyStringRegexp.isTextValid(AppUser.getToken())) {
            // User is already logged in
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        else if(AppUser.isFirstOpen()) // User first time open the app
            AppUser.setFirstOpen(false);
        else // User not logged in and not first time open the app
            Navigation.findNavController(this, R.id.authHostFragment).navigate(R.id.action_introFragment_to_loginFragment);*/
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
        twitterAuthClient.onActivityResult(requestCode, resultCode, data);
    }
}
