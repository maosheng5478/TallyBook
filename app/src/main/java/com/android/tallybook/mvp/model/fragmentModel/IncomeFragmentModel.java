package com.android.tallybook.mvp.model.fragmentModel;

import android.content.Context;

import com.android.tallybook.MyApplication;
import com.android.tallybook.base.BaseModel;
import com.android.tallybook.bean.BillBean;
import com.android.tallybook.mvp.iFragment.IFIncome;
import com.android.tallybook.mvp.presenter.fragmentPresenter.IncomeFragmentPresenter;
import com.android.tallybook.sqlite.dao.BillDao;

import java.util.List;

public class IncomeFragmentModel extends BaseModel<IncomeFragmentPresenter, IFIncome.M> {

    private final Context context = MyApplication.getContext();
    private BillDao dao;

    public IncomeFragmentModel(IncomeFragmentPresenter mPresenter) {
        super(mPresenter);
    }

    @Override
    public IFIncome.M getContract() {
        return new IFIncome.M() {
            @Override
            public List<BillBean> income() {
                dao = new BillDao(context);
                return dao.income();
            }
        };
    }
}
