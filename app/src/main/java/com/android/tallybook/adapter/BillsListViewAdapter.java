package com.android.tallybook.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.tallybook.R;
import com.android.tallybook.bean.BillBean;
import com.android.tallybook.customView.RoundView;
import com.android.tallybook.utils.LogUtils;

import java.util.List;

public class BillsListViewAdapter extends BaseAdapter {

    private Context context;
    private List<BillBean> billBeanList;
    public BillsListViewAdapter(Context context,List<BillBean> billBeanList){
        this.context = context;
        this.billBeanList = billBeanList;
    }
    @Override
    public int getCount() {
        return billBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return billBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint({"ViewHolder", "InflateParams", "UseCompatLoadingForDrawables", "SetTextI18n"})
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        //convertView = LayoutInflater.from(context).inflate( R.layout.list_view_bills, null);
        BillBean bean = new BillBean();
        bean = billBeanList.get(position);
        View view;
        if (convertView == null) {
            view = View.inflate(context,R.layout.list_view_bills,null);
            //view = LayoutInflater.from(context).inflate(R.layout.list_view_bills,null);
            viewHolder = new ViewHolder();
            viewHolder.list_bills_iv_infor = view.findViewById(R.id.list_bills_iv_infor);
            viewHolder.list_bills_layout_img = view.findViewById(R.id.list_bills_layout_img);
            viewHolder.list_bills_tv_class = view.findViewById(R.id.list_bills_tv_class);
            viewHolder.list_bills_tv_explantion = view.findViewById(R.id.list_bills_tv_explantion);
            viewHolder.list_bills_tv_money = view.findViewById(R.id.list_bills_tv_money);
            view.setTag(viewHolder);
        }else {
            view = convertView;
            viewHolder =(ViewHolder) view.getTag();
        }
        viewHolder.list_bills_layout_img.setFillColor(context.getResources().getColor(R.color.green));
        viewHolder.list_bills_iv_infor.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_fork));
        viewHolder.list_bills_tv_class.setText(bean.getBillname());
        LogUtils.d("logg__________",bean.getCost());
        viewHolder.list_bills_tv_explantion.setText(bean.getRemarks());
        viewHolder.list_bills_tv_money.setText(bean.getCost());
        return view;
    }
}
class ViewHolder{

    RoundView list_bills_layout_img;
    ImageView list_bills_iv_infor;
    TextView list_bills_tv_explantion;
    TextView list_bills_tv_class;
    TextView list_bills_tv_money;

}
