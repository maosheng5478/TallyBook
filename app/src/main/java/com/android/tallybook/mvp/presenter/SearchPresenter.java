package com.android.tallybook.mvp.presenter;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;

import com.android.tallybook.base.BasePresenter;
import com.android.tallybook.bean.BillBean;
import com.android.tallybook.mvp.ISearch;
import com.android.tallybook.mvp.model.SearchModel;
import com.android.tallybook.mvp.view.SearchAcivity;

import java.util.List;

public class SearchPresenter extends BasePresenter<SearchAcivity, SearchModel, ISearch.P> {
    @Override
    public SearchModel getModelInstence() {
        return new SearchModel(this);
    }

    @Override
    public ISearch.P getContract() {
        return new ISearch.P() {
            @Override
            public void searchBills(String key) {
                InputMethodManager imm = (InputMethodManager)mView.getSystemService(Context.INPUT_METHOD_SERVICE);
                if(imm.isActive()&&mView.getCurrentFocus()!=null) {
                    if (mView.getCurrentFocus().getWindowToken() != null) {
                        imm.hideSoftInputFromWindow(mView.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

                    }
                }
                mModel.getContract().searchBills(key);
            }

            @Override
            public void respondSearch(List<BillBean> list) {
                mView.getContract().respondSearch(list);
            }
        };
    }
}
