package br.team.wtb.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import androidx.appcompat.app.AppCompatDelegate;

public class ThemeManager {

    private static final String PREFS_NAME = "theme_prefs";
    private static final String THEME_KEY = "theme_mode";
    private static final int LIGHT_MODE = 1;
    private static final int DARK_MODE = 2;

    private SharedPreferences sharedPreferences;

    public ThemeManager(Context context) {
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    public void switchTheme() {
        int currentTheme = sharedPreferences.getInt(THEME_KEY, DARK_MODE);
        if (currentTheme == DARK_MODE) {
            setTheme(LIGHT_MODE);
        } else {
            setTheme(DARK_MODE);
        }
    }

    public void setTheme(int themeMode) {
        if (themeMode == LIGHT_MODE) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            saveThemePreference(LIGHT_MODE);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            saveThemePreference(DARK_MODE);
        }
    }

    private void saveThemePreference(int themeMode) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(THEME_KEY, themeMode);
        editor.apply();
    }

    public boolean isNightMode() {
        int currentTheme = sharedPreferences.getInt(THEME_KEY, DARK_MODE);
        return currentTheme == DARK_MODE;
    }
}
