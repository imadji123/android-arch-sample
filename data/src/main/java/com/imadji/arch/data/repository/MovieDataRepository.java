package com.imadji.arch.data.repository;

import com.imadji.arch.data.datasource.network.TmdbService;
import com.imadji.arch.data.datasource.network.response.MovieListResponse;
import com.imadji.arch.domain.model.Movie;
import com.imadji.arch.domain.repository.MovieRepository;

import java.util.List;

import io.reactivex.Single;

public class MovieDataRepository implements MovieRepository {

    @Override
    public Single<List<Movie>> getPopularMovies() {
        return TmdbService.getTmdbApi().getPopularMovies()
                .map(MovieListResponse::getMovieList);
    }

}
