package com.imadji.arch.domain.model;

public class Movie {
    private long id;
    private String title;
    private String posterUrl;

    public Movie(long id, String title, String posterUrl) {
        this.id = id;
        this.title = title;
        this.posterUrl = posterUrl;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPosterUrl() {
        return posterUrl;
    }
}
