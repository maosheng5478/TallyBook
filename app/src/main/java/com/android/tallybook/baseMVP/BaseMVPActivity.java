package com.android.tallybook.baseMVP;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseMVPActivity<P extends BaseMVPPresenter,CONTRACT> extends AppCompatActivity implements BaseView<P>, View.OnClickListener{


    public P mPresenter;

    public abstract CONTRACT getContract();

    @Override
    public void setPresenter(P presenter) {
        if (presenter != null)
            mPresenter =  presenter;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContextView());
        mPresenter = getPresenterInstance();
        mPresenter.bindView(this);
        initView();
        initListener();
        initData();

    }

    public abstract void initView();

    public abstract void initListener();

    public abstract int getContextView();

    public abstract void initData();

    public abstract P getPresenterInstance();

    public abstract <ERROR extends Object> void responrse(ERROR error,Throwable throwable);

    @Override
    protected void onDestroy() {
        super.onDestroy();
        destroy();
        mPresenter.unBindView();
    }
    public abstract void destroy();
}
