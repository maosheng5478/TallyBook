package com.android.tallybook.customView;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.android.tallybook.R;
import com.android.tallybook.utils.ToastUtils;

public class DialogFromBottom extends Dialog {
    private final static int mAnimationDuration = 200;
    // 持有 ContentView，为了做动画
    private View mContentView;
    private boolean mIsAnimating = false;
    private Context context;

   private callback callback;

    public DialogFromBottom(@NonNull Context context) {
        super(context, R.style.Dialog);
        this.context = context;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_bottom_dialog);
        getWindow().getDecorView().setPadding(0, 0, 0, 100);
        // 在底部，宽度撑满
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        DisplayMetrics d =context.getResources().getDisplayMetrics();
        params.width = (int) (d.widthPixels * 0.9);
        params.gravity = Gravity.BOTTOM | Gravity.CENTER;//dialog从哪里弹出
        //弹出窗口的宽高
        getWindow().setAttributes(params);
        setCanceledOnTouchOutside(true);

        //TextView bottom_dialog_title = findViewById(R.id.bottom_dialog_title);
        //TextView bottom_dialog_content = findViewById(R.id.bottom_dialog_content);
        TextView bottom_dialog_confirm = findViewById(R.id.bottom_dialog_confirm);
        TextView bottom_dialog_cancel = findViewById(R.id.bottom_dialog_cancel);
        bottom_dialog_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.setConfirmListener();
            }
        });
        bottom_dialog_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    @Override
    public void setContentView(int layoutResID) {
        mContentView = LayoutInflater.from(context).inflate(layoutResID, null);
        super.setContentView(layoutResID);
    }

    /**
     * BottomSheet升起动画
     */
    private void animateUp() {
        System.out.println("mContentView");
        if (mContentView == null) {
            return;
        }
        TranslateAnimation translate = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, 1f, Animation.RELATIVE_TO_SELF, 0f
        );
        AlphaAnimation alpha = new AlphaAnimation(0, 1);
        AnimationSet set = new AnimationSet(true);
        set.addAnimation(translate);
        set.addAnimation(alpha);
        set.setInterpolator(new DecelerateInterpolator());
        set.setDuration(mAnimationDuration);
        set.setFillAfter(true);
        mContentView.startAnimation(set);
    }

    /**
     * BottomSheet降下动画
     */
    private void animateDown() {
        if (mContentView == null) {
            return;
        }
        TranslateAnimation translate = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 1f
        );
        AlphaAnimation alpha = new AlphaAnimation(1, 0);
        AnimationSet set = new AnimationSet(true);
        set.addAnimation(translate);
        set.addAnimation(alpha);
        set.setInterpolator(new DecelerateInterpolator());
        set.setDuration(mAnimationDuration);
        set.setFillAfter(true);
        mContentView.startAnimation(set);
    }

    @Override
    public void show() {
        super.show();
        animateUp();
    }

    @Override
    public void dismiss() {
        if (mIsAnimating) {
            return;
        }
        animateDown();
        super.dismiss();
    }

    public void setCallback(DialogFromBottom.callback callback) {
        this.callback = callback;
    }

    public interface callback{
        void setConfirmListener();
    }
}