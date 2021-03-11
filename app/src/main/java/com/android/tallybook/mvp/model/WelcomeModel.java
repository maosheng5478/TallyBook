package com.android.tallybook.mvp.model;

import com.android.tallybook.baseMVP.BaseMVPModel;
import com.android.tallybook.mvp.IWelcome;
import com.android.tallybook.mvp.presenter.WelcomePresenter;

public class WelcomeModel extends BaseMVPModel<WelcomePresenter, IWelcome.M> {
    public WelcomeModel(WelcomePresenter mPresenter) {
        super(mPresenter);
    }

    @Override
    public IWelcome.M getContract() {
        return null;
    }
}
