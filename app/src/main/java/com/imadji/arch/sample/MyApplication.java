package com.imadji.arch.sample;

import android.app.Application;
import android.content.Context;

/**
 * Created by imadji on 03/17/2019.
 */

public class MyApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        setContext(this);
    }

    public static void setContext(Context context) {
        MyApplication.context = context;
    }

    public static Context getContext() {
        return MyApplication.context;
    }

}
