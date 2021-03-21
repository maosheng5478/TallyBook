package com.android.tallybook.mvp.model.fragmentModel;

import com.android.tallybook.baseMVP.BaseMVPModel;
import com.android.tallybook.mvp.presenter.fragmentPresenter.MainFragmentPresenter;
import com.android.tallybook.mvp.iFragment.IFMain;

public class MainFragmentModel extends BaseMVPModel<MainFragmentPresenter, IFMain.M> {
    public MainFragmentModel(MainFragmentPresenter mPresenter) {
        super(mPresenter);
    }

    @Override
    public IFMain.M getContract() {
        return null;
    }
}
