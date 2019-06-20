package com.imadji.arch.sample.di.home;

import com.imadji.arch.domain.usecase.GetPopularMovies;
import com.imadji.arch.sample.feature.home.HomeViewModelFactory;

import dagger.Module;
import dagger.Provides;

/**
 * Created by imadji on 06/20/2019.
 */

@Module
public class HomeModule {

    @Provides
    HomeViewModelFactory provideHomeViewModelFactory(GetPopularMovies getPopularMovies) {
        return new HomeViewModelFactory(getPopularMovies);
    }
}
