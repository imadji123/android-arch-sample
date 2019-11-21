package com.imadji.arch.data.source.cache;

import com.imadji.arch.domain.entity.Movie;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

/**
 * Created by imadji on 06/14/2019.
 */

public interface MovieCache {

    boolean isEmpty();
    boolean isExpired();
    Completable clear();
    Completable saveAll(List<Movie> movies);
    Single<List<Movie>> getAll();

}
