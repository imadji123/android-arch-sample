package com.imadji.arch.data.source.local.preference;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesHelper implements Preferences {
    private static final String PREF_NAME = "com.imadji.arch.sample.cache.preferences";
    private static final String PREF_KEY_LAST_CACHE_TIME = "last_cache_time";

    private SharedPreferences sharedPreferences;

    public PreferencesHelper(Context context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    @Override
    public void setLastCacheTime(long lastCacheTime) {
        writeLong(PREF_KEY_LAST_CACHE_TIME, lastCacheTime);
    }

    @Override
    public long getLastCacheTime() {
        return readLong(PREF_KEY_LAST_CACHE_TIME, 0);
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
}
