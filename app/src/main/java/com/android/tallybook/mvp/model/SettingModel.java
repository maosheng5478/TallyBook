package com.android.tallybook.mvp.model;

import com.android.tallybook.base.BaseModel;
import com.android.tallybook.mvp.ISetting;
import com.android.tallybook.mvp.presenter.SettingPresenter;

public class SettingModel extends BaseModel<SettingPresenter, ISetting.M> {
    public SettingModel(SettingPresenter mPresenter) {
        super(mPresenter);
    }

    @Override
    public ISetting.M getContract() {
        return null;
    }
}
