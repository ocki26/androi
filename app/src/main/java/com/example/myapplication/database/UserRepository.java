package com.example.myapplication.database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class UserRepository extends DpHelper {
    public UserRepository(@Nullable Context context) {
        super(context);
    }
    //viet ham insert account  user
    public  long saveUserAccount(
            String username,
            String password,
            String email,
            String phone

    ){
        //lay ngay hien tai
        @SuppressLint({"NewApi", "LocalSuppress"}) DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss");
        @SuppressLint({"NewApi", "LocalSuppress"}) ZonedDateTime zoneDt = ZonedDateTime.now();
        @SuppressLint({"NewApi", "LocalSuppress"}) String currentDate = dtf.format(zoneDt);
        ContentValues values = new ContentValues();
        values.put(DpHelper.COL_USERNAME,username);//save data into COL USERNAME
        values.put(DpHelper.COL_PASSWORD,password);
        values.put(DpHelper.COL_EMAIL,email);
        values.put(DpHelper.COL_PHONE,phone);
        values.put(DpHelper.COL_ROLE,0);
        values.put(DpHelper.COL_CREATED_AT,currentDate);
        SQLiteDatabase db = getWritableDatabase();
        long insert = db.insert(DpHelper.Table_User,null,values);
        db.close();
        return insert;



    }

}
