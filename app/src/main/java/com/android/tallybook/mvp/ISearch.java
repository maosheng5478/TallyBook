package com.android.tallybook.mvp;

import com.android.tallybook.bean.BillBean;

import java.util.List;

public interface ISearch {
    interface V{
        void searchBills(String key);

        void respondSearch(List<BillBean> list);
    }
    interface P{
        void searchBills(String key);

        void respondSearch(List<BillBean> list);
    }
    interface M{
        void searchBills(String key);
    }
}
