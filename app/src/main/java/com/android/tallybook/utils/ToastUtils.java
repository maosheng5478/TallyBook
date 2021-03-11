package com.android.tallybook.utils;

import android.content.Context;
import android.view.KeyEvent;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class ToastUtils {
    //private Context context;
    private static long mExitTime;


    /**
     * 显示toast
     * @param msg
     */
    public static void showToast(Context context,String msg) {
        Toast toast = Toast.makeText(context, msg, Toast.LENGTH_LONG);
        toast.setText(msg);
        showTimeToast(toast,1000);
    }

    /**
     * 设置toast弹出时间
     * @param toast
     * @param time
     */
    private static void showTimeToast(final Toast toast, final int time) {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                toast.show();
            }
        },0, 3000);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                toast.cancel();
                timer.cancel();
            }
        }, time);
    }

    /**
     * 退出程序tost
     * @param keyCode
     * @param event
     * @return
     */
    public static boolean onKeyDown(Context context,int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //与上次点击返回键时刻作差
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                showToast(context,"再按一次退出程序");
                //并记录下本次点击“返回键”的时刻，以便下次进行判断
                mExitTime = System.currentTimeMillis();
            } else {
                System.exit(0);
            }
            return true;
        }
        return false;
    }
}
