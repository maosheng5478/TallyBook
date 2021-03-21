package com.android.tallybook.mvp;

import androidx.fragment.app.Fragment;

public interface IHome {
    interface V{

        void switchFragment(Fragment[] fragments, int lastfragment, int index);

    }
    interface P{
        void switchFragment(Fragment[] fragments,int lastfragment, int index);
    }

    interface M{

    }
}
