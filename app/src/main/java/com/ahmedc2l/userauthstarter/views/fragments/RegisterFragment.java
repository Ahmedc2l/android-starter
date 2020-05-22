package com.ahmedc2l.userauthstarter.views.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ahmedc2l.userauthstarter.R;
import com.ahmedc2l.userauthstarter.contracts.BaseContract;
import com.ahmedc2l.userauthstarter.contracts.RegisterContract;
import com.ahmedc2l.userauthstarter.databinding.FragmentRegisterBinding;
import com.ahmedc2l.userauthstarter.presenters.RegisterPresenter;
import com.ahmedc2l.userauthstarter.utils.MyDialog;

public class RegisterFragment extends Fragment implements View.OnClickListener, RegisterContract.View, BaseContract.View {

    private Activity activity;
    private MyDialog myDialog;
    private FragmentRegisterBinding binding;
    private RegisterPresenter registerPresenter;

    public RegisterFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.activity = (Activity) context;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(inflater, container, false);
        binding.textViewLogin.setOnClickListener(this);
        binding.buttonRegister.setOnClickListener(this);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        myDialog = new MyDialog(activity);
        registerPresenter = new RegisterPresenter(this, this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_login:
                break;
            case R.id.textView_login:
                Navigation.findNavController(activity, R.id.authHostFragment).navigateUp();
                break;
        }
    }

    @Override
    public void showLoadingDialog() {
        myDialog.showLoadingDialog();
    }

    @Override
    public void hideLoadingDialog() {
        myDialog.hideDialog();
    }

    @Override
    public void showErrorMessage(String error) {
        myDialog.showErrorMessage(error);
    }

    @Override
    public void showSuccessMessage(String message) {
        myDialog.showSuccessMessage(message);
    }
}