package com.imadji.arch.sample;

import android.app.Application;

import com.imadji.arch.sample.di.DaggerMainComponent;
import com.imadji.arch.sample.di.MainComponent;
import com.imadji.arch.sample.di.home.HomeModule;
import com.imadji.arch.sample.di.home.HomeSubComponent;
import com.imadji.arch.sample.di.module.AppModule;
import com.imadji.arch.sample.di.module.DataModule;
import com.imadji.arch.sample.di.module.NetworkModule;

/**
 * Created by imadji on 03/17/2019.
 */

public class MainApplication extends Application {
    private static final String BASE_URL = "https://api.themoviedb.org/3/";
    private static final String API_KEY = "0940c852e95f2a6df52a1071c391e729";

    private MainComponent mainComponent;
    private HomeSubComponent homeComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        initDependencies();
    }

    private void initDependencies() {
        mainComponent = DaggerMainComponent.builder()
                .appModule(new AppModule(getApplicationContext()))
                .networkModule(new NetworkModule(BASE_URL, API_KEY))
                .build();
    }

    public HomeSubComponent createHomeComponent() {
        homeComponent = mainComponent.plus(new HomeModule());
        return homeComponent;
    }

    public void releaseHomeComponent() {
        homeComponent = null;
    }
}
