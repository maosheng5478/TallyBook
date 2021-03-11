package com.android.tallybook.baseMVP;

public abstract class BaseMVPPresenter<V extends BaseView,M extends BaseMVPModel,CONTRACT> extends SuperBase<CONTRACT> {

    public V mView;

    public M mModel;

    public BaseMVPPresenter() {
        this.mModel = getModelInstence();
    }

    public void bindView(V mView){
        this.mView = mView;
    }

    public void unBindView(){
        this.mView = null;
    }

    public abstract M getModelInstence();
}