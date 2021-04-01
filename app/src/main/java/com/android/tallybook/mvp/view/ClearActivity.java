package com.android.tallybook.mvp.view;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.android.tallybook.R;
import com.android.tallybook.base.BaseActivity;
import com.android.tallybook.mvp.IClear;
import com.android.tallybook.mvp.presenter.ClearPresenter;

public class ClearActivity extends BaseActivity<ClearPresenter, IClear.V> {

    private Button clear_btn_confirm_clear;
    private LinearLayout clear_ll_back;

    @Override
    public IClear.V getContract() {
        return new IClear.V() {
            @Override
            public void clearSQL() {
                mPresenter.getContract().clearSQL();
            }
        };
    }

    @Override
    public void initView() {
        clear_btn_confirm_clear = findViewById(R.id.clear_btn_confirm_clear);
        clear_ll_back =findViewById(R.id.clear_back);
    }

    @Override
    public void initListener() {
        clear_btn_confirm_clear.setOnClickListener(this);
        clear_ll_back.setOnClickListener(this);
    }

    @Override
    public int getContextView() {
        return R.layout.activity_clear;
    }

    @Override
    public void initData() {

    }

    @Override
    public ClearPresenter getPresenterInstance() {
        return new ClearPresenter();
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
            case R.id.clear_btn_confirm_clear:
                getContract().clearSQL();
                break;
            case R.id.clear_back:
                onBackPressed();
                break;
        }

    }
}
