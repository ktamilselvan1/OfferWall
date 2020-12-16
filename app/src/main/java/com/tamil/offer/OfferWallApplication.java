package com.tamil.offer;

import android.app.Application;

import com.tamil.offer.di.AppComponent;
import com.tamil.offer.di.DaggerAppComponent;

public class OfferWallApplication extends Application {
    public AppComponent appComponent = DaggerAppComponent.create();

}
