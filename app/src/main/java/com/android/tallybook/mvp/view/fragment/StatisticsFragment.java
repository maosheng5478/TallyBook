package com.android.tallybook.mvp.view.fragment;

import com.android.tallybook.R;
import com.android.tallybook.baseMVP.BaseMVPFragment;
import com.android.tallybook.mvp.iFragment.IFStatistical;
import com.android.tallybook.mvp.presenter.fragmentPresenter.StatisticsFragmentPresenter;

public class StatisticsFragment extends BaseMVPFragment<StatisticsFragmentPresenter, IFStatistical.V> {
    @Override
    public IFStatistical.V getContract() {
        return null;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public int getContextView() {
        return R.layout.fragment_statistics;
    }

    @Override
    public void initData() {

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
