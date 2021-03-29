package com.android.tallybook.mvp.iFragment;

import com.android.tallybook.bean.BillBean;

import java.util.List;

public interface IFExprenses {
    interface V{
        void initCircleViewData();
    }

    interface P{
        void initCircleViewData();
    }
    interface M{
        List<BillBean> expenses();
    }
}
