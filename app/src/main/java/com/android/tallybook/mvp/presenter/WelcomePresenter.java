package com.android.tallybook.mvp.presenter;

import com.android.tallybook.baseMVP.BaseMVPPresenter;
import com.android.tallybook.mvp.IWelcome;
import com.android.tallybook.mvp.model.WelcomeModel;
import com.android.tallybook.mvp.view.WelcomeActivity;

public class WelcomePresenter extends BaseMVPPresenter<WelcomeActivity, WelcomeModel, IWelcome.P> {
    @Override
    public WelcomeModel getModelInstence() {
        return new WelcomeModel(this);
    }

    @Override
    public IWelcome.P getContract() {
        return new IWelcome.P() {
            @Override
            public void firstEntetrJudge() {

            }

            @Override
            public void hasLogin() {

            }
        };
    }
}
