package com.imadji.arch.data.source.cache;

import com.imadji.arch.data.source.cache.preference.PreferencesHelper;
import com.imadji.arch.domain.model.Movie;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public class MemoryMovieCache implements MovieCache {
    private static final long EXPIRATION_TIME = (60 * 10 * 1000);

    private PreferencesHelper preferencesHelper;

    private List<Movie> cachedMovies = new ArrayList<>();

    public MemoryMovieCache(PreferencesHelper preferencesHelper) {
        this.preferencesHelper = preferencesHelper;
    }

    @Override
    public boolean isEmpty() {
        return cachedMovies.isEmpty();
    }

    @Override
    public boolean isExpired() {
        long currentTime = System.currentTimeMillis();
        long lastUpdateTime = this.getLastCacheUpdateTimeMillis();
        return currentTime - lastUpdateTime > EXPIRATION_TIME;
    }

    @Override
    public void setLastCacheTime(long lastCacheTime) {
        preferencesHelper.setLastCacheTime(lastCacheTime);
    }

    @Override
    public Completable clear() {
        return Completable.defer(() -> {
            cachedMovies.clear();
            return Completable.complete();
        });
    }

    @Override
    public Completable saveAll(List<Movie> movies) {
        return Completable.defer(() -> {
            cachedMovies.clear();
            cachedMovies.addAll(movies);
            return Completable.complete();
        });
    }

    @Override
    public Single<List<Movie>> getAll() {
        return Single.just(cachedMovies);
    }

    private long getLastCacheUpdateTimeMillis() {
        return preferencesHelper.getLastCacheTime();
    }
}
