package com.wd.first.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.wd.common.Base.BaseActivity;
import com.wd.common.Base.BasePresenter;
import com.wd.first.R;
import com.wd.first.R2;
import com.wd.first.adapter.DiseaseAdapter;
import com.wd.first.adapter.NewsAdapter;
import com.wd.first.bean.BannerBean;
import com.wd.first.bean.NewsBean;
import com.wd.first.contract.IHomeContract;
import com.wd.first.prenster.IHomePrenster;

import java.util.List;

import butterknife.BindView;

public class NewsMoreActivity extends BaseActivity implements IHomeContract.IView {


    @BindView(R2.id.rv)
    RecyclerView rv;
    @BindView(R2.id.t1)
    TextView t1;
    private String name;

    @Override
    protected int getLayout() {
        return R.layout.activity_news_more;
    }

    @Override
    protected BasePresenter initPresenter() {
        return new IHomePrenster(this);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);
        name = intent.getStringExtra("name");
        BasePresenter presenter = getPresenter();
        t1.setText(name);
        if (presenter instanceof IHomePrenster){
            IHomePrenster p= (IHomePrenster) presenter;
            p.onNews(id,1,10);
        }

    }

    @Override
    public void getBanner(BannerBean bannerBean) {

    }

    @Override
    public void getNews(NewsBean newsBean) {
        List<NewsBean.ResultBean> result = newsBean.getResult();
        RecyclerView.LayoutManager layoutManager2= new LinearLayoutManager(NewsMoreActivity.this,RecyclerView.VERTICAL,false);
        NewsAdapter adapter = new NewsAdapter(NewsMoreActivity.this, result);
        rv.setLayoutManager(layoutManager2);
        rv.setAdapter(adapter);
        adapter.setOnclickLinstener(new DiseaseAdapter.OnclickLinstener() {
            @Override
            public void OnClick(int postion) {

            }
        });
    }
}
