package com.android.tallybook.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;
import android.view.View;

public class StatusBarUtils {

    private Activity activity;
    public StatusBarUtils(Activity activity) {
        this.activity = activity;
    }
    public static StatusBarUtils with(Activity activity) {
        return new StatusBarUtils(activity);
    }
    /**
     * 利用反射获取状态栏高度
     *
     * @return
     */

    public static int getStatusBarHeight(Context context) {
        int result = 0;
        //获取状态栏高度的资源id
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        Log.e("getStatusBarHeight", result + "");
        return result;
    }
    public void setStatuImmersive(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            View decorView=activity.getWindow().getDecorView();
            int option=View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
            decorView.setSystemUiVisibility(option);
            activity.getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }
    public  StatusBarUtils setStyleBlack(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        return this;
    }
    public static void setStyleBlack(Activity activity){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
    }
}
