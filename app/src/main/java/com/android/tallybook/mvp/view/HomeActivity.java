package com.android.tallybook.mvp.view;

import android.view.View;

import com.android.tallybook.baseMVP.BaseMVPActivity;
import com.android.tallybook.mvp.IHome;
import com.android.tallybook.mvp.presenter.HomePresenter;

public class HomeActivity extends BaseMVPActivity<HomePresenter, IHome.V> {
    @Override
    public IHome.V getContract() {
        return null;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public int getContextView() {
        return 0;
    }

    @Override
    public void initData() {

    }

    @Override
    public HomePresenter getPresenterInstance() {
        return null;
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
