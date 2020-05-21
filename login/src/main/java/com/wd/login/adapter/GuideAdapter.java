package com.wd.login.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/*
 *@Auther:cln
 *@Date: 2020/5/21
 *@Time:10:12
 *@Description:
 * */public class GuideAdapter extends PagerAdapter {

    Context context;
    ArrayList<ImageView> guids;

    public GuideAdapter(Context context, ArrayList<ImageView> guids) {
        this.context = context;
        this.guids = guids;
    }

    @Override
    public int getCount() {
        return guids.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //从viewpager中移除掉
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        // container viewpaper
        //获取View
        View child = guids.get(position);
        // 添加View
        container.addView(child);
        return child;
    }

}
