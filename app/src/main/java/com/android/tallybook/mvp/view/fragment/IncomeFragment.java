package com.android.tallybook.mvp.view.fragment;

import android.view.View;

import com.android.tallybook.R;
import com.android.tallybook.baseMVP.BaseMVPActivity;
import com.android.tallybook.baseMVP.BaseMVPFragment;
import com.android.tallybook.customView.ListViewForScrollView;
import com.android.tallybook.mvp.iFragment.IFIncome;
import com.android.tallybook.mvp.presenter.fragmentPresenter.IncomeFragmentPresenter;
import com.android.tallybook.utils.LogUtils;
import com.lihang.chart.ChartCircleItem;
import com.lihang.chart.ChartCircleView;

import java.util.ArrayList;

public class IncomeFragment extends BaseMVPFragment<IncomeFragmentPresenter, IFIncome.V> {

    private ChartCircleView fincome_ccv;
    private ListViewForScrollView fincome_lvfsv;

    private final int[] colors = {R.color.color1,R.color.color2,R.color.color3,R.color.color4,R.color.color5,R.color.color6,
            R.color.color7,R.color.color8,R.color.color9,R.color.color10,R.color.green,R.color.color11,
            R.color.color12, R.color.color13,R.color.color14,R.color.color15};
    @Override
    public IFIncome.V getContract() {
        return null;
    }

    @Override
    public void initView() {
        fincome_ccv = getActivity().findViewById(R.id.fincome_ccv);
        fincome_lvfsv = getActivity().findViewById(R.id.fincome_lfs);
    }

    @Override
    public void initListener() {

    }

    @Override
    public int getContextView() {

        return R.layout.fragment_income;
    }

    @Override
    public void initData() {
        ArrayList<ChartCircleItem> item = new ArrayList<>();
        /*
         * 参数：
         * 1、当前的value的值
         * 2、绘制此部分的颜色值
         * 3、此部分的文字描述
         * */
        item.add(new ChartCircleItem(1, R.color.yellow, "原价"));
        item.add(new ChartCircleItem(3, R.color.blue, "优惠"));
        item.add(new ChartCircleItem(1, R.color.red, "虎牙"));
        item.add(new ChartCircleItem(3, R.color.blue, "Windows"));
        item.add(new ChartCircleItem(1, R.color.yellow, "华为"));
        fincome_ccv.setItems(item);
        LogUtils.d(this.toString(),"init");
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public IncomeFragmentPresenter getPresenterInstance() {
        return new IncomeFragmentPresenter();
    }

    @Override
    public <ERROR> void responrse(ERROR error, Throwable throwable) {

    }

    @Override
    public void destroy() {

    }

}
