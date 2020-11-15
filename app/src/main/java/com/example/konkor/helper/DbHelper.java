package com.example.konkor.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.konkor.constant.UserDbContract;
import com.example.konkor.models.User;

public class DbHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "konkor.db";
    public static final int DATABASE_VERSION = 1;


    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UserDbContract.CREATE_USERS_TABLE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(UserDbContract.DROP_USERS_TABLE);
    }

}
