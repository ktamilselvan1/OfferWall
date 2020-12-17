package com.tamil.offer.ui.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;

import com.tamil.offer.R;
import com.tamil.offer.base.BaseFragment;
import com.tamil.offer.databinding.FragmentSettingsBinding;
import com.tamil.offer.ui.home.MainActivity;
import com.tamil.offer.util.FormSettings;

import java.util.Objects;

import javax.inject.Inject;

public class SettingsFragment extends BaseFragment {

    @Inject
    FormSettings formSettings;

    private FragmentSettingsBinding fragmentSettingsBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentSettingsBinding = FragmentSettingsBinding.inflate(inflater);
        return fragmentSettingsBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        fragmentSettingsBinding.submit.setOnClickListener(view -> {
            if (Objects.requireNonNull(fragmentSettingsBinding.appIdEditText.getText()).toString().trim().length() == 0) {
                fragmentSettingsBinding.appIdInputLayout.setError("Enter the Application ID");
                return;
            } else {
                fragmentSettingsBinding.appIdInputLayout.setError(null);
                formSettings.setApplicationID(fragmentSettingsBinding.appIdEditText.getText().toString().trim());
            }
            if (Objects.requireNonNull(fragmentSettingsBinding.userIdEditText.getText()).toString().trim().length() == 0) {
                fragmentSettingsBinding.userIdInputLayout.setError("Enter the User ID");
                return;
            } else {
                fragmentSettingsBinding.userIdInputLayout.setError(null);
                formSettings.setUserID(fragmentSettingsBinding.userIdEditText.getText().toString().trim());

            }
            if (Objects.requireNonNull(fragmentSettingsBinding.tokenEditText.getText()).toString().trim().length() == 0) {
                fragmentSettingsBinding.tokenInputLayout.setError("Enter the Token");
                return;
            } else {
                fragmentSettingsBinding.tokenInputLayout.setError(null);
                formSettings.setToken(fragmentSettingsBinding.tokenEditText.getText().toString().trim());
            }
            ((MainActivity)getActivity()).getNavController().navigateUp();
        });

        fragmentSettingsBinding.appIdEditText.setText(formSettings.getApplicationID());
        fragmentSettingsBinding.userIdEditText.setText(formSettings.getUserID());
        fragmentSettingsBinding.tokenEditText.setText(formSettings.getToken());

    }

    @Override
    public ViewModel getViewModel() {
        return null;
    }
}
