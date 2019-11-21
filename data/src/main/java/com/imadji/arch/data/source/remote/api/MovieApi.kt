package com.imadji.arch.data.source.remote.api

import com.imadji.arch.data.source.remote.response.MovieCollectionResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET("movie/popular")
    fun getPopularMovies(@Query("page") page: Int): Single<MovieCollectionResponse>
}