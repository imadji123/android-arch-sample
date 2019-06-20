package com.imadji.arch.sample.feature.home;

import android.util.Log;

import com.imadji.arch.domain.usecase.GetPopularMovies;
import com.imadji.arch.sample.common.BaseViewModel;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by imadji on 06/20/2019.
 */

public class HomeViewModel extends BaseViewModel {
    private static final String TAG = HomeViewModel.class.getSimpleName();

    private final GetPopularMovies getPopularMovies;

    public HomeViewModel(GetPopularMovies getPopularMovies) {
        this.getPopularMovies = getPopularMovies;
    }

    public void getPopularMovies() {
        addDisposable(getPopularMovies.execute()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(movies -> Log.d(TAG, "Popular Movies: " + movies.size()),
                        throwable -> throwable.printStackTrace()));
    }
}
