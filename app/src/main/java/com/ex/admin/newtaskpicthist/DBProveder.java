package com.ex.admin.newtaskpicthist;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;

/**
 * Created by Admin on 24.02.2018.
 */

public class DBProveder extends ContentProvider {


    static final String DB_NAME = "mydb";
    static final String IMAGE_TABLE = "dateImage";


    static final String IMAGE_ID = "_id";
    static final String IMAGE_URL = "urlImage";
    static final String IMAGE_TIME = "timeImage";
    static final String IMAGE_STATUS = "statusImage";

    static final String DB_CREATE = "create table " + IMAGE_TABLE + "("
            + IMAGE_ID + " integer primary key autoincrement, "
            + IMAGE_URL + " text, " + IMAGE_STATUS + " text, " + IMAGE_TIME + " text" + ");";

    static final String AUTHORITY = "task.ImageLooker";

    static final String CONTACT_PATH = "dateImage";

    public static final Uri IMAGE_CONTENT_URI = Uri.parse("content://"
            + AUTHORITY + "/" + CONTACT_PATH);


    DBHelper dbHelper;
    SQLiteDatabase db;

    @Override
    public boolean onCreate() {
        dbHelper = new DBHelper(getContext());
        return true;
    }


    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, @Nullable String sortOrder) {


        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query(IMAGE_TABLE, projection, selection,
                selectionArgs, null, null, sortOrder);
        cursor.setNotificationUri(getContext().getContentResolver(),
                IMAGE_CONTENT_URI);
        return cursor;
    }


    @Override
    public String getType(Uri uri) {
        return null;
    }


    @Override
    public Uri insert(Uri uri, ContentValues values) {

        db = dbHelper.getWritableDatabase();
        long rowID = db.insert(IMAGE_TABLE, null, values);
        Uri resultUri = ContentUris.withAppendedId(IMAGE_CONTENT_URI, rowID);
        getContext().getContentResolver().notifyChange(resultUri, null);
        return resultUri;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        String [] id = {uri.getLastPathSegment()};

        selection = "_id=?";
        db = dbHelper.getWritableDatabase();
        db.delete(IMAGE_TABLE, selection, id);
        getContext().getContentResolver().notifyChange(uri, null);
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        String id = uri.getLastPathSegment();
        selection = IMAGE_ID + " = " + id;

        db = dbHelper.getWritableDatabase();
        db.update(IMAGE_TABLE, values, selection, selectionArgs);
        getContext().getContentResolver().notifyChange(uri, null);
        return 0;
    }

    private class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context) {
            super(context, DB_NAME, null, 1);
        }

        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DB_CREATE);

        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
    }
}


