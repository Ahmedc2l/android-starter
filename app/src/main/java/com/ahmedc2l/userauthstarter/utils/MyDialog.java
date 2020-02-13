package com.ahmedc2l.userauthstarter.utils;

import android.app.Activity;
import android.app.Dialog;
import android.view.Gravity;
import android.view.Window;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.ahmedc2l.userauthstarter.R;

/**
 * <h1>MyDialog</h1>
 *
 * @author Ahmed Fathy
 * @version 1.0
 * @since 25-Dec-2019
 * */
public class MyDialog {
    private Activity activity;
    private Dialog dialog;

    public MyDialog(Activity activity) {
        this.activity = activity;
    }

    public void showLoadingDialog() {
        if(dialog != null && dialog.isShowing())
            dialog.dismiss();

        dialog  = getDialogInstance(R.layout._dialog_loading, Gravity.CENTER, false);
        dialog.show();
    }

    public void showSuccessMessage(String message){
        if(dialog != null && dialog.isShowing())
            dialog.dismiss();

        dialog  = getDialogInstance(R.layout._dialog_success, Gravity.CENTER, true);
        dialog.show();

        TextView textView_success = dialog.findViewById(R.id.textView_success);
        textView_success.setText(message);
    }

    public void showErrorMessage(String message){
        if(dialog != null && dialog.isShowing())
            dialog.dismiss();

        dialog  = getDialogInstance(R.layout._dialog_error, Gravity.CENTER, true);
        dialog.show();

        TextView textView_error = dialog.findViewById(R.id.textView_error);
        textView_error.setText(message);
    }

    public void hideDialog(){
        if(dialog != null && !dialog.isShowing())
            dialog.dismiss();
    }

    /**
     * <h3>getDialogInstance</h3>
     * <p>creates a dialog instance</p>
     *
     * @param layout the dialog layout
     * @param gravity the gravity position the dialog should be displayed in
     * @param isCancelable whether the dialog should be auto cancelable or no
     * */
    public Dialog getDialogInstance(int layout, int gravity, boolean isCancelable){
        Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(isCancelable);
        dialog.setContentView(layout);

        Window window = dialog.getWindow();
        if(window != null) {
            //window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            window.setLayout(ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);
            window.setGravity(gravity);
        }

        return dialog;
    }
}
