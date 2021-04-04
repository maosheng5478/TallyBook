package com.android.tallybook.mvp.view;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.tallybook.R;
import com.android.tallybook.adapter.BillsListViewAdapter;
import com.android.tallybook.base.BaseActivity;
import com.android.tallybook.bean.BillBean;
import com.android.tallybook.customView.ListViewForScrollView;
import com.android.tallybook.mvp.ISearch;
import com.android.tallybook.mvp.presenter.SearchPresenter;
import com.android.tallybook.utils.ActivityUtils;
import com.android.tallybook.utils.StatusBarUtils;

import java.util.ArrayList;
import java.util.List;

public class SearchAcivity extends BaseActivity<SearchPresenter, ISearch.V> {

    private EditText search_et_key;
    private TextView search_tv_cancel;
    private TextView search_tv_datacount;
    private ListViewForScrollView search_lvfsv_searchdata;
    private LinearLayout search_ll_nodata;

    private List<BillBean> billBeanList = new ArrayList<>();
    private BillsListViewAdapter adapter;
    private Drawable ic_cancel;
    private Drawable ic_search ;

    public SearchAcivity() {
    }

    @Override
    public ISearch.V getContract() {
        return new ISearch.V() {
            @Override
            public void searchBills(String key) {
                mPresenter.getContract().searchBills(key);
            }

            @SuppressLint("SetTextI18n")
            @Override
            public void respondSearch(List<BillBean> list) {
                billBeanList = list;
                search_tv_datacount.setText("共找到"+billBeanList.size()+"笔账单");
                if (billBeanList.size() == 0){
                    search_ll_nodata.setVisibility(View.VISIBLE);

                }else {
                    search_ll_nodata.setVisibility(View.GONE);
                }
                adapter = new BillsListViewAdapter(SearchAcivity.this,billBeanList);
                search_lvfsv_searchdata.setAdapter(adapter);
                getContract().listviewItemClick(search_lvfsv_searchdata,billBeanList );
                adapter.notifyDataSetChanged();
            }

            @Override
            public void listviewItemClick(ListViewForScrollView listViewForScrollView, List<BillBean> billBeans) {
                mPresenter.getContract().listviewItemClick(listViewForScrollView,billBeans);
            }
        };
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    public void initView() {
        search_et_key = findViewById(R.id.search_et_key);
        search_tv_cancel = findViewById(R.id.search_tv_cancel);
        search_tv_datacount = findViewById(R.id.search_tv_datacount);
        search_lvfsv_searchdata = findViewById(R.id.search_lvfsv_searchdata);
        search_ll_nodata = findViewById(R.id.search_ll_nodata);
        ic_cancel = getResources().getDrawable(R.drawable.ic_cancel);
        ic_search = getResources().getDrawable(R.drawable.ic_search);
    }


    @Override
    public int getContextView() {
        return R.layout.activity_search;
    }

    @Override
    public void initData() {
        StatusBarUtils.with(this).setStatuImmersive();
        StatusBarUtils.setStyleBlack(this);
        search_tv_datacount.setText("共找到0笔账单");
        search_et_key.setFocusable(true);
        search_et_key.setFocusableInTouchMode(true);
        search_et_key.requestFocus();
        search_et_key.setSelection(search_et_key.getText().length());
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public SearchPresenter getPresenterInstance() {
        return new SearchPresenter();
    }

    @Override
    public <ERROR> void responrse(ERROR error, Throwable throwable) {

    }

    @Override
    public void destroy() {

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.search_tv_cancel:
                ActivityUtils.go(SearchAcivity.this,HomeActivity.class);
                finish();
                overridePendingTransition(R.anim.lr_in_exit, R.anim.lr_out_exit);
        }
    }
    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void initListener() {
        search_tv_cancel.setOnClickListener(this);
        search_et_key.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                search_et_key.setCompoundDrawablesWithIntrinsicBounds(ic_search,null,
                        (s.length() > 0 && search_et_key.hasFocus()) ? ic_cancel : null,null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        search_et_key.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_UP) {
                if (search_et_key.hasFocus() && event.getX() <= (search_et_key.getWidth() - search_et_key.getPaddingRight())
                        && event.getX() >= (search_et_key.getWidth() - search_et_key.getPaddingRight() - ic_cancel.getBounds().width())) {
                    search_et_key.setText("");
                }
            }
            return false;
        });
        search_et_key.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                search_et_key.setCompoundDrawablesWithIntrinsicBounds(ic_search,null,
                        (search_et_key.length() > 0 && hasFocus) ? ic_cancel : null,null);
            }
        });
        search_et_key.setOnKeyListener((v, keyCode, event) -> {
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {
                getContract().searchBills(search_et_key.getText().toString());
            }
            return false;
        });
    }

    @Override
    public void onBackPressed() {
        ActivityUtils.go(SearchAcivity.this,HomeActivity.class);
        finish();
        overridePendingTransition(R.anim.lr_in_exit, R.anim.lr_out_exit);
    }
}
