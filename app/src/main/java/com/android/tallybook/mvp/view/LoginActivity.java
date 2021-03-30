package com.android.tallybook.mvp.view;

import android.view.View;

import com.android.tallybook.base.BaseActivity;
import com.android.tallybook.mvp.ILogin;
import com.android.tallybook.mvp.presenter.LoginPresenter;

public class LoginActivity extends BaseActivity<LoginPresenter, ILogin.V> {
    @Override
    public ILogin.V getContract() {
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
    public LoginPresenter getPresenterInstance() {
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
