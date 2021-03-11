package com.android.tallybook.baseMVP;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BaseMVPFragment <P extends BaseMVPPresenter,CONTRACT> extends Fragment implements BaseView<P>{

    public P mPresenter;

    public abstract CONTRACT getContract();
    @Override
    public void setPresenter(P presenter) {
        if (presenter != null)
            mPresenter =  presenter;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getContextView(),container,false);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
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
    public void onDestroy() {
        super.onDestroy();
        destroy();
        mPresenter.unBindView();
    }
    public abstract void destroy();
}