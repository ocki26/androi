package com.example.myapplication.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DpHelper extends SQLiteOpenHelper {
    // day se la noi dinh nghia va tao ra cac co so du lieu
    private static final String LOG = DpHelper.class.getName();//lay ten class lam luon
    //tao ten bang co so du lieu
    protected static final String DB_NAME = "campus.db";
    protected  static final int DB_VERSION = 1;
    //ten bang csddl
    protected  static final String Table_User ="user";
    // ten cac cot trong bang csdl
    protected static  final  String COL_ID = "id";
    protected static  final  String COL_USERNAME = "username";
    protected static  final  String COL_PASSWORD = "password";
    protected static  final  String COL_EMAIL = "email";
    protected static  final  String COL_PHONE = "phone";
    protected static  final  String COL_ROLE = "role";
    protected static  final  String COL_CREATED_AT = "created_at";
    protected static  final  String COL_UPDATED_AT = "updated_at";
    private static final String CREATE_TABLE_USER = "CREATE TABLE "+
            Table_User+
            " ( " + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
            COL_USERNAME+" VARCHAR(50) NOT NULL, "+
            COL_PASSWORD+" VARCHAR(200) NOT NULL, "+
            COL_EMAIL+" VARCHAR(60) NOT NULL, "+
            COL_PHONE+" VARCHAR(20), "+
            COL_ROLE+" INTEGER NOT NULL, "+
            COL_CREATED_AT+" DATETIME, "+
            COL_UPDATED_AT+" DATETIME ) ";

    public DpHelper(@Nullable Context context) {
        super(context, DB_NAME,null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_TABLE_USER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABlE IF EXISTS "+Table_User);
            //xoa bo cac bang neu loi va tao lai bang
            onCreate(db);
    }
}
