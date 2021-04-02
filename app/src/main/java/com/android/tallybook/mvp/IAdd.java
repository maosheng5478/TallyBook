package com.android.tallybook.mvp;

import com.android.tallybook.bean.BillBean;

public interface IAdd {
    interface V{
        void requestInsert(BillBean bean);

        void respondInsert(boolean flag);

        void updateBill(BillBean bean);
    }
    interface P{
        void requestInsert(BillBean bean);

        void respondInsert(boolean flag);

        void updateBill(BillBean bean);
    }
    interface M{
        void requestInsert(BillBean bean);

        void respondInsert(boolean flag);

        void updateBill(BillBean bean);
    }
}
