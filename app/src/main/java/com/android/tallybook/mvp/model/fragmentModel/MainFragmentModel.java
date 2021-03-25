package com.android.tallybook.mvp.model.fragmentModel;

import android.content.Context;

import com.android.tallybook.MyApplication;
import com.android.tallybook.baseMVP.BaseMVPModel;
import com.android.tallybook.bean.BillBean;
import com.android.tallybook.mvp.presenter.fragmentPresenter.MainFragmentPresenter;
import com.android.tallybook.mvp.iFragment.IFMain;
import com.android.tallybook.sqlite.dao.BillDao;

import java.util.List;

public class MainFragmentModel extends BaseMVPModel<MainFragmentPresenter, IFMain.M> {

    private final Context context = MyApplication.getContext();
    private BillDao billDao;

    public MainFragmentModel(MainFragmentPresenter mPresenter) {
        super(mPresenter);
    }

    @Override
    public IFMain.M getContract() {
        return new IFMain.M() {
            @Override
            public void findBillData() {
                billDao = new BillDao(context);
                List<BillBean> billDaoList = billDao.allBill();
                mPresenter.getContract().respondDataUpdate(billDaoList);
            }
        };
    }
}
