package com.android.tallybook.mvp.presenter.fragmentPresenter;

import android.annotation.SuppressLint;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.tallybook.MyApplication;
import com.android.tallybook.R;
import com.android.tallybook.base.BasePresenter;
import com.android.tallybook.mvp.iFragment.IFMy;
import com.android.tallybook.mvp.model.fragmentModel.MyFragmentModel;
import com.android.tallybook.mvp.view.fragment.MyFragment;
import com.android.tallybook.utils.SharePreferenceUtils;

public class MyFragmentPresenter extends BasePresenter<MyFragment, MyFragmentModel, IFMy.P> {
    @Override
    public MyFragmentModel getModelInstence() {
        return new MyFragmentModel(this);
    }

    @Override
    public IFMy.P getContract() {
        return new IFMy.P() {
            @SuppressLint({"UseCompatLoadingForDrawables", "SetTextI18n", "DefaultLocale"})
            @Override
            public void initSeeView(ImageView imageView, TextView tv1, TextView tv2, TextView tv3) {
                double exp = mModel.getContract().selectExpenses();
                double income = mModel.getContract().selectIncome();
                Boolean seeData = (Boolean) SharePreferenceUtils.get(MyApplication.getContext(),"seeData",false);
                if (seeData){
                    seeData = false;
                    SharePreferenceUtils.put(mView.getContext(),"seeData",seeData);
                    imageView.setImageDrawable(mView.getResources().getDrawable(R.drawable.ic_no_see,null));
                    tv1.setText("****");
                    tv2.setText("****");
                    tv3.setText("****");
                }else {
                    seeData = true;
                    SharePreferenceUtils.put(mView.getContext(),"seeData",seeData);
                    imageView.setImageDrawable(mView.getResources().getDrawable(R.drawable.ic_see,null));
                    tv1.setText(String.format("%.2f",income - exp ));
                    tv2.setText(String.format("%.2f",income));
                    if (exp != 0.0){
                        tv3.setText("-"+ String.format("%.2f",exp));
                    }else {
                        tv3.setText("0.0");
                    }
                }
            }
        };
    }
}
