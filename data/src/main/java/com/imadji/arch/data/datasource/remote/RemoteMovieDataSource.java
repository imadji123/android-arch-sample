package com.imadji.arch.data.datasource.remote;

import com.imadji.arch.data.datasource.MovieDataSource;
import com.imadji.arch.data.datasource.remote.api.TmdbApi;
import com.imadji.arch.data.datasource.remote.response.MovieListResponse;
import com.imadji.arch.domain.model.Movie;

import java.util.List;

import io.reactivex.Single;

public class RemoteMovieDataSource implements MovieDataSource {
    private TmdbApi tmdbApi;

    public RemoteMovieDataSource(TmdbApi tmdbApi) {
        this.tmdbApi = tmdbApi;
    }

    @Override
    public Single<List<Movie>> getPopularMovies() {
        return tmdbApi.getPopularMovies()
                .map(MovieListResponse::getMovieList);
    }
}