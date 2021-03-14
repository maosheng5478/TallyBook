package com.android.tallybook.sqlite.dao;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.android.tallybook.sqlite.openHelper.UserLoginOpenHelper;

public class UserLoginDao {
    private SQLiteDatabase db;
    private UserLoginOpenHelper helper;

    public UserLoginDao(Context context){
        helper = new UserLoginOpenHelper(context);
        db = helper.getReadableDatabase();
    }

    public boolean hasUser(String account,String password){
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery("select * from users where account = ? and password = ?", new String[]{account,password});
        return cursor.moveToNext();
    }
}
