package com.ahmedc2l.userauthstarter.presenters;

import androidx.annotation.NonNull;

import com.ahmedc2l.userauthstarter.contracts.BaseContract;
import com.ahmedc2l.userauthstarter.contracts.RegisterContract;
import com.ahmedc2l.userauthstarter.network.ApiEndPointsUtils;

import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterPresenter implements RegisterContract.Presenter {
    private RegisterContract.View view;
    private BaseContract.View baseView;

    public RegisterPresenter(RegisterContract.View view, BaseContract.View baseView) {
        this.view = view;
        this.baseView = baseView;
    }

    @Override
    public void register(Map<String, Object> body) {
        baseView.showLoadingDialog();

        // TODO add different request headers if needed
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json");

        ApiEndPointsUtils.getAPIService().REGISTER(headers, body)
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
                        baseView.hideLoadingDialog();
                        // TODO handel api response
                    }

                    @Override
                    public void onFailure(@NonNull Call<ResponseBody> call, @NonNull Throwable t) {
                        baseView.hideLoadingDialog();
                        baseView.showErrorMessage(t.getMessage());
                    }
                });
    }
}
