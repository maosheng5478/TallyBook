package com.android.tallybook.mvp.model;

import com.android.tallybook.base.BaseActivity;
import com.android.tallybook.base.BaseModel;
import com.android.tallybook.mvp.IHome;
import com.android.tallybook.mvp.iFragment.IFExprenses;
import com.android.tallybook.mvp.presenter.PrefencePresenter;

public class PrefenceModel extends BaseModel<PrefencePresenter, IFExprenses.M> {
    public PrefenceModel(PrefencePresenter mPresenter) {
        super(mPresenter);
    }

    @Override
    public IFExprenses.M getContract() {
        return null;
    }
}
