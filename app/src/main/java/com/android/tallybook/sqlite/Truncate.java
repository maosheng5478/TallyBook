package com.android.tallybook.sqlite;

import android.database.sqlite.SQLiteDatabase;

public class Truncate {

    /**
     * 清除表数据
     * @param db
     * @param TABLE_NAME
     */
    public static void getInstance(SQLiteDatabase db,String TABLE_NAME){
        String sql = "DELETE FROM " +TABLE_NAME +";";
        db.execSQL(sql);
        revertSeq(db,TABLE_NAME);
        db.close();
    }

    /**
     *还原指定表的自增长
     * @param db
     * @param TABLE_NAME
     */
    public static void revertSeq(SQLiteDatabase db,String TABLE_NAME) {
        String sql = "update sqlite_sequence set seq=0 where name='"+TABLE_NAME+"'";
        db.execSQL(sql);
    }

    /**
     * 还原自增长
     * @param db
     */
    public static void revertSeq(SQLiteDatabase db) {
        String sql = "update sqlite_sequence set seq=0 ";
        db.execSQL(sql);
    }
}
