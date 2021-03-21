package com.android.tallybook.mvp.presenter.fragmentPresenter;

import com.android.tallybook.baseMVP.BaseMVPPresenter;
import com.android.tallybook.mvp.iFragment.IFMy;
import com.android.tallybook.mvp.model.fragmentModel.MyFragmentModel;
import com.android.tallybook.mvp.view.fragment.MyFragment;

public class MyFragmentPresenter extends BaseMVPPresenter<MyFragment, MyFragmentModel, IFMy.P> {
    @Override
    public MyFragmentModel getModelInstence() {
        return new MyFragmentModel(this);
    }

    @Override
    public IFMy.P getContract() {
        return null;
    }
}
