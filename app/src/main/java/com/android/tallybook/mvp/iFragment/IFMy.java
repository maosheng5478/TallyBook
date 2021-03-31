package com.android.tallybook.mvp.iFragment;

import android.widget.ImageView;
import android.widget.TextView;

public interface IFMy {
    interface V{
        void initSeeView(ImageView imageView, TextView tv1, TextView tv2, TextView tv3);
    }

    interface P{
        void initSeeView(ImageView imageView,TextView tv1,TextView tv2,TextView tv3);
    }
    interface M{
        Double selectExpenses();

        Double selectIncome();
    }
}
