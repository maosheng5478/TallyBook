package com.android.tallybook.mvp.presenter.fragmentPresenter;

import com.android.tallybook.baseMVP.BaseMVPPresenter;
import com.android.tallybook.mvp.iFragment.IFExprenses;
import com.android.tallybook.mvp.model.fragmentModel.ExprensesFragmentModel;
import com.android.tallybook.mvp.view.fragment.ExprensesFragment;

public class ExprensesFragmentPresenter extends BaseMVPPresenter<ExprensesFragment, ExprensesFragmentModel, IFExprenses.P> {
    @Override
    public ExprensesFragmentModel getModelInstence() {
        return new ExprensesFragmentModel(this);
    }

    @Override
    public IFExprenses.P getContract() {
        return null;
    }
}
