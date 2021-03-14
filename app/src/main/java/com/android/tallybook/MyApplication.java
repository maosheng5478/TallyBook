package com.android.tallybook;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.android.tallybook.mvp.view.WelcomeActivity;

import cat.ereza.customactivityoncrash.CustomActivityOnCrash;
import cat.ereza.customactivityoncrash.config.CaocConfig;

public class MyApplication extends Application {
    private static Context mContext;

    @SuppressLint("RestrictedApi")
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();

        //整个配置属性，可以设置一个或多个，也可以一个都不设置
        CaocConfig.Builder.create()
                //程序在后台时，发生崩溃的三种处理方式
                //BackgroundMode.BACKGROUND_MODE_SHOW_CUSTOM: //当应用程序处于后台时崩溃，也会启动错误页面，
                //BackgroundMode.BACKGROUND_MODE_CRASH:      //当应用程序处于后台崩溃时显示默认系统错误（一个系统提示的错误对话框），
                //BackgroundMode.BACKGROUND_MODE_SILENT:     //当应用程序处于后台时崩溃，默默地关闭程序！
                .backgroundMode(CaocConfig.BACKGROUND_MODE_SILENT)
                .enabled(true)     //false表示对崩溃的拦截阻止。用它来禁用customactivityoncrash框架
                .showErrorDetails(false) //这将隐藏错误活动中的“错误详细信息”按钮，从而隐藏堆栈跟踪,—》针对框架自带程序崩溃后显示的页面有用(DefaultErrorActivity)。。
                .showRestartButton(false)    //是否可以重启页面,针对框架自带程序崩溃后显示的页面有用(DefaultErrorActivity)。
                .trackActivities(true)     //错误页面中显示错误详细信息；针对框架自带程序崩溃后显示的页面有用(DefaultErrorActivity)。
                .minTimeBetweenCrashesMs(2000)      //定义应用程序崩溃之间的最短时间，以确定我们不在崩溃循环中。比如：在规定的时间内再次崩溃，框架将不处理，让系统处理！
                .errorDrawable(R.mipmap.ic_launcher)     //崩溃页面显示的图标
                .restartActivity(WelcomeActivity.class)      //重新启动后的页面
                //.errorActivity(.class) //程序崩溃后显示的页面
                .eventListener(new CustomEventListener())//设置监听
                .apply();
        //如果没有任何配置，程序崩溃显示的是默认的设置
        CustomActivityOnCrash.install(this);
    }

    /**
     *customactivityoncrash框架监听
     */
    private static class CustomEventListener implements CustomActivityOnCrash.EventListener {
        //程序崩溃回调
        @Override
        public void onLaunchErrorActivity() {
            Log.d("huangxiaoguo", "程序崩溃回调");
        }

        //重启程序时回调
        @Override
        public void onRestartAppFromErrorActivity() {
            Log.d("huangxiaoguo", "重启程序时回调");
        }

        //在崩溃提示页面关闭程序时回调
        @Override
        public void onCloseAppFromErrorActivity() {
            Log.d("huangxiaoguo", "在崩溃提示页面关闭程序时回调");
        }

    }

    /**
     * 创建一个静态的方法，以便获取context对象
     * @return 返回context对象
     */
    public static Context getContext(){
        return mContext;
    }
}
