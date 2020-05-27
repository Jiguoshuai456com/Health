package com.wd.first.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wd.first.R;
import com.wd.first.bean.DrgusBean;
import com.wd.first.bean.LittleBean;

import java.util.List;

public class LittleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<LittleBean.ResultBean> list;
    public LittleAdapter(Context context, List<LittleBean.ResultBean> list) {
        this.context=context;
        this.list=list;
    }
    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv;
        LinearLayout l;
        ImageView iv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
            iv = itemView.findViewById(R.id.iv);
            l = itemView.findViewById(R.id.l);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.little_item, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder view= (ViewHolder) viewHolder;
        String picture = list.get(i).getPicture();
        ImageView iv = view.iv;
        Glide.with(context).load(picture).into(iv);
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
    private OnclickLinstener onclickLinstener;
    public void setOnclickLinstener(OnclickLinstener monclickLinstener){
        onclickLinstener=monclickLinstener;
    }
    public interface OnclickLinstener{
        void OnClick(int postion);
    }
}
