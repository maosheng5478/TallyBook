package com.android.tallybook.mvp.model.fragmentModel;

import com.android.tallybook.baseMVP.BaseMVPModel;
import com.android.tallybook.mvp.iFragment.IFStatistical;
import com.android.tallybook.mvp.presenter.fragmentPresenter.StatisticsFragmentPresenter;

public class StatisticsFragmentModel extends BaseMVPModel<StatisticsFragmentPresenter, IFStatistical.M> {
    public StatisticsFragmentModel(StatisticsFragmentPresenter mPresenter) {
        super(mPresenter);
    }

    @Override
    public IFStatistical.M getContract() {
        return null;
    }
}
