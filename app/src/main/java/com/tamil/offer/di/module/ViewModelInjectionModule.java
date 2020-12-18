package com.tamil.offer.di.module;

import androidx.lifecycle.ViewModelProvider;

import com.tamil.offer.di.utils.ViewModelProviderFactory;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ViewModelInjectionModule {

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory providerFactory);
}
