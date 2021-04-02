package com.android.tallybook.mvp.presenter;

import com.android.tallybook.base.BasePresenter;
import com.android.tallybook.bean.BillBean;
import com.android.tallybook.mvp.IAdd;
import com.android.tallybook.mvp.model.AddModel;
import com.android.tallybook.mvp.view.AddActivity;
import com.android.tallybook.utils.ToastUtils;

public class AddPresenter extends BasePresenter<AddActivity, AddModel, IAdd.P> {
    @Override
    public AddModel getModelInstence() {
        return new AddModel(this);
    }

    @Override
    public IAdd.P getContract() {
        return new IAdd.P() {
            @Override
            public void requestInsert(BillBean bean) {
                //逻辑判断
                if ("".equals(bean.getCost())){
                    ToastUtils.showToast(mView,"金额不能为0");
                    return;
                }else if ("".equals(bean.getBillname())){
                    ToastUtils.showToast(mView,"账单分类不能为空");
                    return;
                }
                mModel.getContract().requestInsert(bean);
            }

            @Override
            public void respondInsert(boolean flag) {
                mView.getContract().respondInsert(flag);
            }

            @Override
            public void updateBill(BillBean bean) {
                if ("".equals(bean.getCost())){
                    ToastUtils.showToast(mView,"金额不能为0");
                    return;
                }else if ("".equals(bean.getBillname())){
                    ToastUtils.showToast(mView,"账单分类不能为空");
                    return;
                }
                mModel.getContract().updateBill(bean);
            }
        };
    }
}
