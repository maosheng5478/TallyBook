package com.android.tallybook.mvp.presenter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.android.tallybook.R;
import com.android.tallybook.base.BasePresenter;
import com.android.tallybook.mvp.IHome;
import com.android.tallybook.mvp.model.HomeModel;
import com.android.tallybook.mvp.view.HomeActivity;

public class HomePresenter extends BasePresenter<HomeActivity, HomeModel, IHome.P> {
    @Override
    public HomeModel getModelInstence() {
        return new HomeModel(this);
    }

    @Override
    public IHome.P getContract() {
        return new IHome.P() {
            @Override
            public void switchFragment(Fragment[] fragments, int lastfragment, int index) {
                FragmentTransaction transaction =mView.getSupportFragmentManager().beginTransaction();
                transaction.hide(fragments[lastfragment]);//隐藏上个Fragment
                if(!fragments[index].isAdded()) {
                    transaction.add(R.id.home_layout,fragments[index]);

                }
                transaction.show(fragments[index]).commitAllowingStateLoss();
            }
        };
    }
}
