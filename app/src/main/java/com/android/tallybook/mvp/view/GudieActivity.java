package com.android.tallybook.mvp.view;

import android.annotation.SuppressLint;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.viewpager.widget.ViewPager;

import com.android.tallybook.R;
import com.android.tallybook.adapter.GudieViewPagerAdapter;
import com.android.tallybook.base.BaseActivity;
import com.android.tallybook.mvp.IGuide;
import com.android.tallybook.mvp.presenter.GuidePresenter;
import com.android.tallybook.utils.StatusBarUtils;
import com.android.tallybook.utils.ToastUtils;

import java.util.ArrayList;

public class GudieActivity extends BaseActivity<GuidePresenter, IGuide.V> implements ViewPager.OnPageChangeListener{

    private ViewPager gudie_vp;
    private Button gudie_btn_begin;
    private GudieViewPagerAdapter viewPagerAdapter;
    //图片资源
    private static int[] images = {R.color.blue,R.color.green,R.color.red,R.color.orange};
    private ArrayList<ImageView> imageViews;
    //底部切换圆点
    private ImageView[] dotView;

    @Override
    public IGuide.V getContract() {
        return new IGuide.V() {
            @Override
            public void noFristLogin() {
                mPresenter.getContract().noFristLogin();
            }

            @Override
            public void tohome(String msg) {
                mPresenter.getContract().tohome(msg);
            }
        };
    }

    @Override
    public void initView() {
        imageViews = new ArrayList<ImageView>();
        dotView = new ImageView[images.length];
        gudie_vp = findViewById(R.id.guide_vp);
        gudie_btn_begin = findViewById(R.id.guide_btn_begin);

        mPresenter.getContract().initViewPager(images,imageViews,gudie_btn_begin);
        mPresenter.getContract().initDot(dotView,images,imageViews);
    }

    @Override
    public void initListener() {
        gudie_btn_begin.setOnClickListener(this);

        viewPagerAdapter = new GudieViewPagerAdapter(imageViews);
        gudie_vp.setAdapter(viewPagerAdapter);
        gudie_vp.addOnPageChangeListener(this);
    }

    @Override
    public int getContextView() {
        return R.layout.activity_guide;
    }

    @Override
    public void initData() {
        StatusBarUtils.with(this).setStatuImmersive();
        getContract().noFristLogin();


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
        if (dialog!=null){
            closeDialog(dialog);
        }
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.guide_btn_begin:
                //jump to new page
                getContract().tohome(getResources().getString(R.string.loading));
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (position == imageViews.size() - 1) {
            gudie_btn_begin.setVisibility(View.VISIBLE);
            gudie_btn_begin.setEnabled(true);
        }else {
            gudie_btn_begin.setVisibility(View.INVISIBLE);
            gudie_btn_begin.setEnabled(false);
        }
    }

    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i < dotView.length; i++) {
            if (position == i) {
                dotView[i].setSelected(true);
            } else {
                dotView[i].setSelected(false);
            }

        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (ToastUtils.onKeyDown(this,keyCode,event)){
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
