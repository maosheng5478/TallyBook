package com.android.tallybook.mvp.model;

import com.android.tallybook.baseMVP.BaseMVPModel;
import com.android.tallybook.mvp.IHome;
import com.android.tallybook.mvp.presenter.HomePresenter;

public class HomeModel  extends BaseMVPModel<HomePresenter, IHome.M> {
    public HomeModel(HomePresenter mPresenter) {
        super(mPresenter);
    }

    @Override
    public IHome.M getContract() {
        return null;
    }
}
