package com.wd.first.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wd.first.R;
import com.wd.first.bean.BIngBean;
import com.wd.first.bean.DepartmenBean;

import java.util.List;

public class BingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<BIngBean.ResultBean> list;
    public BingAdapter(Context context, List<BIngBean.ResultBean> list) {
        this.context=context;
        this.list=list;
    }
    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv;
        LinearLayout l;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
            l = itemView.findViewById(R.id.l2);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.bing_item, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder view= (ViewHolder) viewHolder;
        view.tv.setText(list.get(i).getName());
        view.l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onclickLinstener!=null)
                onclickLinstener.OnClick(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public OnclickLinstener onclickLinstener;
    public void setOnclickLinstener(OnclickLinstener monclickLinstener){
        onclickLinstener=monclickLinstener;
    }
    public interface OnclickLinstener{
        void OnClick(int postion);
    }
}
