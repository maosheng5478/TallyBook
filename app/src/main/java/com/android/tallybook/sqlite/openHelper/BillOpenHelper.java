package com.android.tallybook.sqlite.openHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.android.tallybook.utils.LogUtils;

public class BillOpenHelper extends SQLiteOpenHelper {
    private static String name = "tallybook.db";
    private static Integer version = 1;

    public BillOpenHelper(@Nullable Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table bills(id integer primary key autoincrement," +
                "billname varchar(20) not null,cost varchar(20) not null,flow varchar(20),time varchar(20),remarks varcahr(100))");
       /* varchar(20) not null
        billname 账单类型
        cost     花费金额
        flow     收入/支出
        time     时间
        remarks  备注说明*/
        db.execSQL("insert into bills(billname,cost,flow,time) values('日常','100.00','支出','20210320')");
        db.execSQL("insert into bills(billname,cost,flow,time) values('餐饮','100.22','支出','20210320')");
        db.execSQL("insert into bills(billname,cost,flow,time) values('工资','200','收入','20210329')");
        db.execSQL("insert into bills(billname,cost,flow,time) values('日常','130.45','支出','20210401')");
        db.execSQL("insert into bills(billname,cost,flow,time) values('游乐园','103.22','支出','20210401')");
        db.execSQL("insert into bills(billname,cost,flow,time) values('兼职','20.00','收入','20210402')");
        db.execSQL("insert into bills(billname,cost,flow,time) values('水果','10.30','支出','20210403')");
        db.execSQL("insert into bills(billname,cost,flow,time) values('文具','20.42','支出','20210404')");
        db.execSQL("insert into bills(billname,cost,flow,time) values('奖金','225.43','收入','20210404')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
