package com.imadji.arch.domain.repository;

import com.imadji.arch.domain.model.Movie;

import java.util.List;

import io.reactivex.Single;

public interface MovieRepository {
    Single<List<Movie>> getPopularMovies();
}
