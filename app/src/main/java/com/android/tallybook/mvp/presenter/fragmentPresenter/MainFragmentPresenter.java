package com.android.tallybook.mvp.presenter.fragmentPresenter;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.android.tallybook.R;
import com.android.tallybook.base.BasePresenter;
import com.android.tallybook.bean.BillBean;
import com.android.tallybook.customView.CustomDialog;
import com.android.tallybook.customView.DialogFromBottom;
import com.android.tallybook.customView.ListViewForScrollView;
import com.android.tallybook.mvp.model.fragmentModel.MainFragmentModel;
import com.android.tallybook.mvp.iFragment.IFMain;
import com.android.tallybook.mvp.view.fragment.MainFragment;
import com.android.tallybook.utils.DateUtils;
import com.android.tallybook.utils.ToastUtils;

import java.text.ParseException;
import java.util.List;

public class MainFragmentPresenter extends BasePresenter<MainFragment, MainFragmentModel, IFMain.P> {
    @Override
    public MainFragmentModel getModelInstence() {
        return new MainFragmentModel(this);
    }

    @Override
    public IFMain.P getContract() {
        return new IFMain.P() {
            @Override
            public void findBillData() {
                mModel.getContract().findBillData();
            }

            @Override
            public void respondDataUpdate(List<BillBean> list) {
                mView.getContract().respondDataUpdate(list);
            }

            @SuppressLint("DefaultLocale")
            @Override
            public void initSeeView(TextView tv1, TextView tv2, TextView tv3) {
                double exp = mModel.getContract().selectExpenses();
                double income = mModel.getContract().selectIncome();
                tv1.setText(String.format("%.2f",income - exp ));
                tv2.setText(String.format("%.2f",income));
                tv3.setText(String.format("%.2f",exp));
            }

            @Override
            public void listviewItemClick(ListViewForScrollView listViewForScrollView, List<BillBean> billBeans) {
                listViewForScrollView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        try {
                            String cost = billBeans.get(position).getCost();
                            if (billBeans.get(position).getFlow().equals("支出")){
                                cost = "-" + cost;
                            }
                            CustomDialog mDialog = new CustomDialog(mView.getContext(), billBeans.get(position).getBillname(),
                                    cost, DateUtils.getDateFormatForC(billBeans.get(position).getTime()));

                            mDialog.setCanceledOnTouchOutside(false);
                            mDialog.show();
                            mDialog.setCallBack(new CustomDialog.callBack() {
                                @Override
                                public void editListener() {
                                    //jump to edit page
                                }

                                @Override
                                public void deletListener() {
                                    DialogFromBottom dialogFromBottom = new DialogFromBottom(mView.getContext());
                                    dialogFromBottom.show();
                                    dialogFromBottom.setCallback(new DialogFromBottom.callback() {
                                        @Override
                                        public void setConfirmListener() {
                                            mModel.getContract().deletBill(billBeans.get(position).getId());
                                            mView.onResume();
                                            dialogFromBottom.dismiss();
                                            mDialog.cancel();
                                        }
                                    });
                                }
                            });
                        } catch (ParseException e) {
                            e.printStackTrace();
                            mView.responrse("date-error",e);
                        }
                    }
                });
            }
        };
    }
}
