package com.wd.first.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.wd.common.Base.BaseActivity;
import com.wd.common.Base.BasePresenter;
import com.wd.first.R;
import com.wd.first.R2;
import com.wd.first.bean.BannerBean;
import com.wd.first.bean.NewsBean;
import com.wd.first.bean.NewsDetailsBean;
import com.wd.first.contract.IHomeContract;
import com.wd.first.prenster.IHomePrenster;

import butterknife.BindView;

public class NewsDetailsActivity extends BaseActivity implements IHomeContract.IView {
    @BindView(R2.id.t1)
    TextView t1;
    @BindView(R2.id.t2)
    TextView t2;
    @BindView(R2.id.t3)
    TextView t3;
    @BindView(R2.id.t4)
    TextView t4;
    @BindView(R2.id.iv)
    ImageView iv;
    @Override
    protected int getLayout() {
        return R.layout.activity_news_details;
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
        String name = intent.getStringExtra("name");
        t1.setText(name);
        BasePresenter presenter = getPresenter();
        if (presenter instanceof IHomePrenster){
            IHomePrenster p= (IHomePrenster) presenter;
            p.onNewsDetails(id);
        }
    }

    @Override
    public void getBanner(BannerBean bannerBean) {

    }

    @Override
    public void getNews(NewsBean newsBean) {

    }

    @Override
    public void getNewsDetails(NewsDetailsBean newsDetailsBean) {
        NewsDetailsBean.ResultBean result = newsDetailsBean.getResult();
        t2.setText(result.getTitle());
        t3.setText(result.getSource()+"  "+result.getReleaseTime());
        t4.setText(result.getContent());
    }
}
