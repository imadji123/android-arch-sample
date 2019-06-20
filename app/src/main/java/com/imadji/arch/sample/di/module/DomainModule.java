package com.imadji.arch.sample.di.module;

import com.imadji.arch.domain.repository.MovieRepository;
import com.imadji.arch.domain.usecase.GetPopularMovies;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by imadji on 06/20/2019.
 */

@Module
public class DomainModule {

    @Singleton
    @Provides
    GetPopularMovies provideGetPopularMovies(final MovieRepository movieRepository) {
        return new GetPopularMovies(movieRepository);
    }
}
