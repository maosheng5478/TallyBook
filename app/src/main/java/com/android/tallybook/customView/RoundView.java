package com.android.tallybook.customView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.android.tallybook.utils.DensityUtil;

public class RoundView extends androidx.appcompat.widget.AppCompatImageView {

    //背景色默认透明
    private int mBgColor = 0x00ffffff;
    private Paint mPaint;
    private int mRectFillColor = Color.WHITE;
    private int mWidth;
    private int mHeight;
    private float mCornerX = 30;
    private float mCornerY = 30;

    public RoundView(@NonNull Context context) {
        super(context);
        init();
    }

    public RoundView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    /**
     * 初始化此view信息
     */
    private void init() {
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);


    }
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //控件坐标系移至控件中心位置
        canvas.translate(mWidth / 2, mHeight / 2);
        //先画出透明背景色
        canvas.drawColor(mBgColor);
        //在其上画出圆角矩形，圆角大小由外界决定
        mPaint.setColor(mRectFillColor);
        RectF rectF = new RectF(-mWidth / 2, -mHeight / 2, mWidth / 2, mHeight / 2);
        canvas.drawRoundRect(rectF, mCornerX, mCornerY, mPaint);

    }
    /**
     * 设置圆角矩形中填充的颜色
     */
    public void setFillColor(int fillColor) {
        this.mRectFillColor = fillColor;
        invalidate();
    }
    /**
     * 设置圆角的大小
     */
    public void setCornerXY(float cornerX, float cornerY) {
        //非正常值处理
        if (cornerX <= 0) {
            cornerX = 5;
        }
        if (cornerY <= 0) {
            cornerY = 5;
        }
        this.mCornerX = cornerX;
        this.mCornerY = cornerY;
        invalidate();
    }
}
