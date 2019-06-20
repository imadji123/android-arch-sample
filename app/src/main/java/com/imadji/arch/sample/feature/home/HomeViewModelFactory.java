package com.imadji.arch.sample.feature.home;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.imadji.arch.domain.usecase.GetPopularMovies;

/**
 * Created by imadji on 06/20/2019.
 */

public class HomeViewModelFactory implements ViewModelProvider.Factory {
    private final GetPopularMovies getPopularMoviesUseCase;

    public HomeViewModelFactory(GetPopularMovies getPopularMoviesUseCase) {
        this.getPopularMoviesUseCase = getPopularMoviesUseCase;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(HomeViewModel.class)) {
            return (T) new HomeViewModel(getPopularMoviesUseCase);
        }
        throw new IllegalArgumentException("Unknown ViewModel class " + modelClass);
    }
}
