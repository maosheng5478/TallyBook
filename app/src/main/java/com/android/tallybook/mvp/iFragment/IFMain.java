package com.android.tallybook.mvp.iFragment;

import android.widget.TextView;

import com.android.tallybook.bean.BillBean;
import com.android.tallybook.customView.ListViewForScrollView;

import java.util.List;

public interface IFMain {
    interface V{

        void findBillData();

        void respondDataUpdate(List<BillBean> list);

        void initSeeView(TextView tv1, TextView tv2, TextView tv3);

        void listviewItemClick(ListViewForScrollView listViewForScrollView,List<BillBean> billBeans);
    }

    interface P{

        void findBillData();

        void respondDataUpdate(List<BillBean> list);

        void initSeeView(TextView tv1, TextView tv2, TextView tv3);

        void listviewItemClick(ListViewForScrollView listViewForScrollView,List<BillBean> billBeans);
    }

    interface M{

        void findBillData();

        Double selectExpenses();

        Double selectIncome();

        void deletBill(int i);
    }
}
