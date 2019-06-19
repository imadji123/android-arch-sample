package com.imadji.arch.sample.di.module;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by imadji on 06/19/2019.
 */

@Module
public class AppModule {
    private Context appContext;

    public AppModule(Context context) {
        this.appContext = context;
    }

    @Singleton
    @Provides
    Context provideAppContext() {
        return appContext;
    }
}
