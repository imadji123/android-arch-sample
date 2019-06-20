package com.imadji.arch.sample.di.module;

import com.imadji.arch.data.source.remote.api.ApiService;
import com.imadji.arch.data.source.remote.api.TmdbApi;
import com.imadji.arch.data.source.remote.interceptor.RequestInterceptor;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import retrofit2.Retrofit;

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
        interceptors.add(new RequestInterceptor(apiKey));
        return interceptors;
    }

    @Singleton
    @Provides
    Retrofit provideRetrofit(List<Interceptor> interceptors) {
        return new ApiService(baseUrl).getRetrofit(interceptors);
    }

    @Singleton
    @Provides
    TmdbApi provideTmdbApi(Retrofit retrofit) {
        return retrofit.create(TmdbApi.class);
    }
}
