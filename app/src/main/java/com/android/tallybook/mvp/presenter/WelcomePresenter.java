 package com.android.tallybook.mvp.presenter;

import com.android.tallybook.baseMVP.BaseMVPPresenter;
import com.android.tallybook.mvp.IWelcome;
import com.android.tallybook.mvp.model.WelcomeModel;
import com.android.tallybook.mvp.view.GudieActivity;
import com.android.tallybook.mvp.view.HomeActivity;
import com.android.tallybook.mvp.view.LoginActivity;
import com.android.tallybook.mvp.view.WelcomeActivity;
import com.android.tallybook.utils.ActivityUtils;
import com.android.tallybook.utils.SharePreferenceUtils;
import com.android.tallybook.utils.ToastUtils;
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
            public void EntetrJudge() {
                Boolean isfrist = (Boolean) SharePreferenceUtils.get(mView,"FRIST_LOGIN",false);
                if (isfrist){
                    ActivityUtils.go(mView, HomeActivity.class);
                    /*boolean hasUser = getContract().hasLogin();
                    String login_condition = (String) SharePreferenceUtils.get(mView,"LOGIN_TIME_OUT","");
                    if (hasUser){
                        ActivityUtils.go(mView, HomeActivity.class);
                    }else {
                        ActivityUtils.go(mView, LoginActivity.class);
                        if (!login_condition.equals("")){
                            //状态登场出弹窗
                            ToastUtils.showToast(mView,login_condition);
                        }
                    }*/
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
            public boolean hasLogin() {
                return mModel.getContract().hasLogin();
            }
        };
    }
}
