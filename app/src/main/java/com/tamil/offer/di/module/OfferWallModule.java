package com.tamil.offer.di.module;

import androidx.lifecycle.ViewModelProvider;

import com.tamil.offer.data.network.ApiService;
import com.tamil.offer.data.repo.OfferWallRepository;
import com.tamil.offer.ui.offerwall.OfferWallViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public class OfferWallModule {

    @Provides
    OfferWallRepository providesOfferWallRepository(ApiService apiService) {
        return new OfferWallRepository(apiService);
    }
}
