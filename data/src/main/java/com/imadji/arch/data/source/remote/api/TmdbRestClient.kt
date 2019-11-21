package com.imadji.arch.data.source.remote.api

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class TmdbRestClient @Inject constructor(private val baseUrl: String) {

    fun getRetrofit(interceptors: MutableList<Interceptor>): Retrofit {
        val okHttpBuilder = OkHttpClient.Builder()

        if (interceptors.isNotEmpty()) {
            for (interceptor in interceptors) {
                okHttpBuilder.addInterceptor(interceptor)
            }
        }

        return Retrofit.Builder()
                .client(okHttpBuilder.build())
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}