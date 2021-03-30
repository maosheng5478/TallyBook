package com.android.tallybook.mvp.iFragment;

import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public interface IFStatistical {
    interface V{
        void tabinit(TabLayout fsta_tl);

        void setTextViewData(TextView exp,TextView income,TextView remain);
    }
    interface P{
        void tabinit(TabLayout fsta_tl);

        void setTextViewData(TextView exp,TextView income,TextView remain);
    }
    interface M{
        Double selectExpenses();

        Double selectIncome();
    }

}
