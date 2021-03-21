package com.android.tallybook.sqlite.openHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BillOpenHelper extends SQLiteOpenHelper {
    private static String name = "tallybook.db";
    private static Integer version = 1;

    public BillOpenHelper(@Nullable Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table bill(id integer primary key autoincrement," +
                "billname varchar(20) not null,cost double(16,2) not null,flow varchar(20),time varchar(20),remarks varcahr(100))");
       /* varchar(20) not null
        billname 账单类型
        cost     花费金额
        flow     收入/支出
        time     时间
        remarks  备注说明*/
        db.execSQL("insert into bill(billname,cost,flow,time) values('日常','100.00','支出','20210320')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
