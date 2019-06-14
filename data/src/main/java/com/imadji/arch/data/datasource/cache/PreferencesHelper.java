package com.imadji.arch.data.datasource.cache;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesHelper {
    private static final String PREF_NAME = "com.imadji.arch.sample.cache.preferences";
    private static final String PREF_KEY_LAST_CACHE_TIME = "last_cache_time";

    private static PreferencesHelper preferencesHelper;
    private SharedPreferences sharedPreferences;

    public PreferencesHelper(Context context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    private void writeString(String key, String value) {
        sharedPreferences
                .edit()
                .putString(key, value)
                .apply();
    }

    private String readString(String key, String defaultValue) {
        return sharedPreferences.getString(key, defaultValue);
    }

    private void writeInt(String key, int value) {
        sharedPreferences
                .edit()
                .putInt(key, value)
                .apply();
    }

    private int getInt(String key, int defaultValue) {
        return sharedPreferences.getInt(key, defaultValue);
    }

    private void writeLong(String key, long value) {
        sharedPreferences
                .edit()
                .putLong(key, value)
                .apply();
    }

    private long readLong(String key, long defaultValue) {
        return sharedPreferences.getLong(key, defaultValue);
    }

    private void writeBoolean(String key, boolean value) {
        sharedPreferences
                .edit()
                .putBoolean(key, value)
                .apply();
    }

    private boolean readBoolean(String key, boolean defaultValue) {
        return sharedPreferences.getBoolean(key, defaultValue);
    }

    public void setLastCacheTime(long lastCacheTime) {
        writeLong(PREF_KEY_LAST_CACHE_TIME, lastCacheTime);
    }

    public long getLastCacheTime() {
        return readLong(PREF_KEY_LAST_CACHE_TIME, 0);
    }
}
