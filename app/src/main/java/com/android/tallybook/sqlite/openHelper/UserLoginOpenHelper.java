package com.android.tallybook.sqlite.openHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class UserLoginOpenHelper extends SQLiteOpenHelper {

    private static String name = "tallybook.db";
    private static Integer version = 1;

    public UserLoginOpenHelper(@Nullable Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table users(id integer primary key autoincrement," +
                "account varchar(20),password varchar(20))");//varchar(20) not null
        //初始化数据库，插入管理员
        db.execSQL("insert into users(account,password) values('admin','123456')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
