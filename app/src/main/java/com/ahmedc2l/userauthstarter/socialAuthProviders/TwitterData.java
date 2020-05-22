package com.ahmedc2l.userauthstarter.socialAuthProviders;

import com.ahmedc2l.userauthstarter.utils.GenericData;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.models.User;

import retrofit2.Call;

/**
 * <h1>TwitterData</h1>
 *
 * @author Ahmed Fathy
 * @version 1.0
 * @since 20-Jul-2019
 * */
public class TwitterData implements IAuthProviderStrategy{
    private TwitterSession twitterSession;

    public TwitterData(TwitterSession twitterSession) {
        this.twitterSession = twitterSession;
    }

    @Override
    public void getUserData(final AuthProviderCallback callback) {
        if(twitterSession != null){
            TwitterApiClient twitterApiClient = TwitterCore.getInstance().getApiClient();
            Call<User> call = twitterApiClient.getAccountService().verifyCredentials(true, false, true);

            call.enqueue(new Callback<User>() {
                @Override
                public void success(Result<User> result) {
                    User user = result.data;

                    GenericData<User> generic = new GenericData<>();
                    generic.setValue(user);
                    callback.onCompleted(generic, true);
                }

                @Override
                public void failure(TwitterException exception) {
                    GenericData<String> generic = new GenericData<>();
                    generic.setValue(exception.getMessage());
                    callback.onCompleted(generic, false);
                }
            });
        }else {
            GenericData<String> generic = new GenericData<>();
            generic.setValue("TwitterSession is null :(");
            callback.onCompleted(generic, false);
        }
    }
}