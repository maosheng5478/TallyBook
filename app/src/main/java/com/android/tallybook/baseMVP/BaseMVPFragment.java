package com.android.tallybook.baseMVP;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.tallybook.R;

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
    public void onActivityCreated (@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
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
    @Override
    public Dialog showloading(Context context, String msg) {
        {
            LayoutInflater inflater = LayoutInflater.from(context);
            View v = inflater.inflate(R.layout.layout_dialog_loading, null);// 得到加载view
            LinearLayout layout = (LinearLayout) v
                    .findViewById(R.id.dialog_loading_view);// 加载布局
            TextView tipTextView = (TextView) v.findViewById(R.id.tipTextView);// 提示文字
            tipTextView.setText(msg);// 设置加载信息

            Dialog loadingDialog = new Dialog(context, R.style.MyDialogStyle);// 创建自定义样式dialog
            loadingDialog.setCancelable(true); // 是否可以按“返回键”消失
            loadingDialog.setCanceledOnTouchOutside(false); // 点击加载框以外的区域
            loadingDialog.setContentView(layout, new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT));// 设置布局
            /**
             *将显示Dialog的方法封装在这里面
             */
            Window window = loadingDialog.getWindow();
            WindowManager.LayoutParams lp = window.getAttributes();
            lp.width = WindowManager.LayoutParams.MATCH_PARENT;
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
            window.setGravity(Gravity.CENTER);
            window.setAttributes(lp);
            window.setWindowAnimations(R.style.PopWindowAnimStyle);
            loadingDialog.show();

            return loadingDialog;
        }
    }

    @Override
    public void closeDialog(Dialog mDialogUtils) {
        if (mDialogUtils != null && mDialogUtils.isShowing()) {
            mDialogUtils.dismiss();
        }
    }

}