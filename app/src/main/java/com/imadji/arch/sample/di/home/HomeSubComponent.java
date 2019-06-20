package com.imadji.arch.sample.di.home;

import com.imadji.arch.sample.feature.home.HomeFragment;

import dagger.Subcomponent;

/**
 * Created by imadji on 06/20/2019.
 */

@HomeScope
@Subcomponent(modules = HomeModule.class)
public interface HomeSubComponent {
    void inject(HomeFragment homeFragment);
}
