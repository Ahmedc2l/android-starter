package com.ahmedc2l.userauthstarter.contracts;

import com.ahmedc2l.userauthstarter.utils.GenericData;
import com.ahmedc2l.userauthstarter.utils.Constants;

import java.util.Map;

/**
 * <h2>LoginContract</h2>
 * <p>Interface that declares all the functions and view actions for the login fragment</p>
 *
 * @see com.ahmedc2l.userauthstarter.views.fragments.LoginFragment
 * */
public interface LoginContract {
    interface View{
        // TODO here you define all the view or UI actions you wanna perform in the login fragment
    }

    /**
     * @see com.ahmedc2l.userauthstarter.presenters.LoginPresenter
     * */
    interface Presenter{
        /**
         * <h3>loginRegular</h3>
         * <p>regular login with data like email and password for example</p>
         *
         * @param body is the key value pair Map<String, Object>
         * */
        void loginRegular(Map<String, Object> body);

        /**
         * <h3>loginWithSocial</h3>
         * <p>login with different social media auth providers</p>
         *
         * @param genericData is a generic class
         * @param socialAuthProvider a value of the social auth providers enum
         * @see com.ahmedc2l.userauthstarter.utils.Constants.SocialProviders
         * */
        void loginWithSocial(GenericData genericData, Constants.SocialProviders socialAuthProvider);
    }
}
