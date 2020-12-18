package com.tamil.offer.ui.offerwall;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tamil.offer.R;
import com.tamil.offer.base.BaseFragment;
import com.tamil.offer.databinding.FragmentOfferWallBinding;

import javax.inject.Inject;

public class OfferWallFragment extends BaseFragment<OfferWallViewModel> {

    @Inject
    ViewModelProvider.Factory factory;

    private FragmentOfferWallBinding binding;

    private OfferWallViewModel offerWallViewModel;
    private final OfferWallAdapter adapter = new OfferWallAdapter();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentOfferWallBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        binding.offerList.setLayoutManager(layoutManager);
        binding.offerList.setAdapter(adapter);
        offerWallViewModel.offerWallResponse.observe(getViewLifecycleOwner(),
                offerWallResponseBaseResponse -> {
                    adapter.submitList(offerWallResponseBaseResponse.getOffers());
                    adapter.notifyDataSetChanged();
                });

        offerWallViewModel.showLoading.observe(getViewLifecycleOwner(), showLoading -> {
            if (showLoading) {
                binding.progressbar.setVisibility(View.VISIBLE);
            } else {
                binding.progressbar.setVisibility(View.GONE);
            }
        });

        offerWallViewModel.getOfferWallData();
    }

    @Override
    public OfferWallViewModel getViewModel() {
        offerWallViewModel = new ViewModelProvider(this, factory).get(OfferWallViewModel.class);
        return offerWallViewModel;
    }
}
