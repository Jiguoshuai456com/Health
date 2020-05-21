package com.wd.login.activity;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;
import com.wd.common.Base.BaseActivity;
import com.wd.common.Base.BasePresenter;
import com.wd.login.R;
import com.wd.login.R2;

import butterknife.BindView;

public class login_LoginActivity extends BaseActivity {

    @BindView(R2.id.t1)
    TextView t1;
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
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build("/homepage/HomePageActivity")
                        .withString("userName","张三")
                        .withInt("age",123)
                        .navigation();
                Toast.makeText(login_LoginActivity.this, "sdsad ", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void initData() {

    }
}
