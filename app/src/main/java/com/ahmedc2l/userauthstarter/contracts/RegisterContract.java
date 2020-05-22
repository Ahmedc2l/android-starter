package com.ahmedc2l.userauthstarter.contracts;

import java.util.Map;

/**
 * <h2>RegisterContract</h2>
 * <p>Interface that declares all the functions and view actions for the login fragment</p>
 *
 * @see com.ahmedc2l.userauthstarter.views.fragments.RegisterFragment
 * */
public interface RegisterContract {
    interface View{
        // TODO here you define all the view or UI actions you wanna perform in the register fragment
    }

    /**
     * @see com.ahmedc2l.userauthstarter.presenters.RegisterPresenter
     * */
    interface Presenter{
        /**
         * <h3>register</h3>
         * <p>regular register with data like name, email and password for example</p>
         *
         * @param body is the key value pair Map<String, Object>
         * */
        void register(Map<String, Object> body);
    }
}
