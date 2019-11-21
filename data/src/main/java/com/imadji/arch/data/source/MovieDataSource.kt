package com.imadji.arch.data.source

import com.imadji.arch.domain.model.Movie
import io.reactivex.Single

interface MovieDataSource {
    fun getPopularMovies(): Single<MutableList<Movie>>
}