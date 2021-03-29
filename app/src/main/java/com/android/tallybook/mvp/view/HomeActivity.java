package com.android.tallybook.mvp.view;

import android.annotation.SuppressLint;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.android.tallybook.R;
import com.android.tallybook.baseMVP.BaseMVPActivity;
import com.android.tallybook.mvp.IHome;
import com.android.tallybook.mvp.presenter.HomePresenter;
import com.android.tallybook.mvp.view.fragment.MainFragment;
import com.android.tallybook.mvp.view.fragment.MyFragment;
import com.android.tallybook.mvp.view.fragment.StatisticsFragment;
import com.android.tallybook.utils.StatusBarUtils;
import com.android.tallybook.utils.ToastUtils;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends BaseMVPActivity<HomePresenter, IHome.V> {

    private MainFragment mainFragment;
    private MyFragment myFragment;
    private StatisticsFragment statisticsFragment;

    private Fragment[] fragments;
    private int lastfragment;//用于记录上个选择的Fragment

    private BottomNavigationView bottomNavigationView;

    @Override
    public IHome.V getContract() {
        return new IHome.V() {
            @Override
            public void switchFragment(Fragment[] fragments, int lastfragment, int index) {
                mPresenter.getContract().switchFragment(fragments,lastfragment,index);
            }
        };
    }

    @Override
    public void initView() {
        mainFragment = new MainFragment();
        myFragment = new MyFragment();
        statisticsFragment = new StatisticsFragment();
        fragments = new Fragment[]{mainFragment,statisticsFragment,myFragment};
        lastfragment = 0;
        bottomNavigationView = findViewById(R.id.home_bottomview);

    }

    @Override
    public void initListener() {
        bottomNavigationView.setOnNavigationItemSelectedListener(changeFragment);
    }

    @Override
    public int getContextView() {
        return R.layout.activity_home;
    }

    @Override
    public void initData() {
        //StatusBarUtils.with(this).setStatuImmersive();
        //StatusBarUtils.setStyleBlack(this);
        StatusBarUtils.MIUISetStatusBarLightMode(getWindow(),true);
        getContract().switchFragment(fragments,lastfragment,0);
        getSupportFragmentManager().beginTransaction().replace(R.id.home_layout,mainFragment).show(mainFragment).commit();
    }

    @Override
    public HomePresenter getPresenterInstance() {
        return new HomePresenter();
    }

    @Override
    public <ERROR> void responrse(ERROR error, Throwable throwable) {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void onClick(View v) {

    }
    private final BottomNavigationView.OnNavigationItemSelectedListener changeFragment= new BottomNavigationView.OnNavigationItemSelectedListener() {
        @SuppressLint("NonConstantResourceId")
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    if(lastfragment != 0) {
                        getContract().switchFragment(fragments,lastfragment,0);
                        lastfragment = 0;
                    }
                    return true;
                case R.id.navigation_statistical:
                    if(lastfragment != 1) {
                        getContract().switchFragment(fragments,lastfragment,1);
                        lastfragment = 1;
                    }
                    return true;
                case R.id.navigation_my:
                    if(lastfragment != 2) {
                        getContract().switchFragment(fragments,lastfragment,2);
                        lastfragment = 2;
                    }
                    return true;
            }

            return false;
        }
    };
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (ToastUtils.onKeyDown(this,keyCode,event)){
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
