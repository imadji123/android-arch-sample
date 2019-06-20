package com.imadji.arch.data.repository;

import com.imadji.arch.data.source.cache.CachedMovieDataSource;
import com.imadji.arch.data.source.remote.RemoteMovieDataSource;
import com.imadji.arch.domain.model.Movie;
import com.imadji.arch.domain.repository.MovieRepository;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by imadji on 06/10/2019.
 */

public class MovieDataRepository implements MovieRepository {
    private final CachedMovieDataSource cachedDataSource;
    private final RemoteMovieDataSource remoteDataSource;

    public MovieDataRepository(CachedMovieDataSource cachedDataSource, RemoteMovieDataSource remoteDataSource) {
        this.cachedDataSource = cachedDataSource;
        this.remoteDataSource = remoteDataSource;
    }

    @Override
    public Single<List<Movie>> getPopularMovies() {
        if (!cachedDataSource.isEmpty() && !cachedDataSource.isExpired()) {
            return cachedDataSource.getPopularMovies();
        } else {
            return remoteDataSource.getPopularMovies().doOnSuccess(cachedDataSource::saveAll);
        }
    }
}
