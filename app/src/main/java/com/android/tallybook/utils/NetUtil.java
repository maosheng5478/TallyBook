package com.android.tallybook.utils;

import android.content.Context;
import android.net.ConnectivityManager;

import com.android.tallybook.MyApplication;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetUtil {

    public static String loginOfGet(String username,String password){
        HttpURLConnection conn=null;
        String myurl = "http://29zb223266.qicp.vip//AndroidApplication/DailyTest?";
        try {
            String data="username="+username+"&password="+password;
            URL url=new URL(myurl+data);
            conn=(HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(10000);
            conn.setReadTimeout(5000);
            conn.connect();
            int code=conn.getResponseCode();
            if(code==200){
                InputStream is=conn.getInputStream();
                String state=getStringFromInputStream(is);
                return state;
            }


        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(conn!=null){
                conn.disconnect();
            }
        }


        return null;
    }

    /**
     * 根据输入流返回一个字符串
     * @param is
     * @throws Exception
     */
    private static String getStringFromInputStream(InputStream is) throws Exception{

        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        byte[] buff=new byte[1024];
        int len=-1;
        while((len=is.read(buff))!=-1){
            baos.write(buff, 0, len);
        }
        is.close();
        String html=baos.toString();
        baos.close();


        return html;
    }

}
