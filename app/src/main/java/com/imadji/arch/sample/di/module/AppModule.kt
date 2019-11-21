package com.imadji.arch.sample.di.module

import android.content.Context
import javax.inject.Singleton
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val appContext: Context) {

    @Singleton
    @Provides
    fun provideAppContext(): Context {
        return appContext
    }
}