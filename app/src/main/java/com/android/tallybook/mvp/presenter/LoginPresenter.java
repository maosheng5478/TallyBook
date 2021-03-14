package com.android.tallybook.mvp.presenter;

import com.android.tallybook.baseMVP.BaseMVPPresenter;
import com.android.tallybook.mvp.ILogin;
import com.android.tallybook.mvp.model.LoginModel;
import com.android.tallybook.mvp.view.LoginActivity;

public class LoginPresenter extends BaseMVPPresenter<LoginActivity, LoginModel, ILogin.P> {
    @Override
    public LoginModel getModelInstence() {
        return new LoginModel(this);
    }

    @Override
    public ILogin.P getContract() {
        return null;
    }
}
