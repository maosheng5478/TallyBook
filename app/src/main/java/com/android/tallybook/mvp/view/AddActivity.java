package com.android.tallybook.mvp.view;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.android.tallybook.R;
import com.android.tallybook.base.BaseActivity;
import com.android.tallybook.bean.BillBean;
import com.android.tallybook.customView.date.CustomDatePicker;
import com.android.tallybook.mvp.IAdd;
import com.android.tallybook.mvp.presenter.AddPresenter;
import com.android.tallybook.utils.ActivityUtils;
import com.android.tallybook.utils.DateUtils;
import com.android.tallybook.utils.StringUtils;
import com.android.tallybook.utils.ToastUtils;

public class AddActivity extends BaseActivity<AddPresenter, IAdd.V> {

    private String flow;
    private RadioButton radioButton;
    private int add_rb;

    private RadioGroup add_rg_class;
    private LinearLayout add_ll_back;
    private LinearLayout add_ll_datechoose;
    private TextView add_tv_date;
    private Button add_btn_0;
    private Button add_btn_1;
    private Button add_btn_2;
    private Button add_btn_3;
    private Button add_btn_4;
    private Button add_btn_5;
    private Button add_btn_6;
    private Button add_btn_7;
    private Button add_btn_8;
    private Button add_btn_9;
    private Button add_btn_dot;
    private Button add_btn_delet;
    private Button add_btn_add;
    private Button add_btn_reduce;
    private Button add_btn_c;
    private Button add_btn_complete;
    private TextView add_tv_count;
    private EditText add_et_name;

    private CustomDatePicker startDatePicker;


    @Override
    public IAdd.V getContract() {
        return new IAdd.V() {
            @Override
            public void requestInsert(BillBean bean) {
                mPresenter.getContract().requestInsert(bean);
            }

            @Override
            public void respondInsert(boolean flag) {
                if (flag){
                    ToastUtils.showToast(AddActivity.this,"账单添加成功");
                }else {
                    ToastUtils.showToast(AddActivity.this,"账单添加失败");
                }
                onBackPressed();
            }

            @Override
            public void updateBill(BillBean bean) {
                mPresenter.getContract().updateBill(bean);
            }

            @Override
            public CustomDatePicker initDatePicker(CustomDatePicker startDatePicker, TextView textView) {
                return mPresenter.getContract().initDatePicker(startDatePicker,textView );
            }

            @Override
            public void buttonOnclick(String text, String number, TextView textView) {
                mPresenter.getContract().buttonOnclick(text,number,textView);
            }
        };
    }

    @Override
    public void initView() {
        add_rg_class = findViewById(R.id.add_rg_class);
        add_ll_back = findViewById(R.id.add_ll_back);
        add_btn_0 = findViewById(R.id.add_bt_0);
        add_btn_1 = findViewById(R.id.add_bt_1);
        add_btn_2 = findViewById(R.id.add_bt_2);
        add_btn_3 = findViewById(R.id.add_bt_3);
        add_btn_4 = findViewById(R.id.add_bt_4);
        add_btn_5 = findViewById(R.id.add_bt_5);
        add_btn_6 = findViewById(R.id.add_bt_6);
        add_btn_7 = findViewById(R.id.add_bt_7);
        add_btn_8 = findViewById(R.id.add_bt_8);
        add_btn_9 = findViewById(R.id.add_bt_9);
        add_btn_dot = findViewById(R.id.add_bt_dot);
        add_btn_c = findViewById(R.id.add_bt_c);
        add_btn_delet = findViewById(R.id.add_bt_delete);
        add_btn_add = findViewById(R.id.add_bt_add);
        add_btn_reduce = findViewById(R.id.add_bt_reduce);
        add_btn_complete = findViewById(R.id.add_bt_complete);
        add_tv_count = findViewById(R.id.add_tv_count);
        add_et_name = findViewById(R.id.add_et_name);

        add_rb= add_rg_class.getCheckedRadioButtonId();
        radioButton = findViewById(add_rb);

        add_ll_datechoose = findViewById(R.id.add_ll_datechoose);
        add_tv_date = findViewById(R.id.add_tv_date);
    }

