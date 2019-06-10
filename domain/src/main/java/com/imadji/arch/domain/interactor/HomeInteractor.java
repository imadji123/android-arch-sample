package com.imadji.arch.domain.interactor;

import com.imadji.arch.domain.model.Movie;
import com.imadji.arch.domain.repository.MovieRepository;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class HomeInteractor {
    private MovieRepository movieRepository;

    public HomeInteractor(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Single<List<Movie>> getPopularMovies() {
        return movieRepository.getPopularMovies()
                .subscribeOn(Schedulers.io());
    }
}
