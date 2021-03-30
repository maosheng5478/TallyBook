package com.android.tallybook.base;

public abstract class BaseModel<P extends BasePresenter,CONTRACT> extends SuperBase<CONTRACT> {

    public P mPresenter;

    public BaseModel(P mPresenter){
        this.mPresenter = mPresenter;
    }
}
