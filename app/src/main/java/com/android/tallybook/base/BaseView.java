package com.android.tallybook.base;

import android.app.Dialog;
import android.content.Context;

public interface BaseView<P>{

    void setPresenter(P presenter);

    Dialog showloading(Context context, String msg) ;

    /**
     * 关闭dialog
     *
     * @param mDialogUtils
     */
    void closeDialog(Dialog mDialogUtils);

}
