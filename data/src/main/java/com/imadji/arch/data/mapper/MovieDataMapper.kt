package com.imadji.arch.data.mapper

import com.imadji.arch.data.entity.MovieData
import com.imadji.arch.domain.common.Mapper
import com.imadji.arch.domain.model.Movie

class MovieDataMapper : Mapper<MovieData, Movie>() {

    override fun mapFrom(from: MovieData): Movie {
        return Movie(from.id, from.title, POSTER_BASE_URL + from.posterPath)
    }

    companion object {
        private const val POSTER_BASE_URL = "https://image.tmdb.org/t/p/w342"
    }
}