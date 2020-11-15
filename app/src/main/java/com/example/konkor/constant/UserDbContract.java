package com.example.konkor.constant;

public class UserDbContract {
    public static final String TABLE_NAME ="users";
    public static final String COLUMN_ID ="id";
    public static final String COLUMN_USER_NAME ="userName";
    public static final String COLUMN_EMAIL ="email";
    public static final String COLUMN_PASSWORD ="password";
    public static final String CREATE_USERS_TABLE_QUERY = "CREATE TABLE "+ TABLE_NAME  +
            "(" +COLUMN_ID + " int IDENTITY PRIMARY KEY, "+
            COLUMN_EMAIL + " varchar(128), " +
            COLUMN_USER_NAME + " varchar(68), "+
            COLUMN_PASSWORD + " varchar(128)"+
            ");";
    public static final String DROP_USERS_TABLE = "DROP TABLE IF EXIST " + TABLE_NAME;
}
