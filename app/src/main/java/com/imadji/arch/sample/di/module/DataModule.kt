package com.imadji.arch.sample.di.module

import android.content.Context
import com.imadji.arch.data.repository.MovieDataRepository
import com.imadji.arch.data.source.local.preference.Preferences
import com.imadji.arch.data.source.local.preference.PreferencesHelper
import com.imadji.arch.data.source.remote.MovieRemoteDataSource
import com.imadji.arch.domain.repository.MovieRepository
import javax.inject.Singleton
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Singleton
    @Provides
    fun providePreferences(appContext: Context): Preferences {
        return PreferencesHelper(appContext)
    }

    @Singleton
    @Provides
    fun provideMovieRepository(remoteDataSource: MovieRemoteDataSource): MovieRepository {
        return MovieDataRepository(remoteDataSource)
    }
}