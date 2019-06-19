package com.imadji.arch.data.source.cache;

import com.imadji.arch.domain.model.Movie;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface MovieCache {

    boolean isEmpty();
    boolean isExpired();
    Completable clear();
    Completable saveAll(List<Movie> movies);
    Single<List<Movie>> getAll();

}
