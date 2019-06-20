package com.imadji.arch.sample.di.module;

import android.content.Context;

import com.imadji.arch.data.repository.MovieDataRepository;
import com.imadji.arch.data.source.cache.CachedMovieDataSource;
import com.imadji.arch.data.source.cache.MemoryMovieCache;
import com.imadji.arch.data.source.cache.MovieCache;
import com.imadji.arch.data.source.local.preference.Preferences;
import com.imadji.arch.data.source.local.preference.PreferencesHelper;
import com.imadji.arch.data.source.remote.RemoteMovieDataSource;
import com.imadji.arch.data.source.remote.api.TmdbApi;
import com.imadji.arch.domain.repository.MovieRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by imadji on 06/19/2019.
 */

@Module
public class DataModule {

    @Singleton
    @Provides
    Preferences providePreferencesHelper(Context appContext) {
        return new PreferencesHelper(appContext);
    }

    @Singleton
    @Provides
    MovieCache provideMemoryMovieCache(Preferences preferencesHelper) {
        return new MemoryMovieCache(preferencesHelper);
    }

    @Singleton
    @Provides
    MovieRepository provideMovieRepository(MovieCache movieCache, TmdbApi tmdbApi) {
        CachedMovieDataSource cachedDataSource = new CachedMovieDataSource(movieCache);
        RemoteMovieDataSource remoteDataSource = new RemoteMovieDataSource(tmdbApi);
        return new MovieDataRepository(cachedDataSource, remoteDataSource);
    }
}
