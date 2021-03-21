package com.android.tallybook.mvp.presenter.fragmentPresenter;

import com.android.tallybook.baseMVP.BaseMVPPresenter;
import com.android.tallybook.mvp.iFragment.IFStatistical;
import com.android.tallybook.mvp.model.fragmentModel.StatisticsFragmentModel;
import com.android.tallybook.mvp.view.fragment.StatisticsFragment;

public class StatisticsFragmentPresenter extends BaseMVPPresenter<StatisticsFragment, StatisticsFragmentModel, IFStatistical.P> {
    @Override
    public StatisticsFragmentModel getModelInstence() {
        return new StatisticsFragmentModel(this);
    }

    @Override
    public IFStatistical.P getContract() {
        return null;
    }
}
