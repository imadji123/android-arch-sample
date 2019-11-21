package com.imadji.arch.domain.usecase

import com.imadji.arch.domain.entity.Movie
import com.imadji.arch.domain.repository.MovieRepository
import com.imadji.arch.domain.usecase.type.SingleUseCase

import io.reactivex.Single
import javax.inject.Inject

class GetPopularMovies @Inject constructor(
        private val movieRepository: MovieRepository
) : SingleUseCase<List<Movie>> {

    override fun execute(): Single<List<Movie>> {
        return movieRepository.getPopularMovies()
    }
}