    @Override
    public void initListener() {
        add_rg_class.setOnCheckedChangeListener((group, checkedId) -> {
            add_rb= group.getCheckedRadioButtonId();
            radioButton = findViewById(add_rb);
            flow = radioButton.getText().toString();
        });
        add_ll_back.setOnClickListener(this);
        add_ll_datechoose.setOnClickListener(this);
        add_btn_0.setOnClickListener(this);
        add_btn_1.setOnClickListener(this);
        add_btn_2.setOnClickListener(this);
        add_btn_3.setOnClickListener(this);
        add_btn_4.setOnClickListener(this);
        add_btn_5.setOnClickListener(this);
        add_btn_6.setOnClickListener(this);
        add_btn_7.setOnClickListener(this);
        add_btn_8.setOnClickListener(this);
        add_btn_9.setOnClickListener(this);
        add_btn_dot.setOnClickListener(this);
        add_btn_c.setOnClickListener(this);
        add_btn_delet.setOnClickListener(this);
        add_btn_add.setOnClickListener(this);
        add_btn_reduce.setOnClickListener(this);
        add_btn_complete.setOnClickListener(this);
    }

    @Override
    public int getContextView() {
        return R.layout.activity_add;
    }

    @Override
    public void initData() {
        flow = radioButton.getText().toString();
        add_tv_date.setText(DateUtils.getCurrentDate());
    }

    @Override
    public AddPresenter getPresenterInstance() {
        return new AddPresenter();
    }

    @Override
    public <ERROR> void responrse(ERROR error, Throwable throwable) {

    }

    @Override
    public void destroy() {

    }

