package com.imadji.arch.data.source.cache;

import com.imadji.arch.data.source.local.preference.Preferences;
import com.imadji.arch.domain.model.Movie;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public class MemoryMovieCache implements MovieCache {
    private static final long EXPIRATION_TIME = (60 * 5 * 1000);

    private Preferences preferences;

    private List<Movie> cachedMovies = new ArrayList<>();

    public MemoryMovieCache(Preferences preferences) {
        this.preferences = preferences;
    }

    @Override
    public boolean isEmpty() {
        return cachedMovies.isEmpty();
    }

    @Override
    public boolean isExpired() {
        long currentTime = System.currentTimeMillis();
        long lastUpdateTime = preferences.getLastCacheTime();
        return currentTime - lastUpdateTime > EXPIRATION_TIME;
    }

    @Override
    public Completable clear() {
        cachedMovies.clear();
        return Completable.complete();
    }

    @Override
    public Completable saveAll(List<Movie> movies) {
        cachedMovies.clear();
        cachedMovies.addAll(movies);
        preferences.setLastCacheTime(System.currentTimeMillis());
        return Completable.complete();
    }

    @Override
    public Single<List<Movie>> getAll() {
        return Single.just(cachedMovies);
    }
}
