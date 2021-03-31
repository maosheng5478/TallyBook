package com.android.tallybook.mvp.view.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.android.tallybook.R;
import com.android.tallybook.adapter.FragmentViewPageAdapter;
import com.android.tallybook.base.BaseFragment;
import com.android.tallybook.customView.discView.DiscView;
import com.android.tallybook.mvp.iFragment.IFStatistical;
import com.android.tallybook.mvp.presenter.fragmentPresenter.StatisticsFragmentPresenter;
import com.android.tallybook.utils.LogUtils;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class StatisticsFragment extends BaseFragment<StatisticsFragmentPresenter, IFStatistical.V> {

    private DiscView fsta_dv;
    private TabLayout fsta_tl;
    private ViewPager fsta_vp;
    private TextView fsta_exp;
    private TextView fsta_income;
    private TextView fsta_remain;

    private List<Fragment> fragmentList;
    private FragmentViewPageAdapter adapter;
    private final String[] titles = {"支出","收入"};

    @Override
    public IFStatistical.V getContract() {
        return new IFStatistical.V() {
            @Override
            public void tabinit(TabLayout tabLayout) {
                mPresenter.getContract().tabinit(tabLayout);
            }

            @Override
            public void setTextViewData(TextView exp, TextView income, TextView remain) {
                mPresenter.getContract().setTextViewData(exp,income,remain);
            }
        };
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void initView() {
        fsta_dv = getActivity().findViewById(R.id.fsta_dv);
        fsta_tl = getActivity().findViewById(R.id.fsta_tl);
        fsta_vp = getActivity().findViewById(R.id.fsta_vp);
        fsta_exp = getActivity().findViewById(R.id.fsta_exp);
        fsta_income = getActivity().findViewById(R.id.fsta_income);
        fsta_remain = getActivity().findViewById(R.id.fsta_remain);

    }

    @Override
    public void initListener() {

    }

    @Override
    public int getContextView() {
        return R.layout.fragment_statistics;
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    public void initData() {
        /*List<DataItem> items = new ArrayList<>();
        items.add(new DataItem(1,"2","2",getContext().getResources().getColor(R.color.green)));
        items.add(new DataItem(1,"2","2",getContext().getResources().getColor(R.color.red)));
        fsta_dv.setItems(items);*/
        fragmentList = new ArrayList<>();
        fragmentList.add(new ExprensesFragment());
        fragmentList.add(new IncomeFragment());
        adapter = new FragmentViewPageAdapter(getChildFragmentManager(),fragmentList,titles);
        fsta_vp.setAdapter(adapter);
        fsta_tl.setupWithViewPager(fsta_vp);
        getContract().tabinit(fsta_tl);

        getContract().setTextViewData(fsta_exp,fsta_income,fsta_remain);

    }
    @Override
    public void onPause() {
        super.onPause();
        LogUtils.d("Sta","onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        LogUtils.d("Sta","onStop");
    }

    @Override
    public void onStart() {
        super.onStart();
        LogUtils.d("Sta","onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        LogUtils.d("Sta","onResume");
    }

    @Override
    public StatisticsFragmentPresenter getPresenterInstance() {
        return new StatisticsFragmentPresenter();
    }

    @Override
    public <ERROR> void responrse(ERROR error, Throwable throwable) {

    }

    @Override
    public void destroy() {

    }
}
