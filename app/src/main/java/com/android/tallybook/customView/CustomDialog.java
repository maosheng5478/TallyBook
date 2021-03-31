package com.android.tallybook.customView;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.tallybook.R;

public class CustomDialog extends Dialog {
    private final String title;
    private final String cost;
    private final String date;
    private Context context;
    private callBack callBack;

    public CustomDialog(Context context, String title, String cost,String date) {
        super(context, R.style.Dialog);
        this.title = title;
        this.cost = cost;
        this.date = date;
        this.context = context;

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_custom_dialog);

        Window dialogWindow=this.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.gravity= Gravity.CENTER_VERTICAL;
        DisplayMetrics d =context.getResources().getDisplayMetrics(); // 获取屏幕宽、高用
        lp.width = (int) (d.widthPixels * 0.9); // 宽度设置为屏幕的0.8
        dialogWindow.setAttributes(lp);

        TextView dialog_title = findViewById(R.id.dialog_title);
        TextView dialog_cost = findViewById(R.id.dialog_cost);
        TextView dialog_date = findViewById(R.id.dialog_date);
        ImageView dialog_confirm = findViewById(R.id.dialog_confirm);
        ImageView dialog_cancel = findViewById(R.id.dialog_cancel);
        ImageView dialog_close = findViewById(R.id.dialog_close);

        dialog_title.setText(title);
        dialog_cost.setText(cost);
        dialog_date.setText(date);
        dialog_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack.editListener();
            }
        });
        dialog_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack.deletListener();
            }
        });
        dialog_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancel();
            }
        });

    }

    public void setCanotBackPress() {
        this.setOnKeyListener(new OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
                    return true;
                }
                return false;
            }
        });
    }

    public void setCallBack(CustomDialog.callBack callBack) {
        this.callBack = callBack;
    }

    public interface callBack{
        void editListener();

        void deletListener();
   }
}
