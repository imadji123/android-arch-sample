package com.imadji.arch.data.common

import com.imadji.arch.data.source.remote.response.MovieResponse
import com.imadji.arch.domain.entity.Movie

fun MovieResponse.mapToEntity(): Movie {
    return Movie(
            id = id,
            title = title,
            posterUrl = POSTER_BASE_URL + posterPath
    )
}