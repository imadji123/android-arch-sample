package com.imadji.arch.data.entity

import com.google.gson.annotations.SerializedName

data class MovieData(
        @SerializedName("id") val id: Long,
        @SerializedName("title") val title: String,
        @SerializedName("overview") val overview: String,
        @SerializedName("poster_path") val posterPath: String,
        @SerializedName("backdrop_path") val backdropPath: String,
        @SerializedName("release_date") val releaseDate: String,
        @SerializedName("vote_average") val voteAverage: Float,
        @SerializedName("original_title") val originalTitle: String,
        @SerializedName("original_language") val originalLanguage: String,
        @SerializedName("genre_ids") val genreIds: MutableList<Int>
)