package com.imadji.arch.domain.common

import com.imadji.arch.domain.model.Movie

class TestUtil {

    companion object {
        private const val DEFAULT_TOTAL_DATA = 10

        fun mockMovies(total: Int = DEFAULT_TOTAL_DATA): MutableList<Movie> {
            val mockMovies = mutableListOf<Movie>()
            for (mockId in 1..total) {
                mockMovies.add(mockMovie(mockId))
            }
            return mockMovies
        }

        fun mockMovie(mockId: Int): Movie {
            return Movie(id = mockId.toLong(), title = "title-$mockId")
        }
    }
}