    @SuppressLint({"NonConstantResourceId", "SetTextI18n", "DefaultLocale"})
    @Override
    public void onClick(View v) {
        double befour,after;
        String q,h;
        String text = add_tv_count.getText().toString();
        switch (v.getId()) {
            case R.id.add_ll_back:
                onBackPressed();
                break;
            case R.id.add_ll_datechoose:
                startDatePicker = getContract().initDatePicker(startDatePicker, add_tv_date);
                startDatePicker.show(DateUtils.getCurrentDate());
                break;
            case R.id.add_bt_0:
                getContract().buttonOnclick(text, "0", add_tv_count);
                break;
            case R.id.add_bt_1:
                getContract().buttonOnclick(text, "1", add_tv_count);
                break;
            case R.id.add_bt_2:
                getContract().buttonOnclick(text, "2", add_tv_count);
                break;
            case R.id.add_bt_3:
                getContract().buttonOnclick(text, "3", add_tv_count);
                break;
            case R.id.add_bt_4:
                getContract().buttonOnclick(text, "4", add_tv_count);
                break;
            case R.id.add_bt_5:
                getContract().buttonOnclick(text, "5", add_tv_count);
                break;
            case R.id.add_bt_6:
                getContract().buttonOnclick(text, "6", add_tv_count);
                break;
            case R.id.add_bt_7:
                getContract().buttonOnclick(text, "7", add_tv_count);
                break;
            case R.id.add_bt_8:
                getContract().buttonOnclick(text, "8", add_tv_count);
                break;
            case R.id.add_bt_9:
                getContract().buttonOnclick(text, "9", add_tv_count);
                break;
            case R.id.add_bt_delete:
                if (!"0".equals(text)) {
                    add_tv_count.setText(StringUtils.minusString(text));
                }
                if (text.length() == 1) {
                    add_tv_count.setText("0");
                }
                if (StringUtils.existString(text,"+") || StringUtils.existString(text,"-")){
                    add_btn_complete.setText("=");
                }else {
                    add_btn_complete.setText("完成");
                }
                break;
            case R.id.add_bt_dot:
                if (!StringUtils.existString(text, ".")) {
                    add_tv_count.setText(text + ".");
                } else {
                    if (StringUtils.existString(text, "+") || StringUtils.existString(text, "-")) {
                        add_tv_count.setText(text + ".");
                    }
                }
                break;
            case R.id.add_bt_add:
                add_btn_complete.setText("=");
                if (StringUtils.existString(text, "+") || StringUtils.existString(text, "-")) {
                    if ("-".equals(StringUtils.finalString(text))) {
                        //add_tv_count.setText(String.valueOf("%.2f",befour+after));
                        text = StringUtils.minusString(text);
                        add_tv_count.setText(text + "+");
                    } else if (StringUtils.existString(text, "+")) {
                        befour = Double.parseDouble(StringUtils.beforeString(text, "+"));
                        after = Double.parseDouble(StringUtils.afterString(text, "+"));
                        add_tv_count.setText(String.format("%.2f", befour + after));
                    } else if (StringUtils.existString(text, "-")) {
                        befour = Double.parseDouble(StringUtils.beforeString(text, "-"));
                        after = Double.parseDouble(StringUtils.afterString(text, "-"));
                        add_tv_count.setText(String.format("%.2f", befour - after));
                    }
                } else {
                    add_tv_count.setText(text + " +");
                }
                break;
            case R.id.add_bt_reduce:
                add_btn_complete.setText("=");
                if (StringUtils.existString(text, "+") || StringUtils.existString(text, "-")) {
                    if ("+".equals(StringUtils.finalString(text))) {
                        //add_tv_count.setText(String.valueOf("%.2f",befour+after));
                        text = StringUtils.minusString(text);
                        add_tv_count.setText(text + "-");
                    } else if (StringUtils.existString(text, "+")) {
                        befour = Double.parseDouble(StringUtils.beforeString(text, "+"));
                        after = Double.parseDouble(StringUtils.afterString(text, "+"));
                        add_tv_count.setText(String.format("%.2f", befour + after));
                    } else if (StringUtils.existString(text, "-")) {
                        befour = Double.parseDouble(StringUtils.beforeString(text, "-"));
                        after = Double.parseDouble(StringUtils.afterString(text, "-"));
                        add_tv_count.setText(String.format("%.2f", befour - after));
                    }
                } else {
                    add_tv_count.setText(text + "-");
                }
                break;
            case R.id.add_bt_complete:
                if (StringUtils.existString(text, "+")) {
                    if ("+".equals(StringUtils.finalString(text))) {
                        text = StringUtils.minusString(text);
                        add_tv_count.setText(text);
                        add_btn_complete.setText("完成");
                    }else {
                        befour = Double.parseDouble(StringUtils.beforeString(text, "+"));
                        after = Double.parseDouble(StringUtils.afterString(text, "+"));
                        add_tv_count.setText(String.format("%.2f", befour + after));
                    }
                }else if (StringUtils.existString(text, "-")){
                    if ("-".equals(StringUtils.finalString(text))) {
                        text = StringUtils.minusString(text);
                        add_tv_count.setText(text);
                        add_btn_complete.setText("完成");
                    }else {
                        befour = Double.parseDouble(StringUtils.beforeString(text, "-"));
                        after = Double.parseDouble(StringUtils.afterString(text, "-"));
                        add_tv_count.setText(String.format("%.2f", befour - after));
                        add_btn_complete.setText("完成");
                    }
                } else {
                    BillBean billBean = new BillBean();
                    billBean.setCost(add_tv_count.getText().toString());
                    billBean.setBillname(add_et_name.getText().toString());
                    billBean.setFlow(flow);
                    billBean.setTime(add_tv_date.getText().toString().substring(0, 10).replace("-", ""));
                    getContract().requestInsert(billBean);
                    break;
                }
        }
    }

    @Override
    public void onBackPressed() {
        ActivityUtils.go(AddActivity.this,HomeActivity.class);
        finish();
        overridePendingTransition(R.anim.lr_in_exit, R.anim.lr_out_exit);
    }
}
