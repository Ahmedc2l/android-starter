package com.ahmedc2l.userauthstarter.contracts;


/**
 * <h2>BaseContract</h2>
 * <p>Interface that declares all base functions and view actions to be implemented in across the app</p>
 * */
public interface BaseContract {
    interface View{
        /**
         * <h3>showLoadingDialog</h3>
         * <p>this function should display your custom loading dialog</p>
         *
         * @see layout/_dialog_loading.xml
         * */
        void showLoadingDialog();

        /**
         * <h3>hideLoadingDialog</h3>
         * <p>this function should hide your custom loading dialog</p>
         *
         * @see layout/_dialog_loading.xml
         * */
        void hideLoadingDialog();

        /**
         * <h3>showErrorMessage</h3>
         * <p>this function should display your custom error dialog</p>
         *
         * @see layout/_dialog_error.xml
         * */
        void showErrorMessage(String error);

        /**
         * <h3>showSuccessMessage</h3>
         * <p>this function should display your custom success dialog</p>
         *
         * @see layout/_dialog_success.xml
         * */
        void showSuccessMessage(String message);
    }
}
