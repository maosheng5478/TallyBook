package com.android.tallybook.mvp.presenter.fragmentPresenter;

import com.android.tallybook.baseMVP.BaseMVPPresenter;
import com.android.tallybook.mvp.iFragment.IFIncome;
import com.android.tallybook.mvp.model.fragmentModel.IncomeFragmentModel;
import com.android.tallybook.mvp.view.fragment.IncomeFragment;

public class IncomeFragmentPresenter extends BaseMVPPresenter<IncomeFragment, IncomeFragmentModel, IFIncome.P>{
    @Override
    public IncomeFragmentModel getModelInstence() {
        return new IncomeFragmentModel(this);
    }

    @Override
    public IFIncome.P getContract() {
        return null;
    }
}
