package edu.fsu.cs.littlepetz;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


// ADAPTED FROM CONTENT PROVIDER CLASS EXAMPLE //


public class FriendProvider extends ContentProvider {

    public final static String DBNAME = "FriendDatabase";
    public final static String TABLE_NAME = "friendstable";
    public final static String COLUMN_PETNAME = "petname";
    public final static String COLUMN_PETTYPE = "pettype";

    public static final String AUTHORITY = "edu.fsu.cs.littlepetz.provider";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + TABLE_NAME);

    private static UriMatcher sUriMatcher;

    //private MainDatabaseHelper mOpenHelper;

    @Override
    public boolean onCreate() {
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
