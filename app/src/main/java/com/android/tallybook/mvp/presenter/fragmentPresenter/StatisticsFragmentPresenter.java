package com.android.tallybook.mvp.presenter.fragmentPresenter;

import android.widget.TextView;

import com.android.tallybook.base.BasePresenter;
import com.android.tallybook.mvp.iFragment.IFStatistical;
import com.android.tallybook.mvp.model.fragmentModel.StatisticsFragmentModel;
import com.android.tallybook.mvp.view.fragment.StatisticsFragment;
import com.android.tallybook.utils.TabLayoutUtils;
import com.google.android.material.tabs.TabLayout;

public class StatisticsFragmentPresenter extends BasePresenter<StatisticsFragment, StatisticsFragmentModel, IFStatistical.P> {
    @Override
    public StatisticsFragmentModel getModelInstence() {
        return new StatisticsFragmentModel(this);
    }

    @Override
    public IFStatistical.P getContract() {
        return new IFStatistical.P() {

            @Override
            public void tabinit(TabLayout fsta_tl) {
                fsta_tl.post(new Runnable() {
                    @Override
                    public void run() {
                        TabLayoutUtils.setTabLayoutIndicator(fsta_tl,15,15);
                    }
                });
            }

            @Override
            public void setTextViewData(TextView exp, TextView income, TextView remain) {
                double i_exp,i_income,i_remain;
                i_exp = mModel.getContract().selectExpenses();
                i_income = mModel.getContract().selectIncome();
                i_remain = i_income - i_exp;
                exp.setText(String.valueOf(i_exp));
                income.setText(String.valueOf(i_income));
                remain.setText(String.valueOf(i_remain));
            }
        };
    }
}
