package com.android.tallybook.mvp.presenter.fragmentPresenter;

import com.android.tallybook.baseMVP.BaseMVPPresenter;
import com.android.tallybook.bean.BillBean;
import com.android.tallybook.mvp.model.fragmentModel.MainFragmentModel;
import com.android.tallybook.mvp.iFragment.IFMain;
import com.android.tallybook.mvp.view.fragment.MainFragment;

import java.util.List;

public class MainFragmentPresenter extends BaseMVPPresenter<MainFragment, MainFragmentModel, IFMain.P> {
    @Override
    public MainFragmentModel getModelInstence() {
        return new MainFragmentModel(this);
    }

    @Override
    public IFMain.P getContract() {
        return new IFMain.P() {
            @Override
            public void findBillData() {
                mModel.getContract().findBillData();
            }

            @Override
            public void respondDataUpdate(List<BillBean> list) {
                mView.getContract().respondDataUpdate(list);
            }
        };
    }
}
