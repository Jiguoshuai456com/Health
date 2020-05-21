package com.wd.login.activity;


import android.widget.Button;
import android.widget.EditText;

import com.wd.common.Base.BaseActivity;
import com.wd.common.Base.BasePresenter;
import com.wd.login.R;
import com.wd.login.R2;

import butterknife.BindView;

/**
 * 设置新密码页
 */
public class SetPasswordActivity extends BaseActivity {
    @BindView(R2.id.setpassword_pwd1)
    EditText pwd1;
    @BindView(R2.id.setpassword_pwd2)
    EditText pwd2;
    @BindView(R2.id.setpassword_bt)
    Button bt;


    @Override
    protected int getLayout() {
        return R.layout.activity_set_password;
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
