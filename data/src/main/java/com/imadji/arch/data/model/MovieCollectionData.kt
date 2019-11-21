package com.imadji.arch.data.model

data class MovieData(
        val id: Long,
        val title: String,
        val overview: String,
        val posterPath: String,
        val backdropPath: String,
        val releaseDate: String,
        val voteAverage: Float,
        val originalTitle: String,
        val originalLanguage: String,
        val genreIds: MutableList<Int>
)