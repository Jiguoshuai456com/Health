package com.wd.first.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.wd.common.Base.BaseActivity;
import com.wd.common.Base.BasePresenter;
import com.wd.first.R;
import com.wd.first.R2;
import com.wd.first.bean.DetailsBean;

import java.io.Serializable;

import butterknife.BindView;

public class DetailsActivity extends BaseActivity {
    @BindView(R2.id.t1)
    TextView t1;
    @BindView(R2.id.t2)
    TextView t2;
    @BindView(R2.id.t3)
    TextView t3;
    @BindView(R2.id.t4)
    TextView t4;
    @BindView(R2.id.t5)
    TextView t5;
    @Override
    protected int getLayout() {
        return R.layout.activity_details;
    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        DetailsBean detailsBean = (DetailsBean) intent.getSerializableExtra("detailsBean");
        DetailsBean.ResultBean result = detailsBean.getResult();
        String name = intent.getStringExtra("name");
        Toast.makeText(this, ""+name, Toast.LENGTH_SHORT).show();
        t1.setText(name);
        t2.setText(result.getPathology());
        t3.setText(result.getSymptom());
        t4.setText(result.getBenefitTaboo());
        t5.setText(result.getWesternMedicineTreatment());
    }
}
