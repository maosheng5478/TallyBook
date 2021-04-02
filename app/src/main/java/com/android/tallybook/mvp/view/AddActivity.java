package com.android.tallybook.mvp.view;

import android.view.View;

import com.android.tallybook.R;
import com.android.tallybook.base.BaseActivity;
import com.android.tallybook.bean.BillBean;
import com.android.tallybook.mvp.IAdd;
import com.android.tallybook.mvp.presenter.AddPresenter;
import com.android.tallybook.utils.ActivityUtils;
import com.android.tallybook.utils.ToastUtils;

public class AddActivity extends BaseActivity<AddPresenter, IAdd.V> {
    @Override
    public IAdd.V getContract() {
        return new IAdd.V() {
            @Override
            public void requestInsert(BillBean bean) {
                mPresenter.getContract().requestInsert(bean);
            }

            @Override
            public void respondInsert(boolean flag) {
                if (flag){
                    ToastUtils.showToast(AddActivity.this,"账单添加成功");
                }else {
                    ToastUtils.showToast(AddActivity.this,"账单添加失败");
                }
                onBackPressed();
            }

            @Override
            public void updateBill(BillBean bean) {
                mPresenter.getContract().updateBill(bean);
            }
        };
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public int getContextView() {
        return R.layout.activity_add;
    }

    @Override
    public void initData() {

    }

    @Override
    public AddPresenter getPresenterInstance() {
        return new AddPresenter();
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

    @Override
    public void onBackPressed() {
        ActivityUtils.go(AddActivity.this,HomeActivity.class);
        finish();
        overridePendingTransition(R.anim.lr_in_exit, R.anim.lr_out_exit);
    }
}
