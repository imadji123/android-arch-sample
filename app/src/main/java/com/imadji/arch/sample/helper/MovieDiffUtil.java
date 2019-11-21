package com.imadji.arch.sample.helper;

import androidx.recyclerview.widget.DiffUtil;

import com.imadji.arch.domain.entity.Movie;

import java.util.List;

/**
 * Created by imadji on 06/21/2019.
 */

public class MovieDiffUtil extends DiffUtil.Callback {
    private List<Movie> oldList;
    private List<Movie> newList;

    public MovieDiffUtil(List<Movie> oldList, List<Movie> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).getId() == newList.get(newItemPosition).getId();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).equals(newList.get(newItemPosition));
    }
}
