package com.android.tallybook.sqlite.dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
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
        Cursor cursor = db.rawQuery("select * from bills order by time DESC", null);
        while (cursor.moveToNext()){
            list.add(addtolist(cursor));
        }
        return list;
    }

    /**
     * 模糊查询，用于搜索
     * @return
     */
    public List<BillBean> blurredQury(String temp){
        List<BillBean> list = new ArrayList<>();
        String sql = "select * from bills where billname like '%"+temp+"%' or cost like '%"+temp
                +"%' or flow like '%"+temp+"%' or time like '%"+temp+"%'";
        @SuppressLint("Recycle")
        Cursor cursor = db.query(TABLE_NAME,null,"billname like ? or cost like ? or flow like ? or time like ?",
                new String[]{"%"+temp+"%","%"+temp+"%","%"+temp+"%","%"+temp+"%"},null,null," time DESC, id DESC");
        while (cursor.moveToNext()){
            list.add(addtolist(cursor));
        }
        System.out.println(list);
        return list;
    }

    /**
     * 查询收入的账单
     * @return
     */
    public List<BillBean> income(){
        List<BillBean> list = new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from bills where flow = '收入' order by cast(cost as int) DESC", null);
        while (cursor.moveToNext()){
            list.add(addtolist(cursor));
        }
        return list;
    }

    /**
     * 查询支出的账单
     * @return
     */
    public List<BillBean> expenses(){
        List<BillBean> list = new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from bills where flow = '支出' group by time order by cast(cost as int) ASC", null);
        while (cursor.moveToNext()){
            list.add(addtolist(cursor));
        }
        return list;
    }

    public int deletBill(int id){
        return db.delete("bills","id=?",new String[]{String.valueOf(id)});
    }

    public int insertBill(BillBean bean){
        return (int) db.insert("bills",null,adddata(bean));
    }

    public int updateBill(BillBean bean){
        return db.update("bills",adddata(bean),"id=?",new String[]{String.valueOf(bean.getId())});
    }

    /**
     * 清空表数据
     */
    public void emptyBill(){
        Truncate.getInstance(db,TABLE_NAME);
        db.close();
    }

    private BillBean addtolist(Cursor cursor){
        BillBean billBean = new BillBean();
        billBean.setId(cursor.getInt(cursor.getColumnIndex("id")));
        billBean.setBillname(cursor.getString(cursor.getColumnIndex("billname")));
        billBean.setCost(cursor.getString(cursor.getColumnIndex("cost")));
        billBean.setFlow(cursor.getString(cursor.getColumnIndex("flow")));
        billBean.setTime(cursor.getString(cursor.getColumnIndex("time")));
        billBean.setRemarks(cursor.getString(cursor.getColumnIndex("remarks")));
        return billBean;
    }

    private ContentValues adddata(BillBean bean){
        ContentValues values = new ContentValues();
        values.put("billname",bean.getBillname());
        values.put("cost",bean.getCost());
        values.put("flow",bean.getFlow());
        values.put("time",bean.getTime());
        values.put("remarks",bean.getRemarks());
        return values;
    }

}
