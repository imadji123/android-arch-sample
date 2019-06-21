package com.imadji.arch.data.source.remote;

import com.imadji.arch.data.entity.MovieData;
import com.imadji.arch.data.mapper.MovieDataMapper;
import com.imadji.arch.data.source.MovieDataSource;
import com.imadji.arch.data.source.remote.api.TmdbApi;
import com.imadji.arch.domain.model.Movie;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;

/**
 * Created by imadji on 06/14/2019.
 */

public class RemoteMovieDataSource implements MovieDataSource {
    private final TmdbApi tmdbApi;

    private final MovieDataMapper movieDataMapper = new MovieDataMapper();

    public RemoteMovieDataSource(TmdbApi tmdbApi) {
        this.tmdbApi = tmdbApi;
    }

    @Override
    public Single<List<Movie>> getPopularMovies() {
        return tmdbApi.getPopularMovies()
                .map(movieListResponse -> {
                    List<Movie> movies= new ArrayList<>();
                    for (MovieData movie : movieListResponse.getMovieList()) {
                        movies.add(movieDataMapper.mapFrom(movie));
                    }
                    return movies;
                });
    }
}
