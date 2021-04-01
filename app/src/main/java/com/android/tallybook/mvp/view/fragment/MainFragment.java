package com.android.tallybook.mvp.view.fragment;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.tallybook.R;
import com.android.tallybook.adapter.BillsListViewAdapter;
import com.android.tallybook.base.BaseFragment;
import com.android.tallybook.bean.BillBean;
import com.android.tallybook.customView.ListViewForScrollView;
import com.android.tallybook.mvp.iFragment.IFMain;
import com.android.tallybook.mvp.presenter.fragmentPresenter.MainFragmentPresenter;
import com.android.tallybook.mvp.view.SearchAcivity;
import com.android.tallybook.utils.ActivityUtils;
import com.android.tallybook.utils.LogUtils;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends BaseFragment<MainFragmentPresenter, IFMain.V> {

    private TextView fmain_tv_search;
    private TextView fmain_iv_nodata;
    private FloatingActionButton fmain_fab_addbill;
    private RelativeLayout fmain_layout_count;
    private ListViewForScrollView fmain_lvfsv_list;
    private TextView fmain_tv_num;
    private TextView fmain_tv_in;
    private TextView fmain_tv_out;
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

            @Override
            public void initSeeView(TextView tv1, TextView tv2, TextView tv3) {
                mPresenter.getContract().initSeeView(tv1,tv2,tv3);
            }

            @Override
            public void listviewItemClick(ListViewForScrollView listViewForScrollView, List<BillBean> billBeans) {
                mPresenter.getContract().listviewItemClick(listViewForScrollView, billBeans);
            }
        };
    }

    @Override
    public void initView() {
        //fmain_layout_r1 = getActivity().findViewById(R.id.fmain_layout_r1);
        fmain_tv_search = getActivity().findViewById(R.id.fmain_tv_search);
        fmain_iv_nodata = getActivity().findViewById(R.id.fmain_iv_nodata);
        fmain_layout_count = getActivity().findViewById(R.id.fmain_layout_count);
        fmain_lvfsv_list = getActivity().findViewById(R.id.fmain_lvfsv_list);
        fmain_fab_addbill = getActivity().findViewById(R.id.fmain_fab_addbill);
        fmain_tv_num = getActivity().findViewById(R.id.fmain_tv_num);
        fmain_tv_in = getActivity().findViewById(R.id.fmain_tv_in);
        fmain_tv_out = getActivity().findViewById(R.id.fmain_tv_out);
    }

    @Override
    public void initListener() {
        fmain_tv_search.setOnClickListener(v -> {
            //search special data
            ActivityUtils.go(getContext(), SearchAcivity.class);
            getActivity().overridePendingTransition(R.anim.lr_in, R.anim.lr_out);
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


    }

    @Override
    public void onPause() {
        super.onPause();
        LogUtils.d("Main","onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        LogUtils.d("Main","onStop");
    }

    @Override
    public void onStart() {
        super.onStart();
        LogUtils.d("Main","onStart");
    }

    @Override
    public void onResume() {
        getContract().findBillData();
        LogUtils.d("Main","onResume");
        super.onResume();
        if (billBeans.size() != 0){
            fmain_iv_nodata.setVisibility(View.GONE);
        }else {
            fmain_iv_nodata.setVisibility(View.VISIBLE);
        }

        adapter = new BillsListViewAdapter(getContext(),billBeans);
        fmain_lvfsv_list.setAdapter(adapter);
        getContract().listviewItemClick(fmain_lvfsv_list,billBeans );

        getContract().initSeeView(fmain_tv_num,fmain_tv_in,fmain_tv_out);
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
