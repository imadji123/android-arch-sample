package com.imadji.arch.data.datasource.remote.response;

import com.google.gson.annotations.SerializedName;
import com.imadji.arch.domain.model.Movie;

import java.util.List;

public class MovieListResponse {

    @SerializedName("page")
    private int page;
    @SerializedName("total_results")
    private int totalResults;
    @SerializedName("total_pages")
    private int totalPages;
    @SerializedName("results")
    private List<Movie> movieList;

    public int getPage() {
        return page;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

}
