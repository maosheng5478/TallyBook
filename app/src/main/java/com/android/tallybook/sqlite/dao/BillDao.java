package com.android.tallybook.sqlite.dao;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.android.tallybook.bean.BillBean;
import com.android.tallybook.sqlite.Truncate;
import com.android.tallybook.sqlite.openHelper.BillOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class BillDao {
    private SQLiteDatabase db;
    private BillOpenHelper helper;

    private static final String TABLE_NAME = "bills";

    private BillBean billBean = new BillBean();

    public BillDao(Context context){
        helper = new BillOpenHelper(context);
        db = helper.getReadableDatabase();
    }

    /**
     * 查询bills表中所有的数据
     * @return list
     */
    public List<BillBean> allBill(){
        List<BillBean> list = new ArrayList<BillBean>();
        @SuppressLint("Recycle")
        Cursor cursor = db.rawQuery("select * from bills", null);
        while (cursor.moveToNext()){
            billBean.setId(cursor.getInt(cursor.getColumnIndex("id")));
            billBean.setBillname(cursor.getString(cursor.getColumnIndex("billname")));
            billBean.setCost(cursor.getDouble(cursor.getColumnIndex("cost")));
            billBean.setFlow(cursor.getString(cursor.getColumnIndex("flow")));
            billBean.setTime(cursor.getString(cursor.getColumnIndex("time")));
            billBean.setRemarks(cursor.getString(cursor.getColumnIndex("remarks")));
            list.add(billBean);
        }
        return list;
    }

    /**
     * 模糊查询，用于搜索
     * @return
     */
    public List<BillBean> blurredQury(String temp){
        List<BillBean> list = new ArrayList<>();
        temp = "%"+temp+"%";
        @SuppressLint("Recycle")
        Cursor cursor = db.rawQuery("select * from bills where billname like '?' or cost like '?' or flow like ? or time like ? or remarks like ?",
                new String[]{temp,temp,temp,temp});
        while (cursor.moveToNext()){
            billBean.setId(cursor.getInt(cursor.getColumnIndex("id")));
            billBean.setBillname(cursor.getString(cursor.getColumnIndex("billname")));
            billBean.setCost(cursor.getDouble(cursor.getColumnIndex("cost")));
            billBean.setFlow(cursor.getString(cursor.getColumnIndex("flow")));
            billBean.setTime(cursor.getString(cursor.getColumnIndex("time")));
            billBean.setRemarks(cursor.getString(cursor.getColumnIndex("remarks")));
            list.add(billBean);
        }
        return list;
    }

    /**
     * 清空表数据
     */
    public void emptyBill(){
        Truncate.getInstance(db,TABLE_NAME);
        db.close();
    }




}
