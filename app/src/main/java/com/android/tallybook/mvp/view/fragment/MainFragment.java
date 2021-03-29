package com.android.tallybook.mvp.view.fragment;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.android.tallybook.R;
import com.android.tallybook.adapter.BillsListViewAdapter;
import com.android.tallybook.baseMVP.BaseMVPFragment;
import com.android.tallybook.bean.BillBean;
import com.android.tallybook.customView.ListViewForScrollView;
import com.android.tallybook.mvp.iFragment.IFMain;
import com.android.tallybook.mvp.presenter.fragmentPresenter.MainFragmentPresenter;
import com.android.tallybook.mvp.view.SearchAcivity;
import com.android.tallybook.utils.ActivityUtils;
import com.android.tallybook.utils.LogUtils;
import com.android.tallybook.utils.ToastUtils;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends BaseMVPFragment<MainFragmentPresenter, IFMain.V> {

    private TextView fmain_tv_search;
    private TextView fmain_iv_nodata;
    private FloatingActionButton fmain_fab_addbill;
    private RelativeLayout fmain_layout_count;
    private ListViewForScrollView fmain_lvfsv_list;
    //private ScrollView fmain_sv_page;
    //private RelativeLayout fmain_layout_r1;


    private BillsListViewAdapter adapter;
    private static List<BillBean> billBeans = new ArrayList<>();

    @Override
    public IFMain.V getContract() {
        return new IFMain.V() {
            @Override
            public void findBillData() {
                mPresenter.getContract().findBillData();
            }

            @Override
            public void respondDataUpdate(List<BillBean> list) {
                MainFragment.billBeans = list;
            }
        };
    }

    @Override
    public void initView() {
        //fmain_layout_r1 = getActivity().findViewById(R.id.fmain_layout_r1);
        //fmain_sv_page = getActivity().findViewById(R.id.fmain_sv_page);

       fmain_tv_search = getActivity().findViewById(R.id.fmain_tv_search);
       fmain_iv_nodata = getActivity().findViewById(R.id.fmain_iv_nodata);
       fmain_layout_count = getActivity().findViewById(R.id.fmain_layout_count);
       fmain_lvfsv_list = getActivity().findViewById(R.id.fmain_lvfsv_list);
       fmain_fab_addbill = getActivity().findViewById(R.id.fmain_fab_addbill);
    }

    @Override
    public void initListener() {
        fmain_tv_search.setOnClickListener(v -> {
            //search special data
            ActivityUtils.go(getContext(), SearchAcivity.class);
        });
        fmain_fab_addbill.setOnClickListener(v -> {
            //jump to add data page
        });
        fmain_layout_count.setOnClickListener(v -> {
            //set change year`s or mouth`s data
        });

    }

    @Override
    public int getContextView() {
        return R.layout.fragment_main;
    }

    @Override
    public void initData() {
        //初始化文字，让图片加载到textview上
        ImageSpan imgSpan = new ImageSpan(this.getActivity(), R.drawable.ic_search);
        SpannableString spannableString = new SpannableString(" 搜索账单");
        spannableString.setSpan(imgSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        fmain_tv_search.setText(spannableString);
        //初始化账单列表数据
        getContract().findBillData();


    }

    @Override
    public void onResume() {
        super.onResume();
        if (billBeans.size() != 0){
            fmain_iv_nodata.setVisibility(View.GONE);
        }else {
            fmain_iv_nodata.setVisibility(View.VISIBLE);
        }

        adapter = new BillsListViewAdapter(getContext(),billBeans);
        fmain_lvfsv_list.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    @Override
    public MainFragmentPresenter getPresenterInstance() {
        return new MainFragmentPresenter();
    }

    @Override
    public <ERROR> void responrse(ERROR error, Throwable throwable) {

    }

    @Override
    public void destroy() {

    }
}
