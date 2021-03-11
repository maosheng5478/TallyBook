package com.android.tallybook.baseMVP;

public abstract class BaseMVPModel<P extends BaseMVPPresenter,CONTRACT> extends SuperBase<CONTRACT> {

    public P mPresenter;

    public BaseMVPModel(P mPresenter){
        this.mPresenter = mPresenter;
    }
}
