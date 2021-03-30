package com.android.tallybook.mvp.model;

import com.android.tallybook.base.BaseModel;
import com.android.tallybook.mvp.ILogin;
import com.android.tallybook.mvp.presenter.LoginPresenter;

public class LoginModel extends BaseModel<LoginPresenter, ILogin.M> {
    public LoginModel(LoginPresenter mPresenter) {
        super(mPresenter);
    }

    @Override
    public ILogin.M getContract() {
        return null;
    }
}
