package com.imadji.arch.data.datasource.network;

import com.imadji.arch.data.BuildConfig;
import com.imadji.arch.data.datasource.network.interceptor.RequestInterceptor;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class TmdbService {
    public static final String BASE_URL = "https://api.themoviedb.org/3/";
    public static final String API_KEY = "0940c852e95f2a6df52a1071c391e729";

    private static Retrofit retrofit;
    private static TmdbApi tmdbApi;

    public static TmdbApi getTmdbApi() {
        if (tmdbApi == null) {
            tmdbApi = getRetrofit().create(TmdbApi.class);
        }

        return tmdbApi;
    }

    private static Retrofit getRetrofit() {
        if (retrofit == null) {
            OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
            okHttpClient.addInterceptor(new RequestInterceptor());

            if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
                loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                okHttpClient.addInterceptor(loggingInterceptor);
            }

            retrofit = new Retrofit.Builder()
                    .client(okHttpClient.build())
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
