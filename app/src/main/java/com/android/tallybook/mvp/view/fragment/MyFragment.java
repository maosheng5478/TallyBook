package com.android.tallybook.mvp.view.fragment;

import com.android.tallybook.R;
import com.android.tallybook.baseMVP.BaseMVPFragment;
import com.android.tallybook.mvp.iFragment.IFMy;
import com.android.tallybook.mvp.presenter.fragmentPresenter.MyFragmentPresenter;

public class MyFragment extends BaseMVPFragment<MyFragmentPresenter, IFMy.V> {
    @Override
    public IFMy.V getContract() {
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
        return R.layout.fragment_my;
    }

    @Override
    public void initData() {

    }

    @Override
    public MyFragmentPresenter getPresenterInstance() {
        return new MyFragmentPresenter();
    }

    @Override
    public <ERROR> void responrse(ERROR error, Throwable throwable) {

    }

    @Override
    public void destroy() {

    }
}
