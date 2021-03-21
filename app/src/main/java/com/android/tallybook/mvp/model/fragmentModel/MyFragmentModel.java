package com.android.tallybook.mvp.model.fragmentModel;

import com.android.tallybook.baseMVP.BaseMVPModel;
import com.android.tallybook.mvp.iFragment.IFMy;
import com.android.tallybook.mvp.presenter.fragmentPresenter.MyFragmentPresenter;

public class MyFragmentModel extends BaseMVPModel<MyFragmentPresenter, IFMy.M> {
    public MyFragmentModel(MyFragmentPresenter mPresenter) {
        super(mPresenter);
    }

    @Override
    public IFMy.M getContract() {
        return null;
    }
}
