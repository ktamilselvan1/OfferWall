package com.tamil.offer.data.network;

import com.tamil.offer.data.repo.response.OfferWallResponse;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("")
    Observable<OfferWallResponse> getOfferWall(@Query("appid") String appId,
                                             @Query("uid") String uId,
                                             @Query("ip") String ip,
                                             @Query("locale") String locale,
                                             @Query("device_id") String device_id,
                                             @Query("timestamp") String timestamp,
                                             @Query("phone_version") String phone_version,
                                             @Query("hashkey") String hashKey);

}
