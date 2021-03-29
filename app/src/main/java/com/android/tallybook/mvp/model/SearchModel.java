package com.android.tallybook.mvp.model;

import android.content.Context;

import com.android.tallybook.MyApplication;
import com.android.tallybook.baseMVP.BaseMVPModel;
import com.android.tallybook.bean.BillBean;
import com.android.tallybook.mvp.ISearch;
import com.android.tallybook.mvp.presenter.SearchPresenter;
import com.android.tallybook.sqlite.dao.BillDao;

import java.util.List;

public class SearchModel extends BaseMVPModel<SearchPresenter, ISearch.M> {

    private BillBean billBean;
    private BillDao dao ;
    private final Context context = MyApplication.getContext();

    public SearchModel(SearchPresenter mPresenter) {
        super(mPresenter);
    }

    @Override
    public ISearch.M getContract() {
        return new ISearch.M() {
            @Override
            public void searchBills(String key) {
                dao = new BillDao(context);
                List<BillBean> billDaoList = dao.blurredQury(key);
                mPresenter.getContract().respondSearch(billDaoList);
                //System.out.println(billDaoList);
            }
        };
    }
}
