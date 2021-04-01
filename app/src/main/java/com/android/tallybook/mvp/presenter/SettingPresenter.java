package com.android.tallybook.mvp.presenter;

import com.android.tallybook.base.BasePresenter;
import com.android.tallybook.mvp.ISetting;
import com.android.tallybook.mvp.model.SettingModel;
import com.android.tallybook.mvp.view.SettingActivity;

public class SettingPresenter extends BasePresenter<SettingActivity, SettingModel, ISetting.P> {
    @Override
    public SettingModel getModelInstence() {
        return new SettingModel(this);
    }

    @Override
    public ISetting.P getContract() {
        return null;
    }
}
