package com.android.tallybook.mvp.view.fragment;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.android.tallybook.R;
import com.android.tallybook.adapter.FragmentViewPageAdapter;
import com.android.tallybook.baseMVP.BaseMVPFragment;
import com.android.tallybook.bean.DataItem;
import com.android.tallybook.customView.discView.DiscView;
import com.android.tallybook.mvp.iFragment.IFStatistical;
import com.android.tallybook.mvp.presenter.fragmentPresenter.StatisticsFragmentPresenter;
import com.android.tallybook.utils.LogUtils;
import com.android.tallybook.utils.TabLayoutUtils;
import com.android.tallybook.utils.WeakHandler;
import com.google.android.material.tabs.TabLayout;
import com.lihang.chart.ChartCircleView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static androidx.fragment.app.FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;

public class StatisticsFragment extends BaseMVPFragment<StatisticsFragmentPresenter, IFStatistical.V> {

    private DiscView fsta_dv;
    private ChartCircleView fsta_ccv;
    private TabLayout fsta_tl;
    private ViewPager fsta_vp;

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
        //fsta_ccv = getActivity().findViewById(R.id.fsta_ccv);
        fsta_tl = getActivity().findViewById(R.id.fsta_tl);
        fsta_vp = getActivity().findViewById(R.id.fsta_vp);

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
