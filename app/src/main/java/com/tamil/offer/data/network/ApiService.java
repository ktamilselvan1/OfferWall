package com.tamil.offer.data.network;

import com.tamil.offer.data.repo.response.OfferWallResponse;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("offers.json")
    Observable<OfferWallResponse> getOfferWall(@Query("appid") String appId,
                                               @Query("locale") String locale,
                                               @Query("ip") String ip,
                                               @Query("offer_types") String offerTypes,
                                               @Query("timestamp") String timestamp,
                                               @Query("uid") String uId,
                                               @Query("hashkey") String hashKey);

}
