package br.team.wtb.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MovieDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "movies.db";
    private static final int DATABASE_VERSION = 1;

    private static final String CREATE_TABLE_MOVIES =
            "CREATE TABLE movies (" +
                    "posterImgResId INTEGER, " +
                    "movieName TEXT PRIMARY KEY, " +
                    "movieYear INTEGER, " +
                    "movieRating INTEGER, " +
                    "isFavorite INTEGER, " +
                    "movieTrailerLink TEXT);";

    public MovieDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_MOVIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS movies");
        onCreate(db);
    }
}
