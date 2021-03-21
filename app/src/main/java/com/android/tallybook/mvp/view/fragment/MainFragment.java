package com.android.tallybook.mvp.view.fragment;

import com.android.tallybook.R;
import com.android.tallybook.baseMVP.BaseMVPFragment;
import com.android.tallybook.mvp.iFragment.IFMain;
import com.android.tallybook.mvp.presenter.fragmentPresenter.MainFragmentPresenter;

public class MainFragment extends BaseMVPFragment<MainFragmentPresenter, IFMain.V> {
    @Override
    public IFMain.V getContract() {
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
        return R.layout.fragment_main;
    }

    @Override
    public void initData() {

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
