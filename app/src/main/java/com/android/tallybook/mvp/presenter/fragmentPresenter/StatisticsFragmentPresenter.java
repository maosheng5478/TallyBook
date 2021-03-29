package com.android.tallybook.mvp.presenter.fragmentPresenter;

import com.android.tallybook.R;
import com.android.tallybook.baseMVP.BaseMVPPresenter;
import com.android.tallybook.mvp.iFragment.IFStatistical;
import com.android.tallybook.mvp.model.fragmentModel.StatisticsFragmentModel;
import com.android.tallybook.mvp.view.fragment.StatisticsFragment;
import com.android.tallybook.utils.TabLayoutUtils;
import com.android.tallybook.utils.WeakHandler;
import com.google.android.material.tabs.TabLayout;
import com.lihang.chart.ChartCircleItem;
import com.lihang.chart.ChartCircleView;

import java.util.ArrayList;

public class StatisticsFragmentPresenter extends BaseMVPPresenter<StatisticsFragment, StatisticsFragmentModel, IFStatistical.P> {
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
        };
    }
}
