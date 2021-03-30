package com.android.tallybook.mvp.model;

import com.android.tallybook.base.BaseModel;
import com.android.tallybook.mvp.IHome;
import com.android.tallybook.mvp.presenter.HomePresenter;

public class HomeModel  extends BaseModel<HomePresenter, IHome.M> {
    public HomeModel(HomePresenter mPresenter) {
        super(mPresenter);
    }

    @Override
    public IHome.M getContract() {
        return null;
    }
}
