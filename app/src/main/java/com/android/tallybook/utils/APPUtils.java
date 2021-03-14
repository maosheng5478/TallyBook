package com.android.tallybook.utils;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.util.LinkedList;
import java.util.List;

/**
 *获取app所对应的版本号
 */
public class APPUtils implements Application.ActivityLifecycleCallbacks{

    private static final LinkedList<Activity> mActivityList = new LinkedList<>();
    private static Application sApp;

    public static void init(final Application app) {
        if (app == null) {
            LogUtils.e("DensityUtil", "app is null.");
            return;
        }
        if (sApp == null) {
            sApp = app;
            init(sApp);
            AdaptScreenUtils.getPreLoadRunnable();
            return;
        }
        if (sApp.equals(app)) return;
        UtilsActivityLifecycleImpl.INSTANCE.unInit(sApp);
        //sApp.registerActivityLifecycleCallbacks(this);
        sApp = app;
        mActivityList.clear();
        UtilsActivityLifecycleImpl.INSTANCE.init(sApp);
        //sApp.unregisterActivityLifecycleCallbacks(this);
    }


    /**
     * 获取软件版本号，对应AndroidManifest.xml下android:versionCode
     * @return
     */
    public static int getvscode(Context context){
        int vscode=0;
        try {
            PackageManager packageManager=context.getPackageManager();
            PackageInfo packageInfo=packageManager.getPackageInfo(context.getPackageName(),0);
            vscode=packageInfo.versionCode;
        }catch (Exception e){
            e.printStackTrace();
        }
        return vscode;

    }

    /**
     * 获取Androidmanifest.xml中声明的权限
     * @param context
     * @return 返回所有在清单中声明的权限，或返回null
     */
    public static String[] getPermissionList(Context context){
        String[] requestedPermissions = null;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.GET_PERMISSIONS);
            requestedPermissions = packageInfo.requestedPermissions;

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return requestedPermissions;
    }
    /**
     * 获取软件版本名，对应AndroidManifest.xml下android:verName
     * @return
     */
    public static String  getvsname(Context context){
        String vsname="";
        try {
            PackageManager packageManager=context.getPackageManager();
            PackageInfo packageInfo=packageManager.getPackageInfo(context.getPackageName(),0);
            vsname=packageInfo.versionName;
        }catch (Exception e){
            e.printStackTrace();
        }
        return vsname;
    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static Application getApp() {
        if (sApp != null)
            return sApp;
        init(UtilsActivityLifecycleImpl.getApplicationByReflect());
        if (sApp == null) throw new NullPointerException("reflect failed.");
        LogUtils.i("DensityUtil",  " reflect app success.");
        return sApp;
    }

    /**
     * Exit the application.
     */
    public static void exitApp() {
        finishAllActivities();
        System.exit(0);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static Drawable getAppIcon() {
        return getAppIcon(getApp().getPackageName());
    }

    /**
     * Return the application's icon.
     *
     * @param packageName The name of the package.
     * @return the application's icon
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static Drawable getAppIcon(final String packageName) {
        if (StringUtils.isSpace(packageName)) return null;
        try {
            PackageManager pm = getApp().getPackageManager();
            PackageInfo pi = pm.getPackageInfo(packageName, 0);
            return pi == null ? null : pi.applicationInfo.loadIcon(pm);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void finishAllActivities() {
        finishAllActivities(false);
    }

    public static void finishAllActivities(final boolean isLoadAnim) {
        List<Activity> activityList = UtilsActivityLifecycleImpl.getActivityList();
        for (Activity act : activityList) {
            // sActivityList remove the index activity at onActivityDestroyed
            act.finish();
            if (!isLoadAnim) {
                act.overridePendingTransition(0, 0);
            }
        }
    }




    @Override
    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {

    }

    @Override
    public void onActivityStarted(@NonNull Activity activity) {

    }

    @Override
    public void onActivityResumed(@NonNull Activity activity) {

    }

    @Override
    public void onActivityPaused(@NonNull Activity activity) {

    }

    @Override
    public void onActivityStopped(@NonNull Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(@NonNull Activity activity) {

    }
}
