package com.android.tallybook.mvp;

import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public interface IGuide {

    interface V{
        void noFristLogin();

        void tohome(String msg);
    }

    interface P{
        void initViewPager(int[] images, ArrayList<ImageView> imageViews, Button button);

        void initDot(ImageView[] dotView,int[] images,ArrayList<ImageView> imageViews);

        void noFristLogin();

        void tohome(String msg);
    }

    interface M{
        void noFristLogin();
    }
}
