package com.android.tallybook.mvp.presenter;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.viewpager.widget.ViewPager;

import com.android.tallybook.R;
import com.android.tallybook.base.BasePresenter;
import com.android.tallybook.mvp.IGuide;
import com.android.tallybook.mvp.model.GuideModel;
import com.android.tallybook.mvp.view.GudieActivity;
import com.android.tallybook.mvp.view.HomeActivity;
import com.android.tallybook.utils.ActivityUtils;
import com.android.tallybook.utils.WeakHandler;

import java.util.ArrayList;

public class GuidePresenter extends BasePresenter<GudieActivity, GuideModel, IGuide.P> {
    @Override
    public GuideModel getModelInstence() {
        return new GuideModel(this);
    }

    @Override
    public IGuide.P getContract() {
        return new IGuide.P() {
            @Override
            public void initViewPager(int[] images, ArrayList<ImageView> imageViews, Button gudie_btn_begin) {
                ViewPager.LayoutParams mParams = new ViewPager.LayoutParams();
                for (int image : images) {
                    ImageView iv = new ImageView(mView);
                    iv.setLayoutParams(mParams);//设置布局
                    iv.setImageResource(image);//为ImageView添加图片资源
                    iv.setScaleType(ImageView.ScaleType.FIT_XY);//这里也是一个图片的适配
                    imageViews.add(iv);

                }
            }

            @Override
            public void initDot(ImageView[] dotView, int[] images, ArrayList<ImageView> imageViews) {
                LinearLayout layout = mView.findViewById(R.id.guide_layout_dot);
                LinearLayout.LayoutParams mParams = new LinearLayout.LayoutParams(70, 70);
                mParams.setMargins(1, 0, 1,0);//设置小圆点左右之间的间隔

                //判断小圆点的数量，从0开始，0表示第一个
                for(int i = 0; i < imageViews.size(); i++)
                {
                    ImageView imageView = new ImageView(mView);
                    imageView.setLayoutParams(mParams);
                    imageView.setImageResource(R.drawable.dotselector);
                    imageView.setSelected(i == 0);//默认启动时，选中第一个小圆点
                    dotView[i] = imageView;//得到每个小圆点的引用，用于滑动页面时，（onPageSelected方法中）更改它们的状态。
                    layout.addView(imageView);//添加到布局里面显示
                }
            }

            @Override
            public void noFristLogin() {
                mModel.getContract().noFristLogin();
            }

            @Override
            public void tohome(String msg) {
                //mView.dialog = mView.showloading(mView,msg);
               new WeakHandler().postDelayed(new Runnable() {
                   @Override
                   public void run() {
                       mView.dialog = mView.showloading(mView,msg);
                       ActivityUtils.go(mView, HomeActivity.class);
                       mView.finish();
                   }
               },1000);
               mView.closeDialog(mView.dialog);
            }
        };
    }
}
