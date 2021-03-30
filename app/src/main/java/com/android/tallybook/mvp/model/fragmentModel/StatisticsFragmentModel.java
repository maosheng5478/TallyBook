package com.android.tallybook.mvp.model.fragmentModel;

import android.content.Context;

import com.android.tallybook.MyApplication;
import com.android.tallybook.baseMVP.BaseMVPModel;
import com.android.tallybook.bean.BillBean;
import com.android.tallybook.mvp.iFragment.IFStatistical;
import com.android.tallybook.mvp.presenter.fragmentPresenter.StatisticsFragmentPresenter;
import com.android.tallybook.sqlite.dao.BillDao;

import java.util.List;

public class StatisticsFragmentModel extends BaseMVPModel<StatisticsFragmentPresenter, IFStatistical.M> {

    private final Context context = MyApplication.getContext();
    private BillDao dao ;

    public StatisticsFragmentModel(StatisticsFragmentPresenter mPresenter) {
        super(mPresenter);
    }

    @Override
    public IFStatistical.M getContract() {
        return new IFStatistical.M() {

            @Override
            public Double selectExpenses() {
                double total =0;
                dao = new BillDao(context);
                List<BillBean> list =dao.expenses();
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
                dao = new BillDao(context);
                List<BillBean> list =dao.income();
                if (list.size() != 0) {
                    for (int i = 0; i < list.size(); i++) {
                        total = total+Integer.parseInt(list.get(i).getCost());
                    }
                    return total;
                }
                return total;
            }
        };
    }
}
