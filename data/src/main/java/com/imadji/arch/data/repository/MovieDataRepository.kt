package com.imadji.arch.data.repository

import com.imadji.arch.data.source.cache.CachedMovieDataSource
import com.imadji.arch.data.source.remote.RemoteMovieDataSource
import com.imadji.arch.domain.model.Movie
import com.imadji.arch.domain.repository.MovieRepository

import io.reactivex.Single
import javax.inject.Inject

class MovieDataRepository @Inject constructor(
        private val cachedDataSource: CachedMovieDataSource,
        private val remoteDataSource: RemoteMovieDataSource
) : MovieRepository {

    override fun getPopularMovies(): Single<MutableList<Movie>> {
        return if (!cachedDataSource.isEmpty && !cachedDataSource.isExpired) {
            cachedDataSource.getPopularMovies()
        } else {
            remoteDataSource.getPopularMovies()
                    .doOnSuccess { cachedDataSource.saveAll(it) }
        }
    }
}