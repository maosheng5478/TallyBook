package com.android.tallybook.mvp.iFragment;

import com.android.tallybook.bean.BillBean;
import com.google.android.material.tabs.TabLayout;
import com.lihang.chart.ChartCircleView;

import java.util.List;

public interface IFStatistical {
    interface V{
        void tabinit(TabLayout fsta_tl);
    }
    interface P{
        void tabinit(TabLayout fsta_tl);
    }
    interface M{
        List<BillBean> selectExpenses();

        List<BillBean> selectIncome();
    }

}
