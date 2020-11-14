package com.example.konkor.helper;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.konkor.models.User;

public class SessionManager {
    SharedPreferences mPreferences;
    SharedPreferences.Editor mEditor;
    public static  final String USER_PREF_NAME = "user_pref";
    public static final String IS_LOGGED_IN_KEY = "is_logged_in";
    public static final String USER_NAME_KEY ="user_name";

    public SessionManager(Context context) {
        this.mPreferences = context.getSharedPreferences(USER_PREF_NAME,Context.MODE_PRIVATE);
        this.mEditor = mPreferences.edit();
    }

    public void saveData(User user){
        mEditor.putBoolean(IS_LOGGED_IN_KEY, true);
        mEditor.putString(USER_NAME_KEY, user.getUserName());
        mEditor.commit();
    }

    public Boolean sessionExist(){
        return mPreferences.getBoolean(IS_LOGGED_IN_KEY, false);
    }

    public void clearSession(){
        mEditor.clear();
        mEditor.putBoolean(IS_LOGGED_IN_KEY, false);
        mEditor.commit();
    }
}
