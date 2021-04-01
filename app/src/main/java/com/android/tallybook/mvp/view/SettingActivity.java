package com.android.tallybook.mvp.view;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.android.tallybook.R;
import com.android.tallybook.base.BaseActivity;
import com.android.tallybook.mvp.ISetting;
import com.android.tallybook.mvp.presenter.SettingPresenter;
import com.android.tallybook.utils.ActivityUtils;
import com.android.tallybook.utils.StatusBarUtils;

public class SettingActivity extends BaseActivity<SettingPresenter, ISetting.V> {

    private RelativeLayout set_rl_clear;
    private RelativeLayout set_rl_feedback;
    private LinearLayout set_ll_back;
    @Override
    public ISetting.V getContract() {
        return null;
    }

    @Override
    public void initView() {
        set_rl_clear = findViewById(R.id.set_rl_clear);
        set_rl_feedback = findViewById(R.id.set_rl_feedback);
        set_ll_back = findViewById(R.id.set_ll_back);
    }

    @Override
    public void initListener() {
        set_rl_clear.setOnClickListener(this);
        set_rl_feedback.setOnClickListener(this);
        set_ll_back.setOnClickListener(this);
    }

    @Override
    public int getContextView() {
        return R.layout.activity_setting;
    }

    @Override
    public void initData() {
        //StatusBarUtils.with(this).setStatuImmersive();
        //StatusBarUtils.setStyleBlack(this);
    }

    @Override
    public SettingPresenter getPresenterInstance() {
        return new SettingPresenter();
    }

    @Override
    public <ERROR> void responrse(ERROR error, Throwable throwable) {

    }

    @Override
    public void destroy() {

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.set_rl_clear:
                ActivityUtils.go(SettingActivity.this,ClearActivity.class);
                break;
            case R.id.set_rl_feedback:
                break;
            case R.id.set_ll_back:
                ActivityUtils.go(SettingActivity.this,HomeActivity.class);
                finish();
                overridePendingTransition(R.anim.lr_in_exit, R.anim.lr_out_exit);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        ActivityUtils.go(SettingActivity.this,HomeActivity.class);
        finish();
        overridePendingTransition(R.anim.lr_in_exit, R.anim.lr_out_exit);
    }
}
