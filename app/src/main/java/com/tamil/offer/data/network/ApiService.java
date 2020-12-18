package com.tamil.offer.data.network;

import com.tamil.offer.data.repo.response.OfferWallResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("offers.json")
    Call<OfferWallResponse> getOfferWall(@Query("appid") String appId,
                                         @Query("locale") String locale,
                                         @Query("ip") String ip,
                                         @Query("offer_types") String offerTypes,
                                         @Query("timestamp") String timestamp,
                                         @Query("uid") String uId,
                                         @Query("hashkey") String hashKey);

}
