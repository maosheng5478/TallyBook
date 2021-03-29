package com.android.tallybook.mvp.model.fragmentModel;

import android.content.Context;

import com.android.tallybook.MyApplication;
import com.android.tallybook.baseMVP.BaseMVPModel;
import com.android.tallybook.bean.BillBean;
import com.android.tallybook.customView.discView.DiscView;
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
            public List<BillBean> selectExpenses() {
                dao = new BillDao(context);
                return dao.expenses();
            }

            @Override
            public List<BillBean> selectIncome() {
                dao = new BillDao(context);
                return dao.income();
            }
        };
    }
}
