package com.imadji.arch.sample.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.imadji.arch.domain.entity.Movie;
import com.imadji.arch.sample.R;
import com.imadji.arch.sample.helper.MovieDiffUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by imadji on 06/21/2019.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {

    private final OnMovieSelectedListener onMovieSelectedListener;
    private List<Movie> movieList = new ArrayList<>();

    public MoviesAdapter(OnMovieSelectedListener onMovieSelectedListener) {
        this.onMovieSelectedListener = onMovieSelectedListener;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie,
                parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie movie = movieList.get(position);
        holder.bind(movie, onMovieSelectedListener);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public void updateMovies(List<Movie> newMovieList) {
        MovieDiffUtil movieDiffUtil = new MovieDiffUtil(movieList, newMovieList);
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(movieDiffUtil);
        movieList.clear();
        movieList.addAll(newMovieList);
        diffResult.dispatchUpdatesTo(this);
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.poster)
        ImageView poster;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(Movie movie, OnMovieSelectedListener listener) {
            Glide.with(itemView)
                    .load(movie.getPosterUrl())
                    .into(poster);
            itemView.setOnClickListener(v -> listener.onMovieSelected(movie));
        }
    }

    public interface OnMovieSelectedListener {
        void onMovieSelected(Movie movie);
    }
}
