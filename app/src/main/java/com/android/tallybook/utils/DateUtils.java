package com.android.tallybook.utils;

import android.annotation.SuppressLint;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    private static SimpleDateFormat sf;

    /**
     * 获取系统时间 格式为："yyyy/MM/dd "
     **/
    @SuppressLint("SimpleDateFormat")
    public static String getCurrentDate() {
        Date d = new Date();
        sf = new SimpleDateFormat("yyyy-MM-dd");
        return sf.format(d);
    }

    /**
     * 时间格式转化 20210911为："yyyy-MM-dd "
     * @param string
     * @return
     * @throws ParseException
     */
    @SuppressLint("SimpleDateFormat")
    public static String getDateFormat(String string) throws ParseException {
        if ("".equals(string)){
            return "";
        }
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        Date date = df.parse(string);
        DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
        assert date != null;
        return df2.format(date);
    }
    @SuppressLint("SimpleDateFormat")
    public static String getDateFormatForC(String string) throws ParseException {
        if ("".equals(string)){
            return "";
        }
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        Date date = df.parse(string);
        DateFormat df2 = new SimpleDateFormat("yyyy年MM月dd日");
        assert date != null;
        return df2.format(date);
    }
    /**
     * 获取系统时间 格式为："yyyy "
     **/
    @SuppressLint("SimpleDateFormat")
    public static String getCurrentYear() {
        Date d = new Date();
        sf = new SimpleDateFormat("yyyy");
        return sf.format(d);
    }

    /**
     * 获取系统时间 格式为："MM"
     **/
    @SuppressLint("SimpleDateFormat")
    public static String getCurrentMonth() {
        Date d = new Date();
        sf = new SimpleDateFormat("MM");
        return sf.format(d);
    }

    /**
     * 获取系统时间 格式为："dd"
     **/
    @SuppressLint("SimpleDateFormat")
    public static String getCurrentDay() {
        Date d = new Date();
        sf = new SimpleDateFormat("dd");
        return sf.format(d);
    }
    public static String getHour(){
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        return ""+hour+minute+second;
    }
    /**
     * 获取当前时间戳 * * @return
     */
    public static long getCurrentTime() {
        long d = new Date().getTime() / 1000;
        return d;
    }

}
