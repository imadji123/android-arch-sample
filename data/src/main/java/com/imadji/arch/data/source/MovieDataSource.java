package com.imadji.arch.data.source;

import com.imadji.arch.domain.model.Movie;

import java.util.List;

import io.reactivex.Single;

public interface MovieDataSource {

    Single<List<Movie>> getPopularMovies();

}
