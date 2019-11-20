package com.imadji.arch.domain.usecase

import com.imadji.arch.domain.model.Movie
import com.imadji.arch.domain.repository.MovieRepository
import com.imadji.arch.domain.usecase.type.SingleUseCase

import io.reactivex.Single
import javax.inject.Inject

class GetPopularMovies @Inject constructor(
        private val movieRepository: MovieRepository
) : SingleUseCase<MutableList<Movie>> {

    override fun execute(): Single<MutableList<Movie>> {
        return movieRepository.getPopularMovies()
    }
}