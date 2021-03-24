package com.android.tallybook.utils;

import android.content.Context;
import android.util.TypedValue;

import com.android.tallybook.MyApplication;

public class DensityUtil {
    private static Context context = MyApplication.getContext();

    /**
     * dp to px
     * @param dip
     * @return
     */
    public static int dp2px( float dip) {
        float density = context.getResources().getDisplayMetrics().density;
        return (int) (dip * density);
    }

    /**
     * sp转px
     * @param spVal
     * @return
     */
    public static int sp2px(float spVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
                spVal, context.getResources().getDisplayMetrics());
    }

    /**
     * px转dp
     * @param pxVal
     * @return
     */
    public static float px2dp( float pxVal) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (pxVal / scale);
    }

    /**
     * px转sp
     * @param pxVal
     * @return
     */
    public static float px2sp( float pxVal) {
        return (pxVal / context.getResources().getDisplayMetrics().scaledDensity);
    }
}
