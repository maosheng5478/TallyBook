package com.android.tallybook.sqlite.dao;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.android.tallybook.sqlite.openHelper.BillOpenHelper;
import com.android.tallybook.sqlite.openHelper.UserLoginOpenHelper;

public class BillDao {
    private SQLiteDatabase db;
    private BillOpenHelper helper;

    public BillDao(Context context){
        helper = new BillOpenHelper(context);
        db = helper.getReadableDatabase();
    }

    public boolean singleBill(String account,String password){
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery("select * from users where account = ? and password = ?", new String[]{account,password});
        return cursor.moveToNext();
    }
}
