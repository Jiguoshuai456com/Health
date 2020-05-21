package com.wd.login;


import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;
import com.wd.common.Base.BaseActivity;
import com.wd.common.Base.BasePresenter;


public class login_LoginActivity extends BaseActivity {


    private TextView t1;

    @Override
    protected int getLayout() {
        return R.layout.activity_login__login;
    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void initView() {
        t1 = (TextView) findViewById(R.id.t1);
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build("/homepage/HomePageActivity")
                        .withString("userName","张三")
                        .withInt("age",123)
                        .navigation();
            }
        });
    }

    @Override
    protected void initData() {

    }
}
