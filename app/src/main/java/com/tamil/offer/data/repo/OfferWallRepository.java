package com.tamil.offer.data.repo;

import com.tamil.offer.data.network.ApiService;
import com.tamil.offer.data.repo.response.OfferWallResponse;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import retrofit2.Response;

@Singleton
public class OfferWallRepository {

    private final ApiService apiService;

    @Inject
    public OfferWallRepository(ApiService apiService) {
        this.apiService = apiService;
    }

    public Observable<OfferWallResponse> getOfferWallData() {
        return this.apiService.getOfferWall(
                "", "", "", "",
                "", "", "", "");
    }
}
