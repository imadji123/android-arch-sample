package com.imadji.arch.data.repository

import com.imadji.arch.data.common.mapToEntity
import com.imadji.arch.data.source.MovieDataSource
import com.imadji.arch.domain.entity.Movie
import com.imadji.arch.domain.repository.MovieRepository

import io.reactivex.Single
import javax.inject.Inject

class MovieDataRepository @Inject constructor(
        private val remoteDataSource: MovieDataSource.Remote
) : MovieRepository {

    override fun getPopularMovies(): Single<List<Movie>> {
        return remoteDataSource.getPopularMovies().map { collection ->
            collection.results.map { movie ->
                movie.mapToEntity()
            }
        }
    }
}