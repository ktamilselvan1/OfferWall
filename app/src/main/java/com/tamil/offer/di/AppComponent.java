package com.tamil.offer.di;

import com.tamil.offer.di.module.NetworkModule;
import com.tamil.offer.ui.home.MainActivity;

import dagger.Component;

@Component(modules = NetworkModule.class)
public interface AppComponent {

    void inject(MainActivity homeActivity);
}
