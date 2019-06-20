package com.imadji.arch.sample;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.imadji.arch.sample.feature.home.HomeFragment;

/**
 * Created by imadji on 06/20/2019.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, new HomeFragment())
                    .commitNow();
        }
    }
}
