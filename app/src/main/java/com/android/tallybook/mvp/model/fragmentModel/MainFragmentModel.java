package com.android.tallybook.mvp.model.fragmentModel;

import android.content.Context;

import com.android.tallybook.MyApplication;
import com.android.tallybook.base.BaseModel;
import com.android.tallybook.bean.BillBean;
import com.android.tallybook.mvp.presenter.fragmentPresenter.MainFragmentPresenter;
import com.android.tallybook.mvp.iFragment.IFMain;
import com.android.tallybook.sqlite.dao.BillDao;

import java.util.List;

public class MainFragmentModel extends BaseModel<MainFragmentPresenter, IFMain.M> {

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

            @Override
            public Double selectExpenses() {
                double total =0;
                billDao = new BillDao(context);
                List<BillBean> list =billDao.expenses();
                if (list.size() != 0) {
                    for (int i = 0; i < list.size(); i++) {
                        total = total+Double.parseDouble(list.get(i).getCost());
                    }
                    return total;
                }
                return total;
            }

            @Override
            public Double selectIncome() {
                double total =0;
                billDao = new BillDao(context);
                List<BillBean> list =billDao.income();
                if (list.size() != 0) {
                    for (int i = 0; i < list.size(); i++) {
                        total = total+Double.parseDouble(list.get(i).getCost());
                    }
                    return total;
                }
                return total;
            }

            @Override
            public void deletBill(int i) {
                billDao = new BillDao(context);
                int e = billDao.deletBill(i);
            }
        };
    }
}
