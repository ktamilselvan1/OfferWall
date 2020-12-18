package com.tamil.offer.di.module;

import androidx.lifecycle.ViewModel;

import com.tamil.offer.di.utils.ViewModelKey;
import com.tamil.offer.ui.offerwall.OfferWallFragment;
import com.tamil.offer.ui.offerwall.OfferWallViewModel;
import com.tamil.offer.ui.settings.SettingsFragment;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import dagger.multibindings.IntoMap;

@Module
public abstract class FragmentModule {

    @ContributesAndroidInjector(modules = OfferWallModule.class)
    abstract OfferWallFragment bindOfferWallFragment();

    @ContributesAndroidInjector
    abstract SettingsFragment bindSeettingsFragment();

    @Binds
    @IntoMap
    @ViewModelKey(OfferWallViewModel.class)
    abstract ViewModel bindOfferWallViewModel(OfferWallViewModel offerWallViewModel);
}
