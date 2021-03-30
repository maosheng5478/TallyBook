package com.android.tallybook.mvp.model;

import android.content.Context;

import com.android.tallybook.MyApplication;
import com.android.tallybook.R;
import com.android.tallybook.base.BaseModel;
import com.android.tallybook.mvp.IWelcome;
import com.android.tallybook.mvp.presenter.WelcomePresenter;
import com.android.tallybook.sqlite.dao.UserLoginDao;
import com.android.tallybook.utils.SharePreferenceUtils;

public class WelcomeModel extends BaseModel<WelcomePresenter, IWelcome.M> {

    private final Context context = MyApplication.getContext();
    private UserLoginDao dao;

    public WelcomeModel(WelcomePresenter mPresenter) {
        super(mPresenter);
    }

    @Override
    public IWelcome.M getContract() {
        return new IWelcome.M() {
            @Override
            public boolean hasLogin() {
                dao = new UserLoginDao(context);
                String exist_user = (String) SharePreferenceUtils.get(context,"EXIST_USER","");
                String exist_password = (String) SharePreferenceUtils.get(context,"EXIST_PWD","");
                //boolean exist = dao.hasUser(exist_user,exist_password);
                //判断是否存在用户名但是密码不正确
                //或登录过期
                if (!exist_password.equals("")){
                    SharePreferenceUtils.put(context,"LOGIN_TIME_OUT",context.getResources().getString(R.string.login_time_out));
                }
                return dao.hasUser(exist_user,exist_password);
            }
        };
    }
}
