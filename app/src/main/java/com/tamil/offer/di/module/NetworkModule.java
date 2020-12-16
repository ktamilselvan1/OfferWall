package com.tamil.offer.di.module;

import com.tamil.offer.data.network.ApiService;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    @Provides
    Retrofit provideRetrofit() {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient.addInterceptor(loggingInterceptor);

        return new Retrofit.Builder()
                .baseUrl("")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient.build())
                .build();
    }

    @Provides
    ApiService provideApiService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }
}
