package com.wd.first.activity;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.stx.xhb.xbanner.XBanner;
import com.wd.common.Base.BaseActivity;
import com.wd.common.Base.BasePresenter;
import com.wd.first.R;
import com.wd.first.R2;
import com.wd.first.adapter.BingAdapter;
import com.wd.first.adapter.DiseaseAdapter;
import com.wd.first.adapter.NewsAdapter;
import com.wd.first.bean.BannerBean;
import com.wd.first.bean.NewsBean;
import com.wd.first.bean.NewsDetailsBean;
import com.wd.first.contract.IHomeContract;
import com.wd.first.fragment.DiseaseFragment;
import com.wd.first.fragment.DrugsFragment;
import com.wd.first.fragment.First_Fragment;
import com.wd.first.fragment.Illness_Fragment;
import com.wd.first.fragment.Movie_Fragment;
import com.wd.first.prenster.IHomePrenster;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

@Route(path = "/homepage/HomePageActivity")
public class first_FirstActivity extends BaseActivity implements IHomeContract.IView, View.OnClickListener {
    @BindView(R2.id.vp)
    ViewPager vp;
    @BindView(R2.id.tb)
    TabLayout tb;
    public ArrayList<String> tabs=new ArrayList<>();
    public ArrayList<Fragment> fragments=new ArrayList<>();
    @Override
    protected int getLayout() {
        return R.layout.activity_first__first;
    }

    @Override
    protected BasePresenter initPresenter() {
        return new IHomePrenster(this);
    }

    @Override
    protected void initView() {
        ARouter.getInstance().inject(this);

    }

    @Override
    protected void initData() {
//        rb1.setOnClickListener(this);
//        rb2.setOnClickListener(this);
//        rb3.setOnClickListener(this);
//        rb4.setOnClickListener(this);
//        rb4.setOnClickListener(this);
        First_Fragment first_fragment = new First_Fragment();
        Movie_Fragment movie_fragment = new Movie_Fragment();
        Illness_Fragment illness_fragment = new Illness_Fragment();
        fragments.add(first_fragment);
        fragments.add(movie_fragment);
        fragments.add(illness_fragment);
        tabs.add("首页");
        tabs.add("病友圈");
        tabs.add("视频");
        tb.addTab(tb.newTab().setText(tabs.get(0)));
        tb.addTab(tb.newTab().setText(tabs.get(1)));
        tb.addTab(tb.newTab().setText(tabs.get(2)));
        tb.setupWithViewPager(vp);
        MyAdapter adapter = new MyAdapter(getSupportFragmentManager());
        vp.setAdapter(adapter);
    }

    @Override
    public void getBanner(BannerBean bannerBean) {

    }

    @Override
    public void getNews(NewsBean newsBean) {

    }

    @Override
    public void getNewsDetails(NewsDetailsBean newsDetailsBean) {

    }

    @Override
    public void onClick(View v) {
    }
    class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return fragments.get(i);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return tabs.get(position);
        }
    }
}
