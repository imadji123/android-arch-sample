package com.imadji.arch.sample.feature.home;

import com.imadji.arch.domain.entity.Movie;
import com.imadji.arch.sample.common.ResultState;

import java.util.List;

/**
 * Created by imadji on 06/20/2019.
 */

class HomeViewState extends ResultState<List<Movie>> {

    public HomeViewState() {
        super();
    }

    public HomeViewState(boolean showLoading) {
        super(showLoading);
    }

    public HomeViewState(boolean showLoading, List<Movie> movies) {
        super(showLoading, movies);
    }
}
