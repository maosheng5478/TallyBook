package com.android.tallybook.mvp.iFragment;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.android.tallybook.bean.BillBean;
import com.lihang.chart.ChartCircleView;

import java.util.List;

public interface IFExprenses {
    interface V{

        void initCircleViewData(ChartCircleView chartCircleView, int[] colors, RelativeLayout relativeLayout, LinearLayout linearLayout, View view);

        void initListView();

        void showListData(List<BillBean> list);

    }

    interface P{
        void initCircleViewData(ChartCircleView chartCircleView, int[] colors, RelativeLayout relativeLayout, LinearLayout linearLayout, View view);

        void initListView();

        void showListData(List<BillBean> list);

        void lineShow(View view,boolean b);
    }
    interface M{
        List<BillBean> expenses();
    }
}
