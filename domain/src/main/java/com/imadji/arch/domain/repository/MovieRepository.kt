package com.imadji.arch.domain.repository

import com.imadji.arch.domain.model.Movie

import io.reactivex.Single

interface MovieRepository {
    fun getPopularMovies(): Single<MutableList<Movie>>
}