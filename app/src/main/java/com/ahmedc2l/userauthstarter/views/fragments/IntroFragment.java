package com.ahmedc2l.userauthstarter.views.fragments;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ahmedc2l.userauthstarter.R;
import com.ahmedc2l.userauthstarter.adapters.AdapterIntroViewPager;
import com.ahmedc2l.userauthstarter.databinding.FragmentIntroBinding;
import com.ahmedc2l.userauthstarter.utils.Constants;

import me.relex.circleindicator.CircleIndicator3;

public class IntroFragment extends Fragment implements View.OnClickListener {

    private Activity activity;
    private FragmentIntroBinding binding;
    private int currentIndex = 0;

    public IntroFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity = (Activity) context;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentIntroBinding.inflate(inflater,container, false);
        binding.textViewSkip.setOnClickListener(this);
        binding.buttonNext.setOnClickListener(this);
        binding.viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                currentIndex = position;
            }
        });

        View view = binding.getRoot();

        binding.viewPager2.setAdapter(new AdapterIntroViewPager());
        CircleIndicator3 circleIndicator3 = view.findViewById(R.id.indicator);
        circleIndicator3.setViewPager(binding.viewPager2);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.textView_skip:
                Navigation.findNavController(activity, R.id.authHostFragment).navigate(R.id.action_introFragment_to_loginFragment);
                break;
            case R.id.button_next:
                currentIndex++;
                if(currentIndex < Constants.INTRO_SCREENS_NUM)
                    binding.viewPager2.setCurrentItem(currentIndex, true);
                else
                    Navigation.findNavController(activity, R.id.authHostFragment).navigate(R.id.action_introFragment_to_loginFragment);
                break;
        }
    }
}
