package com.imadji.arch.data.datasource.remote.api;

import com.imadji.arch.data.datasource.remote.response.MovieListResponse;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface TmdbApi {

    @GET("movie/popular")
    Single<MovieListResponse> getPopularMovies();

}
