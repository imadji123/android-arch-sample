package com.imadji.arch.data.source.remote.response;

import com.google.gson.annotations.SerializedName;
import com.imadji.arch.data.entity.MovieData;

import java.util.List;

/**
 * Created by imadji on 06/10/2019.
 */

public class MovieListResponse {

    @SerializedName("page")
    private int page;
    @SerializedName("total_results")
    private int totalResults;
    @SerializedName("total_pages")
    private int totalPages;
    @SerializedName("results")
    private List<MovieData> movieList;

    public int getPage() {
        return page;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public List<MovieData> getMovieList() {
        return movieList;
    }

}
