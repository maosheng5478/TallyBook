package com.android.tallybook.utils;

import android.content.res.Resources;
import android.util.DisplayMetrics;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class AdaptScreenUtils {

    private static List<Field> sMetricsFields;

    public static Runnable getPreLoadRunnable() {
        return new Runnable() {
            @Override
            public void run() {
                preLoad();
            }
        };
    }

    static void preLoad() {
        applyDisplayMetrics(Resources.getSystem(), Resources.getSystem().getDisplayMetrics().xdpi);
    }

    private static void applyOtherDisplayMetrics(final Resources resources, final float newXdpi) {
        if (sMetricsFields == null) {
            sMetricsFields = new ArrayList<>();
            Class resCls = resources.getClass();
            Field[] declaredFields = resCls.getDeclaredFields();
            while (declaredFields != null && declaredFields.length > 0) {
                for (Field field : declaredFields) {
                    if (field.getType().isAssignableFrom(DisplayMetrics.class)) {
                        field.setAccessible(true);
                        DisplayMetrics tmpDm = getMetricsFromField(resources, field);
                        if (tmpDm != null) {
                            sMetricsFields.add(field);
                            tmpDm.xdpi = newXdpi;
                        }
                    }
                }
                resCls = resCls.getSuperclass();
                if (resCls != null) {
                    declaredFields = resCls.getDeclaredFields();
                } else {
                    break;
                }
            }
        } else {
            applyMetricsFields(resources, newXdpi);
        }
    }

    private static void applyMetricsFields(final Resources resources, final float newXdpi) {
        for (Field metricsField : sMetricsFields) {
            try {
                DisplayMetrics dm = (DisplayMetrics) metricsField.get(resources);
                if (dm != null) dm.xdpi = newXdpi;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void applyDisplayMetrics(final Resources resources, final float newXdpi) {
        resources.getDisplayMetrics().xdpi = newXdpi;
        APPUtils.getApp().getResources().getDisplayMetrics().xdpi = newXdpi;
        applyOtherDisplayMetrics(resources, newXdpi);
    }


    private static DisplayMetrics getMetricsFromField(final Resources resources, final Field field) {
        try {
            return (DisplayMetrics) field.get(resources);
        } catch (Exception ignore) {
            return null;
        }
    }

}
