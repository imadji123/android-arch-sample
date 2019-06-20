package com.imadji.arch.data.source;

import com.imadji.arch.domain.model.Movie;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by imadji on 06/14/2019.
 */

public interface MovieDataSource {

    Single<List<Movie>> getPopularMovies();

}
