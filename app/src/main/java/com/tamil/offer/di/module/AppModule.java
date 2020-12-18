package com.tamil.offer.di.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.tamil.offer.BuildConfig;
import com.tamil.offer.data.network.ApiService;
import com.tamil.offer.util.FormSettings;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {

    @Provides
    Retrofit provideRetrofit() {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient.addInterceptor(loggingInterceptor);

        return new Retrofit.Builder()
                .baseUrl(BuildConfig.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient.build())
                .build();
    }

    @Provides
    ApiService provideApiService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }

    @Provides
    SharedPreferences provideSharedPreferences(Application application) {
        return application.getSharedPreferences("OfferWall", Context.MODE_PRIVATE);
    }

    @Provides
    FormSettings provideFormSettings(SharedPreferences sharedPreferences) {
        return new FormSettings(sharedPreferences);
    }
}
