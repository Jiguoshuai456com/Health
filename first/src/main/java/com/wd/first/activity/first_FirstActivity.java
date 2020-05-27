package com.wd.first.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.stx.xhb.xbanner.XBanner;
import com.wd.common.Base.BaseActivity;
import com.wd.common.Base.BasePresenter;
import com.wd.first.R;
import com.wd.first.R2;
import com.wd.first.bean.BannerBean;
import com.wd.first.contract.IHomeContract;
import com.wd.first.fragment.DiseaseFragment;
import com.wd.first.fragment.DrugsFragment;
import com.wd.first.prenster.IHomePrenster;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

@Route(path = "/homepage/HomePageActivity")
public class first_FirstActivity extends BaseActivity implements IHomeContract.IView {
    @BindView(R2.id.first_xb)
    XBanner xb;
    @BindView(R2.id.iv_disease)
    ImageView disease;
    @BindView(R2.id.iv_drugs)
    ImageView drugs;
    public ArrayList<String> list=new ArrayList<>();

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
        BasePresenter presenter = getPresenter();
        if (presenter instanceof IHomePrenster){
            IHomePrenster p= (IHomePrenster) presenter;
            p.onBanner();
        }
    }

    @Override
    protected void initData() {

    }

    @Override
    public void getBanner(BannerBean bannerBean) {
        List<BannerBean.ResultBean> result = bannerBean.getResult();
        for (int i=0;i<result.size();i++){
            list.add(result.get(i).getImageUrl());
        }
        xb.setData(list,null);
        xb.setmAdapter(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                ImageView view1= (ImageView) view;
                Glide.with(first_FirstActivity.this).load(list.get(position)).into(view1);
            }
        });
        disease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(first_FirstActivity.this, first_DepartmenActivity.class);
                startActivity(intent);
            }
        });
        drugs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(first_FirstActivity.this, first_DepartmenActivity.class);
                startActivity(intent);
            }
        });

    }
}
