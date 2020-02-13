package com.ahmedc2l.userauthstarter.socialAuthProviders;

/**
 * <h1>IAuthProviderStrategy</h1>
 * <p>
 * This is an interface with getUserData() declaration only.
 * following Strategy design pattern, this function is to differently implemented later.
 * </p>
 *
 * @author Ahmed Fathy
 * @version 1.0
 * @since 20-Mar-2019
 * */
public interface IAuthProviderStrategy {
    /**
     * <h3>getUserData</h3>
     * <p>A declaration of a function that gets user data, later to be implemented.</p>
     *
     * @param callback interface that returns a generic class contains user's data.
     * */
    void getUserData(AuthProviderCallback callback);
}
