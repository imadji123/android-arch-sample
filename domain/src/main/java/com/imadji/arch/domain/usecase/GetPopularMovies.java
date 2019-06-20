package com.imadji.arch.domain.usecase;

import com.imadji.arch.domain.model.Movie;
import com.imadji.arch.domain.repository.MovieRepository;
import com.imadji.arch.domain.usecase.type.SingleUseCase;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by imadji on 06/20/2019.
 */

public class GetPopularMovies implements SingleUseCase<List<Movie>> {
    private final MovieRepository movieRepository;

    public GetPopularMovies(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Single<List<Movie>> execute() {
        return movieRepository.getPopularMovies();
    }
}
