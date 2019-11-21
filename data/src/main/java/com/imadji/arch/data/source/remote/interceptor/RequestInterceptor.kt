package com.imadji.arch.data.source.remote.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class RequestInterceptor @Inject constructor(private val apiKey: String) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val originalHttpUrl = originalRequest.url

        val newUrl = originalHttpUrl.newBuilder()
                .addQueryParameter(REQUEST_PARAM_API_KEY, apiKey)
                .build()

        val requestBuilder = originalRequest.newBuilder()
                .url(newUrl)

        val newRequest = requestBuilder.build()

        return chain.proceed(newRequest)
    }

    companion object {
        private const val REQUEST_PARAM_API_KEY = "api_key"
    }
}