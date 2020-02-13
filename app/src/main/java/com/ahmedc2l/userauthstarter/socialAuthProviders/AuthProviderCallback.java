package com.ahmedc2l.userauthstarter.socialAuthProviders;

/**
 * <h1>AuthProviderCallback</h1>
 * <p>A callback interface that returns a generic class contains user's data.</p>
 *
 * @author Ahmed Fathy
 * @since 22-Jul-2019
 * @version 1.0
 * */
public interface AuthProviderCallback {
    /**
     * <h1>onCompleted</h1>
     *
     * @param genericData the generic class contains user's data
     * @param isSuccess whether the network call completed successfully or not
     * */
    void onCompleted(GenericData genericData, boolean isSuccess);
}
