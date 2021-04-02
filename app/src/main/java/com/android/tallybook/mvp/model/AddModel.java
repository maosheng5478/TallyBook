package com.android.tallybook.mvp.model;

import android.content.Context;

import com.android.tallybook.MyApplication;
import com.android.tallybook.base.BaseModel;
import com.android.tallybook.bean.BillBean;
import com.android.tallybook.mvp.IAdd;
import com.android.tallybook.mvp.presenter.AddPresenter;
import com.android.tallybook.sqlite.dao.BillDao;

public class AddModel extends BaseModel<AddPresenter, IAdd.M> {

    private final Context context = MyApplication.getContext();
    private BillDao billDao;
    public AddModel(AddPresenter mPresenter) {
        super(mPresenter);
    }

    @Override
    public IAdd.M getContract() {
        return new IAdd.M() {
            @Override
            public void requestInsert(BillBean bean) {
                billDao = new BillDao(context);
                int i= billDao.insertBill(bean);
                getContract().respondInsert(i != 0);
            }

            @Override
            public void respondInsert(boolean flag) {
                mPresenter.getContract().respondInsert(flag);
            }

            @Override
            public void updateBill(BillBean bean) {
                billDao = new BillDao(context);
                int i= billDao.updateBill(bean);
            }
        };
    }
}
