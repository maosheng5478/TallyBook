package com.android.tallybook.mvp.model;

import com.android.tallybook.baseMVP.BaseMVPModel;
import com.android.tallybook.mvp.IGuide;
import com.android.tallybook.mvp.presenter.GuidePresenter;

public class GuideModel extends BaseMVPModel<GuidePresenter, IGuide.M> {
    public GuideModel(GuidePresenter mPresenter) {
        super(mPresenter);
    }

    @Override
    public IGuide.M getContract() {
        return null;
    }
}
