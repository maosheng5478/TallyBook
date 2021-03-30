package com.android.tallybook.mvp.presenter.fragmentPresenter;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.android.tallybook.base.BasePresenter;
import com.android.tallybook.bean.BillBean;
import com.android.tallybook.mvp.iFragment.IFIncome;
import com.android.tallybook.mvp.model.fragmentModel.IncomeFragmentModel;
import com.android.tallybook.mvp.view.fragment.IncomeFragment;
import com.lihang.chart.ChartCircleItem;
import com.lihang.chart.ChartCircleView;

import java.util.ArrayList;
import java.util.List;

public class IncomeFragmentPresenter extends BasePresenter<IncomeFragment, IncomeFragmentModel, IFIncome.P> {
    @Override
    public IncomeFragmentModel getModelInstence() {
        return new IncomeFragmentModel(this);
    }

    @Override
    public IFIncome.P getContract() {
        return new IFIncome.P() {
            @Override
            public void initCircleViewData(ChartCircleView fincome_ccv, int[] colors, RelativeLayout rl, LinearLayout ll, View view) {
                BillBean billBean;
                ArrayList<ChartCircleItem> item = new ArrayList<>();
                int color = 0;
                List<BillBean> billBeanList = mModel.getContract().income();
                if (billBeanList.size() == 0){
                    item.add(new ChartCircleItem(1,colors[1],"null"));
                    rl.setVisibility(View.GONE);
                    ll.setVisibility(View.VISIBLE);
                    getContract().lineShow(view,false);
                }else {
                    getContract().lineShow(view,true);
                    rl.setVisibility(View.VISIBLE);
                    ll.setVisibility(View.GONE);
                    for (int i = 0; i < billBeanList.size(); i++) {
                        if (color > colors.length) {
                            color = 0;
                        }
                        billBean = billBeanList.get(i);
                        item.add(new ChartCircleItem((int) Double.parseDouble(billBean.getCost()), colors[color], billBean.getBillname()));
                        color++;
                    }
                }
                fincome_ccv.setItems(item);
            }

            @Override
            public void initListView() {
                getContract().showListData(mModel.getContract().income());
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
                    view.setVisibility(View.INVISIBLE);
                }
            }
        };
    }
}
