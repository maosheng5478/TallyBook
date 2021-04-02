package com.android.tallybook.mvp.view;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.LinearLayout;

import com.android.tallybook.R;
import com.android.tallybook.base.BaseActivity;
import com.android.tallybook.mvp.IPrefence;
import com.android.tallybook.mvp.presenter.PrefencePresenter;
import com.android.tallybook.utils.ActivityUtils;

public class PrefenceActivity extends BaseActivity<PrefencePresenter, IPrefence.V> {

    private LinearLayout pre_ll_back;
    @Override
    public IPrefence.V getContract() {
        return null;
    }

    @Override
    public void initView() {
        pre_ll_back = findViewById(R.id.pre_ll_back);
    }

    @Override
    public void initListener() {
        pre_ll_back.setOnClickListener(this);
    }

    @Override
    public int getContextView() {
        return R.layout.activity_prefence;
    }

    @Override
    public void initData() {

    }

    @Override
    public PrefencePresenter getPresenterInstance() {
        return new PrefencePresenter();
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
            case R.id.pre_ll_back:
                ActivityUtils.go(PrefenceActivity.this,HomeActivity.class);
                finish();
                overridePendingTransition(R.anim.lr_in_exit, R.anim.lr_out_exit);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        ActivityUtils.go(PrefenceActivity.this,HomeActivity.class);
        finish();
        overridePendingTransition(R.anim.lr_in_exit, R.anim.lr_out_exit);
    }
}
