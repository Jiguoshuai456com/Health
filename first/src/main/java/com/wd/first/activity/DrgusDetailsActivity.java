package com.wd.first.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.wd.common.Base.BaseActivity;
import com.wd.common.Base.BasePresenter;
import com.wd.first.R;
import com.wd.first.R2;
import com.wd.first.bean.DrgusDetailsBean;

import java.io.Serializable;

import butterknife.BindView;

public class DrgusDetailsActivity extends BaseActivity {
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
    @BindView(R2.id.t6)
    TextView t6;
    @BindView(R2.id.t7)
    TextView t7;
    @BindView(R2.id.t8)
    TextView t8;
    @BindView(R2.id.t9)
    TextView t9;
    @BindView(R2.id.t10)
    TextView t10;
    @BindView(R2.id.t11)
    TextView t11;
    @Override
    protected int getLayout() {
        return R.layout.activity_drgus_details;
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
        DrgusDetailsBean drgusDetailsBean = (DrgusDetailsBean) intent.getSerializableExtra("drgusDetailsBean");
        String name = intent.getStringExtra("name");
        t1.setText(name);
        DrgusDetailsBean.ResultBean result = drgusDetailsBean.getResult();
        t2.setText(result.getComponent());
        t4.setText(result.getEffect());
        t5.setText(result.getUsage());
        t6.setText(result.getShape());
        t7.setText(result.getPacking());
        t8.setText(result.getSideEffects());
        t9.setText(result.getStorage());
        t10.setText(result.getMindMatter());
        t11.setText(result.getApprovalNumber());
    }
}
