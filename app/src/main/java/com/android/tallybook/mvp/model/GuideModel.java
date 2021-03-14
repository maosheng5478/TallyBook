package com.android.tallybook.mvp.model;

import com.android.tallybook.baseMVP.BaseMVPModel;
import com.android.tallybook.mvp.IGuide;
import com.android.tallybook.mvp.presenter.GuidePresenter;
import com.android.tallybook.utils.SharePreferenceUtils;

public class GuideModel extends BaseMVPModel<GuidePresenter, IGuide.M> {
    public GuideModel(GuidePresenter mPresenter) {
        super(mPresenter);
    }

    @Override
    public IGuide.M getContract() {
        return new IGuide.M() {
            @Override
            public void noFristLogin() {
                SharePreferenceUtils.put(mPresenter.mView,"FRIST_LOGIN",true);
            }
        };
    }
}
