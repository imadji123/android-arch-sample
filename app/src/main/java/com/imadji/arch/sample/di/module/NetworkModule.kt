package com.imadji.arch.sample.di.module

import com.imadji.arch.data.source.remote.api.TmdbRestClient
import com.imadji.arch.data.source.remote.api.MovieApi
import com.imadji.arch.data.source.remote.interceptor.RequestInterceptor
import com.imadji.arch.sample.BuildConfig
import java.util.ArrayList
import javax.inject.Singleton
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

@Module
class NetworkModule(private val baseUrl: String, private val apiKey: String) {

    @Singleton
    @Provides
    fun provideInterceptors(): List<Interceptor> {
        val interceptors = ArrayList<Interceptor>()
        interceptors.add(createLoggingInterceptor())
        interceptors.add(RequestInterceptor(apiKey))
        return interceptors
    }

    @Singleton
    @Provides
    fun provideRetrofit(interceptors: MutableList<Interceptor>): Retrofit {
        return TmdbRestClient(baseUrl).getRetrofit(interceptors)
    }

    @Singleton
    @Provides
    fun provideMovieApi(retrofit: Retrofit): MovieApi {
        return retrofit.create(MovieApi::class.java)
    }

    private fun createLoggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }
        return loggingInterceptor
    }
}