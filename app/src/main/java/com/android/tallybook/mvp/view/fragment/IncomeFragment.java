package com.android.tallybook.mvp.view.fragment;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.android.tallybook.R;
import com.android.tallybook.adapter.BillsListViewAdapter;
import com.android.tallybook.base.BaseFragment;
import com.android.tallybook.bean.BillBean;
import com.android.tallybook.customView.ListViewForScrollView;
import com.android.tallybook.mvp.iFragment.IFIncome;
import com.android.tallybook.mvp.presenter.fragmentPresenter.IncomeFragmentPresenter;
import com.lihang.chart.ChartCircleView;

import java.util.ArrayList;
import java.util.List;

public class IncomeFragment extends BaseFragment<IncomeFragmentPresenter, IFIncome.V> {

    private ChartCircleView fincome_ccv;
    private ListViewForScrollView fincome_lvfsv;
    private LinearLayout fincome_ll_nodata;
    private RelativeLayout fincome_rl_sta;
    private View fincome_v_line;

    private final int[] colors = {R.color.color1,R.color.color2,R.color.color3,R.color.color4,R.color.color5,R.color.color6,
            R.color.color7,R.color.color8,R.color.color9,R.color.color10,R.color.green,R.color.color11,
            R.color.color12, R.color.color13,R.color.color14,R.color.color15};

    private BillsListViewAdapter adapter;
    private static List<BillBean> billBeans = new ArrayList<>();

    @Override
    public IFIncome.V getContract() {
        return new IFIncome.V() {
            @Override
            public void initCircleViewData(ChartCircleView chartCircleView, int[] colors,
                                           RelativeLayout relativeLayout, LinearLayout linearLayout, View view) {
                mPresenter.getContract().initCircleViewData(chartCircleView, colors,relativeLayout,linearLayout,view);
            }

            @Override
            public void initListView() {
                mPresenter.getContract().initListView();
            }

            @Override
            public void showListData(List<BillBean> list) {
                IncomeFragment.billBeans = list;
            }
        };
    }

    @Override
    public void initView() {
        fincome_ccv = getActivity().findViewById(R.id.fincome_ccv);
        fincome_lvfsv = getActivity().findViewById(R.id.fincome_lfs);
        fincome_ll_nodata = getActivity().findViewById(R.id.fincome_ll_nodata);
        fincome_rl_sta = getActivity().findViewById(R.id.fincome_rl_sta);
        fincome_v_line = getActivity().findViewById(R.id.fincome_v_line);
    }

    @Override
    public void initListener() {

    }

    @Override
    public int getContextView() {
        return R.layout.fragment_income;
    }

    @Override
    public void initData() {
        fincome_rl_sta.setVisibility(View.GONE);
        fincome_ll_nodata.setVisibility(View.VISIBLE);
        getContract().initCircleViewData(fincome_ccv,colors, fincome_rl_sta,fincome_ll_nodata,fincome_v_line );
        getContract().initListView();
    }

    @Override
    public void onResume() {
        super.onResume();
        getContract().initCircleViewData(fincome_ccv,colors, fincome_rl_sta,fincome_ll_nodata, fincome_v_line);
    }

    @Override
    public IncomeFragmentPresenter getPresenterInstance() {
        return new IncomeFragmentPresenter();
    }

    @Override
    public <ERROR> void responrse(ERROR error, Throwable throwable) {

    }

    @Override
    public void destroy() {

    }

}
