package com.android.tallybook.mvp.view.fragment;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.android.tallybook.R;
import com.android.tallybook.adapter.BillsListViewAdapter;
import com.android.tallybook.baseMVP.BaseMVPFragment;
import com.android.tallybook.bean.BillBean;
import com.android.tallybook.customView.ListViewForScrollView;
import com.android.tallybook.mvp.iFragment.IFExprenses;
import com.android.tallybook.mvp.presenter.fragmentPresenter.ExprensesFragmentPresenter;
import com.android.tallybook.utils.LogUtils;
import com.lihang.chart.ChartCircleItem;
import com.lihang.chart.ChartCircleView;

import java.util.ArrayList;
import java.util.List;

public class ExprensesFragment extends BaseMVPFragment<ExprensesFragmentPresenter, IFExprenses.V> {

    private ChartCircleView fexp_ccv;
    private LinearLayout fexp_ll_nodata;
    private RelativeLayout fexp_rl_sta;
    private ListViewForScrollView fexp_lfs;
    private View fexp_v_line;

    private BillsListViewAdapter adapter;
    private static List<BillBean> billBeans = new ArrayList<>();

    private final int[] colors = {R.color.color1,R.color.color2,R.color.color3,R.color.color4,R.color.color5,R.color.color6,
            R.color.color7,R.color.color8,R.color.color9,R.color.color10,R.color.green,R.color.color11,
            R.color.color12, R.color.color13,R.color.color14,R.color.color15};

    @Override
    public IFExprenses.V getContract() {
        return new IFExprenses.V() {
            @Override
            public void initCircleViewData(ChartCircleView chartCircleView, int[] colors,RelativeLayout rl,LinearLayout ll,View view) {
                mPresenter.getContract().initCircleViewData(chartCircleView,colors ,rl,ll,view);
            }

            @Override
            public void initListView() {
                mPresenter.getContract().initListView();
            }

            @Override
            public void showListData(List<BillBean> list) {
                ExprensesFragment.billBeans = list;
            }
        };
    }

    @Override
    public void initView() {
        fexp_ccv = getActivity().findViewById(R.id.fexp_ccv);
        fexp_ll_nodata = getActivity().findViewById(R.id.fexp_ll_nodata);
        fexp_rl_sta = getActivity().findViewById(R.id.fexp_rl_sta);
        fexp_lfs = getActivity().findViewById(R.id.fexp_lfs);
        fexp_v_line = getActivity().findViewById(R.id.fexp_v_line);
    }

    @Override
    public void initListener() {

    }

    @Override
    public int getContextView() {
        return R.layout.fragment_exprenses;
    }

    @Override
    public void initData() {
        fexp_rl_sta.setVisibility(View.GONE);
        fexp_ll_nodata.setVisibility(View.VISIBLE);
        getContract().initCircleViewData(fexp_ccv,colors,fexp_rl_sta,fexp_ll_nodata,fexp_v_line);
        getContract().initListView();
    }

    @Override
    public void onResume() {
        super.onResume();
        getContract().initCircleViewData(fexp_ccv,colors,fexp_rl_sta,fexp_ll_nodata,fexp_v_line);
        adapter = new BillsListViewAdapter(getContext(),billBeans);
        fexp_lfs.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public ExprensesFragmentPresenter getPresenterInstance() {
        return new ExprensesFragmentPresenter();
    }

    @Override
    public <ERROR> void responrse(ERROR error, Throwable throwable) {

    }

    @Override
    public void destroy() {

    }

}
