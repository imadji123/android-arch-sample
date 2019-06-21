package com.imadji.arch.sample.feature.home;

import androidx.lifecycle.ViewModelProviders;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.imadji.arch.sample.BuildConfig;
import com.imadji.arch.sample.MainApplication;
import com.imadji.arch.sample.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by imadji on 06/20/2019.
 */

public class HomeFragment extends Fragment {

    @Inject
    HomeViewModelFactory viewModelFactory;

    @BindView(R.id.rootView)
    RelativeLayout relativeLayout;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    private Activity activity;
    private HomeViewModel viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((MainApplication) activity.getApplication()).createHomeComponent().inject(this);
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(HomeViewModel.class);

        if (savedInstanceState == null) {
            viewModel.getPopularMovies();
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        textView.setText(String.format(getString(R.string.app_version), BuildConfig.VERSION_NAME));

        viewModel.viewState.observe(this, homeViewState -> {
            if (homeViewState != null) handleViewState(homeViewState);
        });

        viewModel.errorState.observe(this, throwable -> {
            if (throwable != null) showSnackbar(throwable.getMessage());
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        activity = null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ((MainApplication) activity.getApplication()).releaseHomeComponent();
    }

    private void handleViewState(HomeViewState homeViewState) {
        showProgressBar(homeViewState.showLoading);
        if (homeViewState.data != null) showSnackbar("Popular Movies: " + homeViewState.data.size());
    }

    private void showProgressBar(boolean isLoading) {
        if (isLoading) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }

    private void showSnackbar(String message) {
        Snackbar.make(relativeLayout, message, Snackbar.LENGTH_LONG).show();
    }
}
