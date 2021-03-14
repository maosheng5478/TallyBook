package com.android.tallybook.mvp.model;

import com.android.tallybook.baseMVP.BaseMVPModel;
import com.android.tallybook.mvp.IHome;
import com.android.tallybook.mvp.ILogin;
import com.android.tallybook.mvp.presenter.HomePresenter;
import com.android.tallybook.mvp.presenter.LoginPresenter;

public class LoginModel extends BaseMVPModel<LoginPresenter, ILogin.M> {
    public LoginModel(LoginPresenter mPresenter) {
        super(mPresenter);
    }

    @Override
    public ILogin.M getContract() {
        return null;
    }
}
