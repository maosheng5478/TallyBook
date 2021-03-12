package com.android.tallybook.mvp.view;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.viewpager.widget.ViewPager;

import com.android.tallybook.R;
import com.android.tallybook.adapter.GudieViewPagerAdapter;
import com.android.tallybook.baseMVP.BaseMVPActivity;
import com.android.tallybook.mvp.IGuide;
import com.android.tallybook.mvp.presenter.GuidePresenter;
import com.android.tallybook.utils.StatusBarUtils;

import java.util.ArrayList;

public class GudieActivity extends BaseMVPActivity<GuidePresenter, IGuide.V> {

    private ViewPager gudie_vp;
    private Button gudie_btn_begin;
    private GudieViewPagerAdapter viewPagerAdapter;
    //图片资源
    private static int[] images = {};
    private ArrayList<ImageView> imageViews;
    //底部切换圆点
    private ImageView[] dotView;

    @Override
    public IGuide.V getContract() {
        return null;
    }

    @Override
    public void initView() {
        imageViews = new ArrayList<ImageView>();
        gudie_vp = findViewById(R.id.guide_vp);
        gudie_btn_begin = findViewById(R.id.guide_btn_begin);

        mPresenter.getContract().initViewPager(images,imageViews,gudie_btn_begin);
        mPresenter.getContract().initDot(dotView,images,imageViews);
    }

    @Override
    public void initListener() {
        gudie_btn_begin.setOnClickListener(this);
    }

    @Override
    public int getContextView() {
        return R.layout.activity_guide;
    }

    @Override
    public void initData() {
        StatusBarUtils.with(this).setStatuImmersive();


    }

    @Override
    public GuidePresenter getPresenterInstance() {
        return new GuidePresenter();
    }

    @Override
    public <ERROR> void responrse(ERROR error, Throwable throwable) {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.guide_btn_begin:
                //jump to new page
        }
    }
}
