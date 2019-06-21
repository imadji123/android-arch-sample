package com.imadji.arch.data.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by imadji on 06/21/2019.
 */

public class MovieData {

    @SerializedName("id")
    @Expose
    public long id;

    @SerializedName("title")
    @Expose
    public String title;

    @SerializedName("original_title")
    @Expose
    public String originalTitle;

    @SerializedName("overview")
    @Expose
    public String overview;

    @SerializedName("release_date")
    @Expose
    public String releaseDate;

    @SerializedName("vote_average")
    @Expose
    public double voteAverage;

    @SerializedName("poster_path")
    @Expose
    public String posterPath;

    @SerializedName("backdrop_path")
    @Expose
    public String backdropPath;
}
