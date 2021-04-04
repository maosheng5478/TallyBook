package com.android.tallybook.mvp;

import com.android.tallybook.bean.BillBean;
import com.android.tallybook.customView.ListViewForScrollView;

import java.util.List;

public interface ISearch {
    interface V{
        void searchBills(String key);

        void respondSearch(List<BillBean> list);

        void listviewItemClick(ListViewForScrollView listViewForScrollView, List<BillBean> billBeans);
    }
    interface P{
        void searchBills(String key);

        void respondSearch(List<BillBean> list);

        void listviewItemClick(ListViewForScrollView listViewForScrollView,List<BillBean> billBeans);
    }
    interface M{
        void searchBills(String key);

        void deletBill(int i);
    }
}
