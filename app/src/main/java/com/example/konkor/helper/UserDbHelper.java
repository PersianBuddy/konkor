package com.example.konkor.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.konkor.constant.UserDbContract;
import com.example.konkor.models.User;

public class UserDbHelper extends DbHelper {
    public UserDbHelper(@Nullable Context context) {
        super(context);
    }
    public boolean insertUser(User user){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(UserDbContract.COLUMN_EMAIL, user.getEmail());
        cv.put(UserDbContract.COLUMN_USER_NAME, user.getUserName());
        cv.put(UserDbContract.COLUMN_PASSWORD, user.getPassword());

        long rowAdded = db.insert(UserDbContract.TABLE_NAME, null,cv);
        if (rowAdded> 0) return true;
        return false;
    }

    public boolean emailExist(String email){
        SQLiteDatabase db = getReadableDatabase();
        String [] selectionArg = {email};
        String query = "SELECT * FROM " + UserDbContract.TABLE_NAME + " WHERE " +UserDbContract.COLUMN_EMAIL + "=?";
        Cursor cursor = db.rawQuery(query,selectionArg);
        if (cursor.moveToFirst()){
            return true;
        }
        return false;
    }
    public boolean userNameExist(String user_name){
        SQLiteDatabase db = getReadableDatabase();
        String [] selectionArg = {user_name};
        String query = "SELECT * FROM " + UserDbContract.TABLE_NAME + " WHERE " +UserDbContract.COLUMN_EMAIL + "=?";
        Cursor cursor = db.rawQuery(query,selectionArg);
        if (cursor.moveToFirst()){
            cursor.close();
            db.close();
            return true;
        }
        cursor.close();
        db.close();
        return false;
    }

    public User getUserByEmail(String email, String password){
        SQLiteDatabase db = getReadableDatabase();
        String [] selectionArgs = {email, password};
        String query = "SELECT * FROM " + UserDbContract.TABLE_NAME + " WHERE " +UserDbContract.COLUMN_EMAIL + "=? AND "+ UserDbContract.COLUMN_PASSWORD + "=?";
        Cursor cursor = db.rawQuery(query, selectionArgs);
        if (cursor.moveToFirst()){
            String tmp_email = cursor.getString(1);
            String tmp_user_name = cursor.getString(2);
            String tmp_password = cursor.getString(3);
            User user = new User(tmp_email, tmp_user_name, tmp_password);
            cursor.close();
            db.close();
            return user;
        }
        cursor.close();
        db.close();
        return null;
    }

    public User getUserByUserName(String userName, String password){
        SQLiteDatabase db = getReadableDatabase();
        String [] selectionArgs = {userName, password};
        String query = "SELECT * FROM " + UserDbContract.TABLE_NAME + " WHERE " +UserDbContract.COLUMN_USER_NAME + "=? AND "+ UserDbContract.COLUMN_PASSWORD + "=?";
        Cursor cursor = db.rawQuery(query, selectionArgs);
        if (cursor.moveToFirst()){
            String tmp_email = cursor.getString(1);
            String tmp_user_name = cursor.getString(2);
            String tmp_password = cursor.getString(3);
            User user = new User(tmp_email, tmp_user_name, tmp_password);
            cursor.close();
            db.close();
            return user;
        }
        cursor.close();
        db.close();
        return null;
    }
}
