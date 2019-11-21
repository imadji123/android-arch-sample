package com.imadji.arch.data.source.remote

import com.imadji.arch.data.source.MovieDataSource
import com.imadji.arch.data.source.remote.api.MovieApi
import com.imadji.arch.data.source.remote.response.MovieCollectionResponse
import io.reactivex.Single
import javax.inject.Inject

class MovieRemoteDataSource @Inject constructor(
        private val movieApi: MovieApi
) : MovieDataSource.Remote {

    override fun getPopularMovies(page: Int): Single<MovieCollectionResponse> {
        return movieApi.getPopularMovies(page)
    }
}