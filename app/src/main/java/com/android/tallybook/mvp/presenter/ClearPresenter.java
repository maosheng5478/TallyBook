package com.android.tallybook.mvp.presenter;

import com.android.tallybook.base.BasePresenter;
import com.android.tallybook.customView.DialogFromBottom;
import com.android.tallybook.mvp.IClear;
import com.android.tallybook.mvp.model.ClearModel;
import com.android.tallybook.mvp.view.ClearActivity;

public class ClearPresenter extends BasePresenter<ClearActivity, ClearModel, IClear.P> {
    @Override
    public ClearModel getModelInstence() {
        return new ClearModel(this);
    }

    @Override
    public IClear.P getContract() {
        return new IClear.P() {
            @Override
            public void clearSQL() {
                DialogFromBottom dialogFromBottom = new DialogFromBottom(mView);
                dialogFromBottom.show();
                dialogFromBottom.setCallback(new DialogFromBottom.callback() {
                    @Override
                    public void setConfirmListener() {
                        mModel.getContract().clearSQL();
                        dialogFromBottom.dismiss();
                    }
                });
            }
        };
    }
}
