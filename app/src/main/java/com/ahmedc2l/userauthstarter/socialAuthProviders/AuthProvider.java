package com.ahmedc2l.userauthstarter.socialAuthProviders;

/**
 * <h1>AuthProvider</h1>
 * <h3>This is a Strategy Class calls {@link IAuthProviderStrategy} to get user data.</h3>
 *
 * @author Ahmed Fathy
 * @version 1.0
 * @since 20-Jul-2019
 * */
public class AuthProvider {
    private IAuthProviderStrategy iAuthProviderStrategy;

    public AuthProvider(IAuthProviderStrategy iAuthProviderStrategy) {
        this.iAuthProviderStrategy = iAuthProviderStrategy;
    }

    /**
     * <h3>getUserData</h3>
     * <p>This function calls iSocialMediaStrategy.getUserData() that's implemented in social media classes.</p>
     *
     * @param callback {@link AuthProviderCallback}
     * */
    public void getUserData(AuthProviderCallback callback){
        if(iAuthProviderStrategy != null)
            iAuthProviderStrategy.getUserData(callback);
    }
}
