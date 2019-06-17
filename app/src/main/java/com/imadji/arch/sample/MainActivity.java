package com.imadji.arch.sample;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "coba-rx";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, BuildConfig.VERSION_NAME, Toast.LENGTH_SHORT).show();

        Observable.just(1, 2, 3, 4, 5)
                .subscribeOn(Schedulers.io())
                .doOnNext(integer -> Log.d(TAG, "Emitting item on: " + Thread.currentThread().getName()))
                .map(integer -> {
                    Log.d(TAG, "Processing item on: " + Thread.currentThread().getName());
                    return integer * 2;
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<Integer>() {
                    @Override
                    public void onNext(@NonNull Integer integer) {
                        Log.d(TAG, "Consuming item " + integer + " on: " + Thread.currentThread().getName());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
