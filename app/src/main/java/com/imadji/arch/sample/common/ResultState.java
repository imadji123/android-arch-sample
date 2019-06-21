package com.imadji.arch.sample.common;

/**
 * Created by imadji on 06/20/2019.
 */

public class ResultState<T> {
    public boolean showLoading;
    public T data;

    public ResultState() {
        this(true, null);
    }

    public ResultState(boolean showLoading) {
        this(showLoading, null);
    }

    public ResultState(boolean showLoading, T data) {
        this.showLoading = showLoading;
        this.data = data;
    }
}
