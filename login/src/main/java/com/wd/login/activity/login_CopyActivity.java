package com.wd.login.activity;

import android.content.Intent;
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
import com.wd.login.bean.login_ResetUserPwdBean;
import com.wd.login.contarct.login_LoginContract;
import com.wd.login.presenter.login_LoginPresenter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 忘记密码页
 */
public class login_CopyActivity extends BaseActivity implements login_LoginContract.LoginIView{
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
        return new login_LoginPresenter(this);
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
    //点击下一步
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

            if (presenter != null && presenter instanceof login_LoginPresenter) {

                    ((login_LoginPresenter) presenter).postCheck(emails,codes);
            }
        }
    }
    //右上角返回
    @OnClick(R2.id.copy_back_zuo)
    public void setzuo(){
        Intent intent = new Intent(login_CopyActivity.this, login_LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void onLogSuccess(login_LoginBean loginBean) {

    }

    @Override
    public void onLogError(String str) {

    }

    @Override
    public void onRegisterSuccess(login_RegisterBean registerBean) {

    }

    @Override
    public void onRegisterError(String str) {

    }

    @Override
    public void onEmailSuccess(login_EmailBean emailBean) {
        if (emailBean!=null){
            Toast.makeText(this, ""+emailBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onEmailError(String str) {

    }

    @Override
    public void onCheckSuccess(login_CheckCodeBean checkCodeBean) {
        Toast.makeText(this, ""+checkCodeBean.getMessage(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(login_CopyActivity.this, SetPasswordActivity.class);
        startActivity(intent);
        finish();

    }

    @Override
    public void onCheckError(String str) {

    }

    @Override
    public void onSetPassSuccess(login_ResetUserPwdBean resetUserPwdBean) {

    }

    @Override
    public void onSetPassError(String str) {

    }

}