package com.imadji.arch.domain.repository

import com.imadji.arch.domain.entity.Movie
import io.reactivex.Single

interface MovieRepository {
    fun getPopularMovies(): Single<List<Movie>>
}