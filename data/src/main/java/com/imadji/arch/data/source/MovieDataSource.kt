package com.imadji.arch.data.source

import com.imadji.arch.data.model.MovieData
import com.imadji.arch.data.source.remote.response.MovieCollectionResponse
import com.imadji.arch.domain.common.INITIAL_PAGE
import com.imadji.arch.domain.entity.Movie
import io.reactivex.Maybe
import io.reactivex.Single

interface MovieDataSource {
    fun getPopularMovies(): Single<MutableList<Movie>>

    interface Local {
        fun getPopularMovies(): Maybe<List<MovieData>>
    }

    interface Remote {
        fun getPopularMovies(page: Int = INITIAL_PAGE): Single<MovieCollectionResponse>
    }
}