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
import com.wd.first.bean.BIngBean;
import com.wd.first.bean.NewsBean;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<NewsBean.ResultBean> list;
    public NewsAdapter(Context context, List<NewsBean.ResultBean> list) {
        this.context=context;
        this.list=list;
    }
    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv1;
        TextView tv2;
        TextView tv3;
        LinearLayout l;
        ImageView iv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv1 = itemView.findViewById(R.id.t1);
            tv2 = itemView.findViewById(R.id.t2);
            tv3 = itemView.findViewById(R.id.t3);
            iv = itemView.findViewById(R.id.iv);
            l = itemView.findViewById(R.id.l);
        }
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.news_item, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder view= (ViewHolder) viewHolder;
        NewsBean.ResultBean bean = list.get(i);
        view.tv1.setText(bean.getTitle());
        view.tv2.setText(bean.getSource());
        view.tv3.setText(bean.getReleaseTime()+"");
        Glide.with(context).load(bean.getThumbnail()).into(view.iv);
        view.l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclickLinstener.OnClick(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    private DiseaseAdapter.OnclickLinstener onclickLinstener;
    public void setOnclickLinstener(DiseaseAdapter.OnclickLinstener monclickLinstener){
        onclickLinstener=monclickLinstener;
    }
    public interface OnclickLinstener{
        void OnClick(int postion);
    }
}
