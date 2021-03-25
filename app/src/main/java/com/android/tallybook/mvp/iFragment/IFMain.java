package com.android.tallybook.mvp.iFragment;

import com.android.tallybook.bean.BillBean;

import java.util.List;

public interface IFMain {
    interface V{

        void findBillData();

        void respondDataUpdate(List<BillBean> list);
    }

    interface P{

        void findBillData();

        void respondDataUpdate(List<BillBean> list);
    }

    interface M{

        void findBillData();
    }
}
