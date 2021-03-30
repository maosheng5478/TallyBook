package com.android.tallybook.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class FragmentViewPageAdapter extends FragmentPagerAdapter {

    private List<Fragment> list;
    private String[] titles;

    public FragmentViewPageAdapter(@NonNull FragmentManager fm, List<Fragment> list,String[] titles) {
        super(fm);
        //BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
        this.list = list;
        this.titles = titles;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }



    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

}
