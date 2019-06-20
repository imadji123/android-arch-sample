package com.imadji.arch.domain.repository;

import com.imadji.arch.domain.model.Movie;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by imadji on 06/10/2019.
 */

public interface MovieRepository {

    Single<List<Movie>> getPopularMovies();

}
