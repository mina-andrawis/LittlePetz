package edu.fsu.cs.littlepetz;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.widget.Toast;

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

    private MainDatabaseHelper mOpenHelper;

    private static final String SQL_CREATE_MAIN = "CREATE TABLE " +
            TABLE_NAME +  // Table's name
            "(" +               // The columns in the table
            " _ID INTEGER PRIMARY KEY, " +
            COLUMN_PETNAME +
            " TEXT," +
            COLUMN_PETTYPE +
            " TEXT)";


    @Override
    //This method is called when the provider is started.
    public boolean onCreate() {
        mOpenHelper = new MainDatabaseHelper(getContext());

        return false;
    }

    @Nullable
    @Override
    //This method receives a request from a client. The result is returned as a Cursor object.
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {

        Cursor c = mOpenHelper.getReadableDatabase().query(TABLE_NAME, projection, selection, selectionArgs,
        null, null, sortOrder);

        //doesnt exist
        if (c.getCount() == 0)
        {
            Toast.makeText(getContext(), "This friend is not found!", Toast.LENGTH_LONG).show();
            return null;
        }

        return c;
    }

    @Nullable
    @Override
    //This method returns the MIME type of the data at the given URI.
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    //This method inserts a new record into the content provider.
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {

        String pet_type = values.getAsString(COLUMN_PETTYPE);
        String pet_name = values.getAsString(COLUMN_PETNAME);

        if (pet_type.equals(""))
            return null;

        if (pet_name.equals(""))
            return null;

        long id = mOpenHelper.getWritableDatabase().insert(TABLE_NAME, null, values);

        return Uri.withAppendedPath(CONTENT_URI, "" + id);
    }

    @Override
    //This method deletes an existing record from the content provider
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    // This method updates an existing record from the content provider.
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    protected static final class MainDatabaseHelper extends SQLiteOpenHelper {
        MainDatabaseHelper(Context context) {
            super(context, DBNAME, null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(SQL_CREATE_MAIN);
        }

        @Override
        public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        }
    }


}
