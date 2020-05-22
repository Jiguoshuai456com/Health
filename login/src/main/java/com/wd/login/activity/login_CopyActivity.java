package com.wd.login.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.wd.common.Base.BaseActivity;
import com.wd.common.Base.BasePresenter;
import com.wd.login.R;
import com.wd.login.R2;
import com.wd.login.bean.login_CheckCodeBean;
import com.wd.login.bean.login_EmailBean;
import com.wd.login.bean.login_LoginBean;
import com.wd.login.bean.login_RegisterBean;
import com.wd.login.contarct.login_CheckContarct;
import com.wd.login.contarct.login_LoginContract;
import com.wd.login.login_LoginActivity;
import com.wd.login.presenter.login_CheckIPresenter;
import com.wd.login.presenter.login_LoginPresenter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 忘记密码页
 */
public class login_CopyActivity extends BaseActivity implements login_CheckContarct.onCheckView{
    @BindView(R2.id.copy_back_zuo)
    ImageView zuo;
    @BindView(R2.id.copy_email)
    EditText email;
    @BindView(R2.id.copy_code)
    EditText code;
    @BindView(R2.id.copy_bt_hqyz)
    Button hqyz;
    @BindView(R2.id.copy_btxia)
    Button btxia;


    @Override
    protected int getLayout() {
        return R.layout.activity_login__copy;
    }

    @Override
    protected BasePresenter initPresenter() {
        return new login_CheckIPresenter(this);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }
    //获取验证码
    @OnClick(R2.id.copy_bt_hqyz)
    public void setonClickhq() {
        if (!TextUtils.isEmpty(email.getText().toString())){
            BasePresenter presenter = getPresenter();
            if (presenter!=null&&presenter instanceof login_LoginPresenter){
                ((login_LoginPresenter) presenter).postEmail(email.getText().toString());
            }
        }else{
            Toast.makeText(this, "请输入正确的邮箱", Toast.LENGTH_SHORT).show();
        }
    }
    @OnClick(R2.id.copy_btxia)
    public void setbtxia(){

        if (TextUtils.isEmpty(email.getText())) {
            Toast.makeText(this, "邮箱不能为空", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(code.getText())) {
            Toast.makeText(this, "验证码不能为空", Toast.LENGTH_SHORT).show();
        } else {
            //邮箱
            String emails = email.getText().toString();

            //验证码
            String codes = code.getText().toString();
            BasePresenter presenter = getPresenter();

            if (presenter != null && presenter instanceof login_CheckIPresenter) {
                ((login_CheckIPresenter) presenter).postCheck(emails,codes);

            }
        }
    }
    @OnClick(R2.id.copy_back_zuo)
    public void setzuo(){
        Intent intent = new Intent(login_CopyActivity.this, login_LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void onCheckSuccess(login_CheckCodeBean checkCodeBean) {
        Toast.makeText(this, ""+checkCodeBean.getMessage(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(login_CopyActivity.this, SetPasswordActivity.class);
        startActivity(intent);

    }

    @Override
    public void onCheckError(String str) {

    }

}