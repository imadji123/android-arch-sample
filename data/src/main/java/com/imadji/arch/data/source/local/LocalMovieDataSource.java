package com.imadji.arch.data.source.local;

import com.imadji.arch.data.source.MovieDataSource;
import com.imadji.arch.data.source.local.database.MovieDatabase;
import com.imadji.arch.domain.entity.Movie;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;

public class LocalMovieDataSource implements MovieDataSource {
    private final MovieDatabase database;

    public LocalMovieDataSource(MovieDatabase database) {
        this.database = database;
    }

    @Override
    public Single<List<Movie>> getPopularMovies() {
        return Single.just(new ArrayList<>());
    }
}
