package com.android.tallybook.mvp.view;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.android.tallybook.R;
import com.android.tallybook.baseMVP.BaseMVPActivity;
import com.android.tallybook.mvp.IWelcome;
import com.android.tallybook.mvp.presenter.WelcomePresenter;
import com.android.tallybook.utils.APPUtils;
import com.android.tallybook.utils.StatusBarUtils;

public class WelcomeActivity extends BaseMVPActivity<WelcomePresenter, IWelcome.V> {

    private TextView wel_tv_vsname;
    private ImageView wel_iv_appicon;

    @Override
    public IWelcome.V getContract() {
        return new IWelcome.V() {
            @Override
            public void EntetrJudge() {
                mPresenter.getContract().EntetrJudge();
            }

            @Override
            public void hasLogin(boolean flag, String information) {
                //占时不做登录功能
            }
        };
    }

    @Override
    public void initView() {
        wel_iv_appicon = findViewById(R.id.wel_iv_icon);
        wel_tv_vsname = findViewById(R.id.wel_tv_vsname);
    }

    @Override
    public void initListener() {

    }

    @Override
    public int getContextView() {
        return R.layout.activity_welcome;
    }

    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void initData() {
        StatusBarUtils.with(this).setStatuImmersive();
        StatusBarUtils.setStyleBlack(this);
        getContract().EntetrJudge();
        wel_iv_appicon.setImageDrawable(APPUtils.getAppIcon());
        wel_tv_vsname.setText("版本号："+APPUtils.getvsname(this));
    }

    @Override
    public WelcomePresenter getPresenterInstance() {
        return new WelcomePresenter();
    }

    @Override
    public <ERROR> void responrse(ERROR error, Throwable throwable) {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void onClick(View v) {

    }
}
