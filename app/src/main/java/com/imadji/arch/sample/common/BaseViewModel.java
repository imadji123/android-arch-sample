package com.imadji.arch.sample.common;

import androidx.lifecycle.ViewModel;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by imadji on 06/20/2019.
 */

public class BaseViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    protected void addDisposable(Disposable disposable) {
        compositeDisposable.add(disposable);
    }

    @Override
    protected void onCleared() {
        clearDisposables();
    }

    private void clearDisposables() {
        compositeDisposable.clear();
    }
}
