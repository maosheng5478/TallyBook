package com.android.tallybook.mvp.presenter;

import com.android.tallybook.base.BasePresenter;
import com.android.tallybook.mvp.IPrefence;
import com.android.tallybook.mvp.model.PrefenceModel;
import com.android.tallybook.mvp.view.PrefenceActivity;

public class PrefencePresenter extends BasePresenter<PrefenceActivity, PrefenceModel, IPrefence.P> {
    @Override
    public PrefenceModel getModelInstence() {
        return null;
    }

    @Override
    public IPrefence.P getContract() {
        return null;
    }
}
