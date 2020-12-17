package com.tamil.offer.di;

import android.app.Application;

import com.tamil.offer.OfferWallApplication;
import com.tamil.offer.di.module.ActivityModule;
import com.tamil.offer.di.module.AppModule;
import com.tamil.offer.di.module.ViewModelInjectionModule;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Component(modules = {
        AndroidSupportInjectionModule.class,
        AppModule.class,
        ViewModelInjectionModule.class,
        ActivityModule.class})
public interface AppComponent extends AndroidInjector<OfferWallApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
