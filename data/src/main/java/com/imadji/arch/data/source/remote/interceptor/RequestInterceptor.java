package com.imadji.arch.data.source.remote.interceptor;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class RequestInterceptor implements Interceptor {
    private String apiKey;

    public RequestInterceptor(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();
        HttpUrl originalHttpUrl = originalRequest.url();

        HttpUrl newUrl = originalHttpUrl.newBuilder()
                .addQueryParameter("api_key", apiKey)
                .build();

        Request.Builder requestBuilder = originalRequest.newBuilder()
                .url(newUrl);

        Request newRequest = requestBuilder.build();

        return chain.proceed(newRequest);
    }
}
