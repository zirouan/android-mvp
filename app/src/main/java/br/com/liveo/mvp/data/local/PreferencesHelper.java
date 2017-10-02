package br.com.liveo.mvp.data.local;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.lang.ref.WeakReference;

public class PreferencesHelper {

    private WeakReference<Context> mContext;

    public PreferencesHelper(WeakReference<Context> context) {
        this.mContext = context;
    }

    private void putString(String key, String value) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext.get());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    private String getString(String key) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext.get());
        return sharedPreferences.getString(key, null);
    }
}
