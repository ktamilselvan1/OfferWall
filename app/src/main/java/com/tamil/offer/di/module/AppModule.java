package com.tamil.offer.di.module;

import com.tamil.offer.ui.home.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class AppModule {

    @ContributesAndroidInjector(modules = {FragmentModule.class})
    abstract MainActivity bindMainActivity();
}
