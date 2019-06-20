package com.imadji.arch.data.source.remote.api;

import com.imadji.arch.data.BuildConfig;

import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by imadji on 06/20/2019.
 */

public class ApiService {
    private String baseUrl;

    public ApiService(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public Retrofit getRetrofit(List<Interceptor> interceptors) {
        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            interceptors.add(loggingInterceptor);
        }

        if (!interceptors.isEmpty()) {
            for (Interceptor interceptor : interceptors) {
                okHttpBuilder.addInterceptor(interceptor);
            }
        }

        return new Retrofit.Builder()
                .client(okHttpBuilder.build())
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
}
