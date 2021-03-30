package com.android.tallybook.mvp.iFragment;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.android.tallybook.bean.BillBean;
import com.lihang.chart.ChartCircleView;

import java.util.List;

public interface IFIncome {
    interface V{
        /**
         * @param chartCircleView
         * @param colors
         * @param relativeLayout 统计布局无数据时隐藏
         * @param linearLayout 无数据时显示
         * @param view
         */
        void initCircleViewData(ChartCircleView chartCircleView, int[] colors, RelativeLayout relativeLayout, LinearLayout linearLayout, View view);

        void initListView();

        void showListData(List<BillBean> list);
    }

    interface P{
        /**
         * 加载收入数据
         * @param chartCircleView
         * @param colors
         * @param view
         */
        void initCircleViewData(ChartCircleView chartCircleView, int[] colors, RelativeLayout relativeLayout, LinearLayout linearLayout, View view);

        void initListView();

        void showListData(List<BillBean> list);

        void lineShow(View view,boolean b);
    }
    interface M{
        List<BillBean> income();
    }
}
