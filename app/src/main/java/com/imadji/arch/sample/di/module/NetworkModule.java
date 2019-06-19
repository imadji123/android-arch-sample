package com.imadji.arch.sample.di.module;

import com.imadji.arch.data.source.remote.api.TmdbApi;
import com.imadji.arch.data.source.remote.interceptor.RequestInterceptor;
import com.imadji.arch.sample.BuildConfig;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by imadji on 06/19/2019.
 */

@Module
public class NetworkModule {
    private String baseUrl;
    private String apiKey;

    public NetworkModule(String baseUrl, String apiKey) {
        this.baseUrl = baseUrl;
        this.apiKey = apiKey;
    }

    @Singleton
    @Provides
    List<Interceptor> provideInterceptors() {
        List<Interceptor> interceptors = new ArrayList<>();

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            interceptors.add(loggingInterceptor);
        }

        interceptors.add(new RequestInterceptor(apiKey));

        return interceptors;
    }

    @Singleton
    @Provides
    Retrofit provideRetrofit(List<Interceptor> interceptors) {
        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();
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

    @Singleton
    @Provides
    TmdbApi provideTmdbApi(Retrofit retrofit) {
        return retrofit.create(TmdbApi.class);
    }
}
