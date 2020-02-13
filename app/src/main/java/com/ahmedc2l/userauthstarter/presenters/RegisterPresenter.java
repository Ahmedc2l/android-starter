package com.ahmedc2l.userauthstarter.presenters;

import com.ahmedc2l.userauthstarter.contracts.BaseContract;
import com.ahmedc2l.userauthstarter.contracts.RegisterContract;

import java.util.Map;

public class RegisterPresenter implements RegisterContract.Presenter {
    private RegisterContract.View view;
    private BaseContract.View baseView;

    public RegisterPresenter(RegisterContract.View view, BaseContract.View baseView) {
        this.view = view;
        this.baseView = baseView;
    }

    @Override
    public void register(Map<String, Object> body) {

    }
}
