package com.android.tallybook.mvp.view.fragment;

import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.tallybook.R;
import com.android.tallybook.baseMVP.BaseMVPFragment;
import com.android.tallybook.customView.RoundView;
import com.android.tallybook.mvp.iFragment.IFMain;
import com.android.tallybook.mvp.presenter.fragmentPresenter.MainFragmentPresenter;

public class MainFragment extends BaseMVPFragment<MainFragmentPresenter, IFMain.V> {

    private TextView fmain_tv_search;
    private ImageView fmain_iv_nodata;
    private RelativeLayout fmain_layout_r1;
    private RelativeLayout fmain_layout_count;

    @Override
    public IFMain.V getContract() {
        return null;
    }

    @Override
    public void initView() {
       fmain_tv_search = getActivity().findViewById(R.id.fmain_tv_search);
       fmain_iv_nodata = getActivity().findViewById(R.id.fmain_iv_nodata);
       fmain_layout_r1 = getActivity().findViewById(R.id.fmain_layout_r1);
       fmain_layout_count = getActivity().findViewById(R.id.fmain_layout_count);
    }

    @Override
    public void initListener() {

    }

    @Override
    public int getContextView() {
        return R.layout.fragment_main;
    }

    @Override
    public void initData() {
        //StatusBarUtils.with(this.getActivity()).setStatuImmersive();

        ImageSpan imgSpan = new ImageSpan(this.getActivity(), R.drawable.ic_search);
        SpannableString spannableString = new SpannableString(" 搜索账单");
        spannableString.setSpan(imgSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        fmain_tv_search.setText(spannableString);

    }

    @Override
    public MainFragmentPresenter getPresenterInstance() {
        return new MainFragmentPresenter();
    }

    @Override
    public <ERROR> void responrse(ERROR error, Throwable throwable) {

    }

    @Override
    public void destroy() {

    }
}
