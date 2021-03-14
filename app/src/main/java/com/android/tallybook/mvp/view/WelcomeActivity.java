package com.android.tallybook.mvp.view;

import android.view.View;

import com.android.tallybook.R;
import com.android.tallybook.baseMVP.BaseMVPActivity;
import com.android.tallybook.mvp.IWelcome;
import com.android.tallybook.mvp.presenter.WelcomePresenter;
import com.android.tallybook.utils.StatusBarUtils;

public class WelcomeActivity extends BaseMVPActivity<WelcomePresenter, IWelcome.V> {
    @Override
    public IWelcome.V getContract() {
        return new IWelcome.V() {
            @Override
            public void firstEntetrJudge() {
                mPresenter.getContract().firstEntetrJudge();
            }

            @Override
            public void hasLogin(boolean flag, String information) {

            }
        };
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public int getContextView() {
        return R.layout.activity_welcome;
    }

    @Override
    public void initData() {
        StatusBarUtils.with(this).setStatuImmersive();
        getContract().firstEntetrJudge();
    }

    @Override
    public WelcomePresenter getPresenterInstance() {
        return new WelcomePresenter();
    }

    @Override
    public <ERROR> void responrse(ERROR error, Throwable throwable) {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void onClick(View v) {

    }
}
