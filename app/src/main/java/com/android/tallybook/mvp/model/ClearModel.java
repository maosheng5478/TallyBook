package com.android.tallybook.mvp.model;

import android.content.Context;

import com.android.tallybook.MyApplication;
import com.android.tallybook.base.BaseModel;
import com.android.tallybook.mvp.IClear;
import com.android.tallybook.mvp.presenter.ClearPresenter;
import com.android.tallybook.sqlite.dao.BillDao;

public class ClearModel extends BaseModel<ClearPresenter, IClear.M> {

    private final Context context = MyApplication.getContext();
    private BillDao dao;

    public ClearModel(ClearPresenter mPresenter) {
        super(mPresenter);
    }

    @Override
    public IClear.M getContract() {
        return new IClear.M() {
            @Override
            public void clearSQL() {
                dao = new BillDao(context);
                dao.emptyBill();
            }
        };
    }
}
