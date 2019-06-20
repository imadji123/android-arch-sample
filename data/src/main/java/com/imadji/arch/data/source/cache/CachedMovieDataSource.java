package com.imadji.arch.data.source.cache;

import com.imadji.arch.data.source.MovieDataSource;
import com.imadji.arch.domain.model.Movie;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

/**
 * Created by imadji on 06/14/2019.
 */

public class CachedMovieDataSource implements MovieDataSource {
    private final MovieCache movieCache;

    public CachedMovieDataSource(MovieCache movieCache) {
        this.movieCache = movieCache;
    }

    @Override
    public Single<List<Movie>> getPopularMovies() {
        return movieCache.getAll();
    }

    public boolean isEmpty() {
        return movieCache.isEmpty();
    }

    public boolean isExpired() {
        return movieCache.isExpired();
    }

    public Completable clear() {
        return movieCache.clear();
    }

    public Completable saveAll(List<Movie> movies) {
        return movieCache.saveAll(movies);
    }
}
