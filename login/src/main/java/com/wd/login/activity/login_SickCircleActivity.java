package com.wd.login.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wd.common.Base.BaseActivity;
import com.wd.common.Base.BasePresenter;
import com.wd.login.R;

import butterknife.BindView;

/**
 * 病友圈列表展示  病友圈首页
 */

public class login_SickCircleActivity extends BaseActivity  {



    @Override
    protected int getLayout() {
        return R.layout.activity_login__sick_circle;
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

    }
}
