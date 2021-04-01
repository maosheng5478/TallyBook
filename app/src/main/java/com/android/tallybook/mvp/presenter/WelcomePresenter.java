 package com.android.tallybook.mvp.presenter;

import com.android.tallybook.R;
import com.android.tallybook.base.BasePresenter;
import com.android.tallybook.customView.permission.PermissionListener;
import com.android.tallybook.mvp.IWelcome;
import com.android.tallybook.mvp.model.WelcomeModel;
import com.android.tallybook.mvp.view.GudieActivity;
import com.android.tallybook.mvp.view.HomeActivity;
import com.android.tallybook.mvp.view.WelcomeActivity;
import com.android.tallybook.utils.APPUtils;
import com.android.tallybook.utils.ActivityUtils;
import com.android.tallybook.utils.PermissionUtil;
import com.android.tallybook.utils.SharePreferenceUtils;
import com.android.tallybook.utils.WeakHandler;

import java.util.List;

 public class WelcomePresenter extends BasePresenter<WelcomeActivity, WelcomeModel, IWelcome.P> {
    @Override
    public WelcomeModel getModelInstence() {
        return new WelcomeModel(this);
    }

    @Override
    public IWelcome.P getContract() {
        return new IWelcome.P() {
            @Override
            public void EntetrJudge() {
                PermissionUtil util = new PermissionUtil(mView);
                util.requestPermissions(APPUtils.getPermissionList(mView), new PermissionListener() {
                    @Override
                    public void onGranted() {
                        Boolean isfrist = (Boolean) SharePreferenceUtils.get(mView,"FRIST_LOGIN",false);
                        new WeakHandler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                if (isfrist){
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
                                    ActivityUtils.go(mView, HomeActivity.class);
                                    //ActivityUtils.go(mView, GudieActivity.class);
                                    mView.finish();
                                    mView.overridePendingTransition(R.anim.anim_in, R.anim.anim_out);
                                }else {
                                    ActivityUtils.go(mView, GudieActivity.class);
                                    mView.finish();
                                    mView.overridePendingTransition(R.anim.anim_in, R.anim.anim_out);

                                }
                            }
                        },1000);

                    }

                    @Override
                    public void onDenied(List<String> deniedPermission) {
                        APPUtils.exitApp();
                    }

                    @Override
                    public void onShouldShowRationale(List<String> deniedPermission) {

                    }
                });

            }

            @Override
            public boolean hasLogin() {
                return mModel.getContract().hasLogin();
            }
        };
    }
}
