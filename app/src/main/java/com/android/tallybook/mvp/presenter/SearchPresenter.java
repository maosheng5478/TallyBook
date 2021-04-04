package com.android.tallybook.mvp.presenter;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;

import com.android.tallybook.base.BasePresenter;
import com.android.tallybook.bean.BillBean;
import com.android.tallybook.customView.CustomDialog;
import com.android.tallybook.customView.DialogFromBottom;
import com.android.tallybook.customView.ListViewForScrollView;
import com.android.tallybook.mvp.ISearch;
import com.android.tallybook.mvp.model.SearchModel;
import com.android.tallybook.mvp.view.SearchAcivity;
import com.android.tallybook.utils.DateUtils;

import java.text.ParseException;
import java.util.List;

public class SearchPresenter extends BasePresenter<SearchAcivity, SearchModel, ISearch.P> {
    @Override
    public SearchModel getModelInstence() {
        return new SearchModel(this);
    }

    @Override
    public ISearch.P getContract() {
        return new ISearch.P() {
            @Override
            public void searchBills(String key) {
                InputMethodManager imm = (InputMethodManager)mView.getSystemService(Context.INPUT_METHOD_SERVICE);
                if(imm.isActive()&&mView.getCurrentFocus()!=null) {
                    if (mView.getCurrentFocus().getWindowToken() != null) {
                        imm.hideSoftInputFromWindow(mView.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

                    }
                }
                mModel.getContract().searchBills(key);
            }

            @Override
            public void respondSearch(List<BillBean> list) {
                mView.getContract().respondSearch(list);
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
                            CustomDialog mDialog = new CustomDialog(mView, billBeans.get(position).getBillname(),
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
                                    DialogFromBottom dialogFromBottom = new DialogFromBottom(mView);
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
