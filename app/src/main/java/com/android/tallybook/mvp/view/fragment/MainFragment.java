package com.android.tallybook.mvp.view.fragment;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.android.tallybook.R;
import com.android.tallybook.baseMVP.BaseMVPFragment;
import com.android.tallybook.mvp.iFragment.IFMain;
import com.android.tallybook.mvp.presenter.fragmentPresenter.MainFragmentPresenter;
import com.android.tallybook.utils.StatusBarUtils;

public class MainFragment extends BaseMVPFragment<MainFragmentPresenter, IFMain.V> {

    private TextView fmain_tv_search;

    @Override
    public IFMain.V getContract() {
        return null;
    }

    @Override
    public void initView() {
       fmain_tv_search = getActivity().findViewById(R.id.fmain_tv_search);
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

        String htmlFor02 = "项目图片测试：" + "<img src='" +R.drawable.ic_search + "'>" ;

       /* fmain_tv_search.setText(Html.fromHtml(htmlFor02, new Html.ImageGetter() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public Drawable getDrawable(String source) {
                int id = Integer.parseInt(source);
                @SuppressLint("UseCompatLoadingForDrawables")
                Drawable drawable = getResources().getDrawable(id, null);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth() ,
                        drawable.getIntrinsicHeight());
                return drawable;
            }
        }, null));*/
        //fmain_tv_search.setText("asdasdasd");
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
