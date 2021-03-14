package com.android.tallybook.mvp.presenter;

import com.android.tallybook.baseMVP.BaseMVPPresenter;
import com.android.tallybook.mvp.IWelcome;
import com.android.tallybook.mvp.model.WelcomeModel;
import com.android.tallybook.mvp.view.GudieActivity;
import com.android.tallybook.mvp.view.WelcomeActivity;
import com.android.tallybook.utils.ActivityUtils;
import com.android.tallybook.utils.SharePreferenceUtils;
import com.android.tallybook.utils.WeakHandler;

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
                boolean isfrist = (boolean) SharePreferenceUtils.get(mView,"FRIST_LOGIN",false);
                if (isfrist){
                    getContract().hasLogin();
                }else {
                   new WeakHandler().postDelayed(new Runnable() {
                       @Override
                       public void run() {
                           ActivityUtils.go(mView, GudieActivity.class);
                       }
                   },1000);
                }
            }

            @Override
            public void hasLogin() {

            }
        };
    }
}
