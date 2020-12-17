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
                                               @Query("device_id") String device_id,
                                               @Query("locale") String locale,
                                               @Query("ip") String ip,
                                               @Query("os_version") String osVersion,
                                               @Query("phone_version") String phone_version,
                                               @Query("timestamp") String timestamp,
                                               @Query("uid") String uId,
                                               @Query("hashkey") String hashKey);

}
