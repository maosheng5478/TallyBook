package com.android.tallybook.mvp.presenter.fragmentPresenter;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.android.tallybook.baseMVP.BaseMVPPresenter;
import com.android.tallybook.bean.BillBean;
import com.android.tallybook.mvp.iFragment.IFExprenses;
import com.android.tallybook.mvp.model.fragmentModel.ExprensesFragmentModel;
import com.android.tallybook.mvp.view.fragment.ExprensesFragment;
import com.lihang.chart.ChartCircleItem;
import com.lihang.chart.ChartCircleView;

import java.util.ArrayList;
import java.util.List;

public class ExprensesFragmentPresenter extends BaseMVPPresenter<ExprensesFragment, ExprensesFragmentModel, IFExprenses.P> {
    @Override
    public ExprensesFragmentModel getModelInstence() {
        return new ExprensesFragmentModel(this);
    }

    @Override
    public IFExprenses.P getContract() {
        return new IFExprenses.P() {
            @Override
            public void initCircleViewData(ChartCircleView chartCircleView, int[] colors, RelativeLayout rl, LinearLayout ll, View view) {
                BillBean billBean;
                ArrayList<ChartCircleItem> item = new ArrayList<>();
                int color = 0;
                List<BillBean> billBeanList = mModel.getContract().expenses();
                if (billBeanList.size() == 0){
                    item.add(new ChartCircleItem(1,colors[1],"null"));
                    rl.setVisibility(View.GONE);
                    ll.setVisibility(View.VISIBLE);
                    getContract().lineShow(view,false);
                }else {
                    rl.setVisibility(View.VISIBLE);
                    ll.setVisibility(View.GONE);
                    getContract().lineShow(view,true);
                    for (int i = 0; i < billBeanList.size(); i++) {
                        if (color > colors.length) {
                            color = 0;
                        }
                        billBean = billBeanList.get(i);
                        item.add(new ChartCircleItem((int) Double.parseDouble(billBean.getCost()), colors[color], billBean.getBillname()));
                        color++;
                    }
                }
                chartCircleView.setItems(item);
            }

            @Override
            public void initListView() {
                getContract().showListData(mModel.getContract().expenses());
            }

            @Override
            public void showListData(List<BillBean> list) {
                mView.getContract().showListData(list);
            }

            @Override
            public void lineShow(View view, boolean b) {
                if (b){
                    view.setVisibility(View.VISIBLE);
                }else {
                    view.setVisibility(View.GONE);
                }
            }
        };
    }
}
