package com.android.tallybook.mvp.view.fragment;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.tallybook.MyApplication;
import com.android.tallybook.R;
import com.android.tallybook.base.BaseFragment;
import com.android.tallybook.mvp.iFragment.IFMy;
import com.android.tallybook.mvp.presenter.fragmentPresenter.MyFragmentPresenter;
import com.android.tallybook.utils.SharePreferenceUtils;
import com.suke.widget.SwitchButton;

public class MyFragment extends BaseFragment<MyFragmentPresenter, IFMy.V> {

    private ImageView fmy_iv_setting;
    private ImageView fmy_iv_notification;
    private ImageView fmy_iv_headportrait;
    private TextView fmy_tv_name;
    private TextView fmy_tv_record;
    private Button fmy_btn_member;
    private ImageView fmy_iv_photo1;
    private ImageView fmy_iv_photo2;
    private ImageView fmy_iv_photo3;
    private ImageView fmy_iv_photo4;
    private ImageView fmy_iv_photo5;
    private ImageView fmy_iv_photo6;
    private TextView fmy_tv_export;
    private TextView fmy_tv_lead;
    private TextView fmy_tv_password;
    private TextView fmy_tv_help;
    private TextView fmy_tv_parts;
    private TextView fmy_tv_invitation;
    private ImageView fmy_iv_seemoney;
    private TextView fmy_tv_money1;
    private TextView fmy_tv_money2;
    private TextView fmy_tv_money3;
    private SwitchButton fmy_switch_button_1;
    private SwitchButton fmy_switch_button_2;
    private RelativeLayout fmy_rl_preferences;
    private RelativeLayout fmy_rl_jzc;


    @Override
    public IFMy.V getContract() {
        return new IFMy.V() {
            @Override
            public void initSeeView(ImageView imageView, TextView tv1, TextView tv2, TextView tv3) {
                mPresenter.getContract().initSeeView(imageView,tv1,tv2,tv3);
            }
        };
    }

    @Override
    public void initView() {
        fmy_iv_setting = getActivity().findViewById(R.id.fmy_iv_setting);
        fmy_iv_notification = getActivity().findViewById(R.id.fmy_iv_notification);
        fmy_iv_headportrait = getActivity().findViewById(R.id.fmy_iv_headportrait);
        fmy_tv_name = getActivity().findViewById(R.id.fmy_tv_name);
        fmy_tv_record = getActivity().findViewById(R.id.fmy_tv_record);
        fmy_btn_member = getActivity().findViewById(R.id.fmy_btn_member);
        fmy_iv_photo1 = getActivity().findViewById(R.id.fmy_iv_photo1);
        fmy_iv_photo2 = getActivity().findViewById(R.id.fmy_iv_photo2);
        fmy_iv_photo3 = getActivity().findViewById(R.id.fmy_iv_photo3);
        fmy_iv_photo4 = getActivity().findViewById(R.id.fmy_iv_photo4);
        fmy_iv_photo5 = getActivity().findViewById(R.id.fmy_iv_photo5);
        fmy_iv_photo6 = getActivity().findViewById(R.id.fmy_iv_photo6);
        fmy_tv_export = getActivity().findViewById(R.id.fmy_tv_export);
        fmy_tv_lead = getActivity().findViewById(R.id.fmy_tv_lead);
        fmy_tv_password = getActivity().findViewById(R.id.fmy_tv_password);
        fmy_tv_help = getActivity().findViewById(R.id.fmy_tv_help);
        fmy_tv_parts = getActivity().findViewById(R.id.fmy_tv_parts);
        fmy_tv_invitation = getActivity().findViewById(R.id.fmy_tv_invitation);
        fmy_iv_seemoney = getActivity().findViewById(R.id.fmy_iv_seemoney);
        fmy_tv_money1 = getActivity().findViewById(R.id.fmy_tv_money1);
        fmy_tv_money2 = getActivity().findViewById(R.id.fmy_tv_money2);
        fmy_tv_money3 = getActivity().findViewById(R.id.fmy_tv_money3);
        fmy_switch_button_1 = getActivity().findViewById(R.id.fmy_switch_button_1);
        fmy_switch_button_2 = getActivity().findViewById(R.id.fmy_switch_button_2);
        fmy_rl_preferences = getActivity().findViewById(R.id.fmy_rl_preferences);
        fmy_rl_jzc = getActivity().findViewById(R.id.fmy_rl_jzc);
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    public void initListener() {
        fmy_rl_preferences.setOnClickListener(v -> {
            // jump to preferences setting
        });
        fmy_iv_setting.setOnClickListener(v -> {
            //jump to setting
        });
        fmy_iv_notification.setOnClickListener(v -> {
            //jump to _notification
        });
        fmy_switch_button_1.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {
                if (isChecked){
                    fmy_rl_jzc.setVisibility(View.VISIBLE);
                }else {
                    fmy_rl_jzc.setVisibility(View.GONE);
                }
            }
        });
        fmy_iv_seemoney.setOnClickListener(v -> {
            getContract().initSeeView(fmy_iv_seemoney,fmy_tv_money1,fmy_tv_money2,fmy_tv_money3);
        });
    }

    @Override
    public int getContextView() {
        return R.layout.fragment_my;
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    public void initData() {
        fmy_iv_headportrait.setImageDrawable(getResources().getDrawable(R.drawable.ic_head));
        getContract().initSeeView(fmy_iv_seemoney,fmy_tv_money1,fmy_tv_money2,fmy_tv_money3);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public MyFragmentPresenter getPresenterInstance() {
        return new MyFragmentPresenter();
    }

    @Override
    public <ERROR> void responrse(ERROR error, Throwable throwable) {
        //send message to app
    }

    @Override
    public void destroy() {

    }

}
