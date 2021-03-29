package com.android.tallybook.mvp.iFragment;

import com.android.tallybook.bean.BillBean;

import java.util.List;

public interface IFIncome {
    interface V{

    }

    interface P{

    }
    interface M{
        List<BillBean> income();
    }
}
