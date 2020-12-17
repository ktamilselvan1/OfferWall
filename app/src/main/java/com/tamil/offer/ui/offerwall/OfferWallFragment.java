package com.tamil.offer.ui.offerwall;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tamil.offer.R;
import com.tamil.offer.base.BaseFragment;

import javax.inject.Inject;

public class OfferWallFragment extends BaseFragment<OfferWallViewModel> {

    @Inject
    ViewModelProvider.Factory factory;

    private OfferWallViewModel offerWallViewModel;
    private RecyclerView recyclerView;
    private final OfferWallAdapter adapter = new OfferWallAdapter();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_offer_wall, container, false);
        recyclerView = view.findViewById(R.id.offer_list);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        offerWallViewModel.offerWallResponse.observe(getViewLifecycleOwner(),
                offerWallResponseBaseResponse -> {
                    adapter.submitList(offerWallResponseBaseResponse.getOffers());
                    adapter.notifyDataSetChanged();
                });

        offerWallViewModel.showLoading.observe(getViewLifecycleOwner(), showLoading -> {
            if (showLoading) {

            } else {

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
