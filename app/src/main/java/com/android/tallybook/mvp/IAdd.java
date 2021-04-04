package com.android.tallybook.mvp;

import android.widget.TextView;

import com.android.tallybook.bean.BillBean;
import com.android.tallybook.customView.date.CustomDatePicker;

public interface IAdd {
    interface V{
        void requestInsert(BillBean bean);

        void respondInsert(boolean flag);

        void updateBill(BillBean bean);

        CustomDatePicker initDatePicker(CustomDatePicker startDatePicker, TextView textView);

        void buttonOnclick(String text,String number,TextView textView);
    }
    interface P{
        void requestInsert(BillBean bean);

        void respondInsert(boolean flag);

        void updateBill(BillBean bean);

        CustomDatePicker initDatePicker(CustomDatePicker startDatePicker,TextView textView);

        void buttonOnclick(String text,String number,TextView textView);
    }
    interface M{
        void requestInsert(BillBean bean);

        void respondInsert(boolean flag);

        void updateBill(BillBean bean);
    }
}
