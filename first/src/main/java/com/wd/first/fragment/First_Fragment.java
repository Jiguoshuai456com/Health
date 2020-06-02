package com.wd.first.fragment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.bumptech.glide.Glide;
import com.stx.xhb.xbanner.XBanner;
import com.wd.common.Base.BaseFragment;
import com.wd.common.Base.BasePresenter;
import com.wd.first.R;
import com.wd.first.R2;
import com.wd.first.activity.NewsMoreActivity;
import com.wd.first.activity.first_DepartmenActivity;
import com.wd.first.adapter.DiseaseAdapter;
import com.wd.first.adapter.NewsAdapter;
import com.wd.first.bean.BannerBean;
import com.wd.first.bean.NewsBean;
import com.wd.first.bean.NewsDetailsBean;
import com.wd.first.contract.IHomeContract;
import com.wd.first.prenster.IHomePrenster;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class First_Fragment extends BaseFragment implements IHomeContract.IView, View.OnClickListener {
    @BindView(R2.id.first_xb)
    XBanner xb;
    @BindView(R2.id.iv_disease)
    ImageView disease;
    @BindView(R2.id.iv_drugs)
    ImageView drugs;
    @BindView(R2.id.rb1)
    RadioButton rb1;
    @BindView(R2.id.rb2)
    RadioButton rb2;
    @BindView(R2.id.rb3)
    RadioButton rb3;
    @BindView(R2.id.rb4)
    RadioButton rb4;
    @BindView(R2.id.rb5)
    RadioButton rb5;
    @BindView(R2.id.rv)
    RecyclerView rv;
    public ArrayList<String> list=new ArrayList<>();
    @Override
    protected BasePresenter initPresenter() {
        return new IHomePrenster(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.first_fragment;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initData() {
        rb1.setOnClickListener(this);
        rb2.setOnClickListener(this);
        rb3.setOnClickListener(this);
        rb4.setOnClickListener(this);
        rb4.setOnClickListener(this);
        BasePresenter presenter = getPresenter();
        if (presenter instanceof IHomePrenster){
            IHomePrenster p= (IHomePrenster) presenter;
            p.onBanner();
        }
    }



    @Override
    public void getBanner(BannerBean bannerBean) {
        List<BannerBean.ResultBean> result = bannerBean.getResult();
        list.clear();
        for (int i=0;i<result.size();i++){
            list.add(result.get(i).getImageUrl());
        }
        xb.setData(list,null);
        xb.setmAdapter(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                ImageView view1= (ImageView) view;
                Glide.with(getActivity()).load(list.get(position)).into(view1);
            }
        });
        disease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), first_DepartmenActivity.class);
                startActivity(intent);
            }
        });
        drugs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), first_DepartmenActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void getNews(NewsBean newsBean) {

        List<NewsBean.ResultBean> result = newsBean.getResult();
        RecyclerView.LayoutManager layoutManager2= new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false);
        NewsAdapter adapter = new NewsAdapter(getActivity(), result);
        rv.setLayoutManager(layoutManager2);
        rv.setAdapter(adapter);
        adapter.setOnclickLinstener(new DiseaseAdapter.OnclickLinstener() {
            @Override
            public void OnClick(int postion) {
                int id = result.get(postion).getPlateId();
                Intent intent = new Intent(getActivity(), NewsMoreActivity.class);
                intent.putExtra("id",id);
                if (id==1){
                    intent.putExtra("name","健康养生");
                }else if (id==2){
                    intent.putExtra("name","健康减肥");
                }else if (id==3){
                    intent.putExtra("name","健康美食");
                }else if (id==4){
                    intent.putExtra("name","健康美容");
                }else if (id==5){
                    intent.putExtra("name","慢性疾病");
                }
                startActivity(intent);
            }
        });
    }

    @Override
    public void getNewsDetails(NewsDetailsBean newsDetailsBean) {

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id==R.id.rb1){
            BasePresenter presenter = getPresenter();
            if (presenter instanceof IHomePrenster){
                IHomePrenster p= (IHomePrenster) presenter;
                p.onNews(1,1,5);
            }
        }else  if (id==R.id.rb2){
            BasePresenter presenter = getPresenter();
            if (presenter instanceof IHomePrenster){
                IHomePrenster p= (IHomePrenster) presenter;
                p.onNews(2,1,5);
            }
        }
        else  if (id==R.id.rb3){
            BasePresenter presenter = getPresenter();
            if (presenter instanceof IHomePrenster){
                IHomePrenster p= (IHomePrenster) presenter;
                p.onNews(3,1,5);
            }
        }
        else  if (id==R.id.rb4){
            BasePresenter presenter = getPresenter();
            if (presenter instanceof IHomePrenster){
                IHomePrenster p= (IHomePrenster) presenter;
                p.onNews(4,1,5);
            }
        }
        else  if (id==R.id.rb5){
            BasePresenter presenter = getPresenter();
            if (presenter instanceof IHomePrenster){
                IHomePrenster p= (IHomePrenster) presenter;
                p.onNews(5,1,5);
            }
        }
    }
}
