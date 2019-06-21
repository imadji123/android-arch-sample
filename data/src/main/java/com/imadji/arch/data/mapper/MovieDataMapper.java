package com.imadji.arch.data.mapper;

import com.imadji.arch.data.entity.MovieData;
import com.imadji.arch.domain.common.Mapper;
import com.imadji.arch.domain.model.Movie;

/**
 * Created by imadji on 06/21/2019.
 */

public class MovieDataMapper extends Mapper<MovieData, Movie> {
    private static final String POSTER_BASE_URL = "https://image.tmdb.org/t/p/w342";

    @Override
    public Movie mapFrom(MovieData from) {
        return new Movie(from.id, from.title, POSTER_BASE_URL + from.posterPath);
    }
}
