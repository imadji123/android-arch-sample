package com.imadji.arch.sample.feature.home;

import androidx.lifecycle.MutableLiveData;

import com.imadji.arch.domain.usecase.GetPopularMovies;
import com.imadji.arch.sample.common.BaseViewModel;
import com.imadji.arch.sample.common.SingleLiveEvent;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by imadji on 06/20/2019.
 */

public class HomeViewModel extends BaseViewModel {
    private final GetPopularMovies getPopularMovies;

    MutableLiveData<HomeViewState> viewState = new MutableLiveData<>();
    SingleLiveEvent<Throwable> errorState = new SingleLiveEvent<>();

    {
        viewState.setValue(new HomeViewState());
    }

    public HomeViewModel(GetPopularMovies getPopularMovies) {
        this.getPopularMovies = getPopularMovies;
    }

    public void getPopularMovies() {
        addDisposable(getPopularMovies.execute()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(movies -> {
                    HomeViewState newState = new HomeViewState(false, movies);
                    viewState.setValue(newState);
                    errorState.setValue(null);
                }, throwable -> {
                    viewState.setValue(new HomeViewState(false));
                    errorState.setValue(throwable);
                }));
    }
}
