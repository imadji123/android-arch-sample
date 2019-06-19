package com.imadji.arch.sample.di;

import com.imadji.arch.sample.MainActivity;
import com.imadji.arch.sample.di.module.AppModule;
import com.imadji.arch.sample.di.module.DataModule;
import com.imadji.arch.sample.di.module.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by imadji on 06/19/2019.
 */

@Singleton
@Component(modules = { AppModule.class, NetworkModule.class, DataModule.class })
public interface MainComponent {

    void inject(MainActivity mainActivity);

}
