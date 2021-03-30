package com.android.tallybook.mvp.model.fragmentModel;

import android.content.Context;

import com.android.tallybook.MyApplication;
import com.android.tallybook.base.BaseModel;
import com.android.tallybook.bean.BillBean;
import com.android.tallybook.mvp.iFragment.IFExprenses;
import com.android.tallybook.mvp.presenter.fragmentPresenter.ExprensesFragmentPresenter;
import com.android.tallybook.sqlite.dao.BillDao;

import java.util.List;

public class ExprensesFragmentModel extends BaseModel<ExprensesFragmentPresenter, IFExprenses.M> {

    private final Context context = MyApplication.getContext();
    private BillDao dao;

    public ExprensesFragmentModel(ExprensesFragmentPresenter mPresenter) {
        super(mPresenter);
    }

    @Override
    public IFExprenses.M getContract() {
        return new IFExprenses.M() {
            @Override
            public List<BillBean> expenses() {
                dao = new BillDao(context);
                return dao.expenses();
            }
        };
    }
}
