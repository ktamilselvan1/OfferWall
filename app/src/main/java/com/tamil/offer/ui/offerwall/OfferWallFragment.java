package com.tamil.offer.ui.offerwall;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

import com.tamil.offer.base.BaseFragment;

import javax.inject.Inject;

public class OfferWallFragment extends BaseFragment {

    @Inject
    OfferWallViewModel offerWallViewModel;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        offerWallViewModel.offerWallResponse.observe(getViewLifecycleOwner(),
                offerWallResponseBaseResponse -> {

                });

        offerWallViewModel.showLoading.observe(getViewLifecycleOwner(), showLoading -> {
            if (showLoading) {

            } else {

            }
        });

        offerWallViewModel.getOfferWallData();
    }
}
