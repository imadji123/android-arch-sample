package com.imadji.arch.sample.di

import com.imadji.arch.sample.di.home.HomeModule
import com.imadji.arch.sample.di.home.HomeSubComponent
import com.imadji.arch.sample.di.module.AppModule
import com.imadji.arch.sample.di.module.DataModule
import com.imadji.arch.sample.di.module.NetworkModule
import javax.inject.Singleton
import dagger.Component

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class, DataModule::class])
interface MainComponent {
    fun plus(homeModule: HomeModule): HomeSubComponent
}