package com.android.tallybook.mvp.presenter;

import com.android.tallybook.baseMVP.BaseMVPPresenter;
import com.android.tallybook.mvp.IHome;
import com.android.tallybook.mvp.model.HomeModel;
import com.android.tallybook.mvp.view.HomeActivity;

public class HomePresenter extends BaseMVPPresenter<HomeActivity, HomeModel, IHome.P> {
    @Override
    public HomeModel getModelInstence() {
        return new HomeModel(this);
    }

    @Override
    public IHome.P getContract() {
        return null;
    }
}
