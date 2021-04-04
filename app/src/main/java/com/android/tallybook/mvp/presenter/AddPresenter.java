package com.android.tallybook.mvp.presenter;

import android.annotation.SuppressLint;
import android.widget.TextView;

import com.android.tallybook.base.BasePresenter;
import com.android.tallybook.bean.BillBean;
import com.android.tallybook.customView.date.CustomDatePicker;
import com.android.tallybook.mvp.IAdd;
import com.android.tallybook.mvp.model.AddModel;
import com.android.tallybook.mvp.view.AddActivity;
import com.android.tallybook.utils.DateUtils;
import com.android.tallybook.utils.StringUtils;
import com.android.tallybook.utils.ToastUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AddPresenter extends BasePresenter<AddActivity, AddModel, IAdd.P> {
    @Override
    public AddModel getModelInstence() {
        return new AddModel(this);
    }

    @Override
    public IAdd.P getContract() {
        return new IAdd.P() {
            @Override
            public void requestInsert(BillBean bean) {
                //逻辑判断
                if ("0".equals(bean.getCost())){
                    ToastUtils.showToast(mView,"金额不能为0");
                    return;
                }else if ("".equals(bean.getBillname())){
                    ToastUtils.showToast(mView,"账单分类不能为空");
                    return;
                }
                mModel.getContract().requestInsert(bean);
            }

            @Override
            public void respondInsert(boolean flag) {
                mView.getContract().respondInsert(flag);
            }

            @Override
            public void updateBill(BillBean bean) {
                if ("".equals(bean.getCost())){
                    ToastUtils.showToast(mView,"金额不能为0");
                    return;
                }else if ("".equals(bean.getBillname())){
                    ToastUtils.showToast(mView,"账单分类不能为空");
                    return;
                }
                mModel.getContract().updateBill(bean);
            }

            @Override
            public CustomDatePicker initDatePicker(CustomDatePicker startDatePicker, TextView textView) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
                String now = sdf.format(new Date());

                startDatePicker = new CustomDatePicker(mView, new CustomDatePicker.ResultHandler() {
                    @Override
                    public void handle(String time) { // 回调接口，获得选中的时间
                        try {
                            //ToastUtils.showToast(mView, time);
                            textView.setText(DateUtils.getDateFormat(time.substring(0,10).replace("-","")));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                }, "2010-01-01 00:00", now); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
                startDatePicker.showSpecificTime(false); // 不显示时和分
                startDatePicker.setIsLoop(false); // 不允许循环滚动
                return startDatePicker;
            }

            @SuppressLint("SetTextI18n")
            @Override
            public void buttonOnclick(String text, String number, TextView add_tv_count) {
                if (StringUtils.isTwoDecimal(text)) {
                    if (StringUtils.existString(text,"+") || StringUtils.existString(text,"-")) {
                        if ( StringUtils.existString(text,"-") ){
                            if ("-".equals(StringUtils.finalString(text))) {
                                add_tv_count.setText(text+number);
                            }else {
                                String h = StringUtils.afterString(text, "-");
                                String q = StringUtils.beforeString(text,"-");
                                if (!StringUtils.isTwoDecimal(h)){
                                    add_tv_count.setText(text+number);
                                }
                            }
                        }else if ( StringUtils.existString(text,"+")){
                            if ("+".equals(StringUtils.finalString(text))) {
                                add_tv_count.setText(text+"2");
                            }else {
                                String h = StringUtils.afterString(text, "+");
                                String q = StringUtils.beforeString(text,"+");
                                if (!StringUtils.isTwoDecimal(h)){
                                    add_tv_count.setText(text+number);
                                }
                            }
                        }
                        //add_tv_count.setText(text+"2");
                    }else {
                        //add_tv_count.setText(StringUtils.setTwoDecimal(text));
                        add_tv_count.setText(text+number);
                    }
                }else {
                    if (!"0".equals(text) && !"0.0".equals(text) && !"0.00".equals(text)){
                        add_tv_count.setText(text+number);
                    }else {
                        add_tv_count.setText(number);
                    }
                }
            }
        };
    }
}
