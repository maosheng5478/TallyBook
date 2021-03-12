package com.android.tallybook.mvp;

import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public interface IGuide {

    interface V{

    }

    interface P{
        void initViewPager(int[] images, ArrayList<ImageView> imageViews, Button button);

        void initDot(ImageView[] dotView,int[] images,ArrayList<ImageView> imageViews);
    }

    interface M{

    }
}
