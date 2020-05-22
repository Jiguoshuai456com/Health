package com.wd.login.activity;



import android.content.Intent;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.wd.common.Base.BaseActivity;
import com.wd.common.Base.BasePresenter;

import com.wd.login.R;

import com.wd.login.R2;
import com.wd.login.bean.login_EmailBean;
import com.wd.login.bean.login_LoginBean;
import com.wd.login.bean.login_RegisterBean;
import com.wd.login.contarct.login_LoginContract;
import com.wd.login.login_LoginActivity;
import com.wd.login.presenter.login_LoginPresenter;
import com.wd.login.utile.EncryptUtil;
import com.wd.login.utile.RsaCoder;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 注册页
 */
public class login_RegisterActivity extends BaseActivity implements login_LoginContract.LoginIView {
@BindView(R2.id.register_email)
EditText email;
@BindView(R2.id.register_code)
EditText code;
@BindView(R2.id.register_pwd)
EditText pwd;
@BindView(R2.id.register_hide)
    ImageView hhide;
@BindView(R2.id.register_pwd2)
EditText pwd2;
@BindView(R2.id.register_hide2)
ImageView hhide2;
@BindView(R2.id.register_invite)
EditText invite;
@BindView(R2.id.login_register_xt)
   TextView xt;
@BindView(R2.id.register_bt)
Button bt;
@BindView(R2.id.register_hq)
Button hq;
    private String encrypt;
    private String encrypt2;
    private String pw;


    @Override
    protected int getLayout() {
        return R.layout.activity_login__register;
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
//        hhide.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (hhide.isOpaque()){
//                    pwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
//                }else{
//                    pwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
//                }
//            }
//        });
    }

    @Override
    public void onLogSuccess(login_LoginBean loginBean) {

    }

    @Override
    public void onLogError(String str) {

    }

    @Override
    public void onRegisterSuccess(login_RegisterBean registerBean) {
        if (registerBean!=null){
            Intent intent = new Intent(login_RegisterActivity.this, login_LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void onRegisterError(String str) {
        Log.i("",str+"");
    }

    @Override
    public void onEmailSuccess(login_EmailBean emailBean) {
        if (emailBean!=null){
            Toast.makeText(this, ""+emailBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onEmailError(String str) {
        Log.i("xxx",str);
    }
    //获取验证码
    @OnClick(R2.id.register_hq)
    public void setonClickhq(){
        if (!TextUtils.isEmpty(email.getText().toString())){
            BasePresenter presenter = getPresenter();
            if (presenter!=null&&presenter instanceof login_LoginPresenter){
                ((login_LoginPresenter) presenter).postEmail(email.getText().toString());

            }
        }else{
            Toast.makeText(this, "请输入正确的邮箱", Toast.LENGTH_SHORT).show();
        }
    }
    //点击注册
    @OnClick(R2.id.register_bt)
    public void setOnClickbt() {
        if (TextUtils.isEmpty(email.getText())) {
            Toast.makeText(this, "邮箱不能为空", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(pwd.getText())) {
            Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
        }else if(TextUtils.isEmpty(pwd2.getText())){
            Toast.makeText(this, "请再次输入密码", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(code.getText())) {
            Toast.makeText(this, "验证码不能为空", Toast.LENGTH_SHORT).show();
        } else {
            //邮箱
            String emails = email.getText().toString();
            //邀请码
            String codes = code.getText().toString();
            String pwds = pwd.getText().toString();
            String pwds2 = pwd2.getText().toString();
            try {
                pw = RsaCoder.encryptByPublicKey(pwds);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //验证码
            String invites = invite.getText().toString();
            BasePresenter presenter = getPresenter();
            
            if (presenter != null && presenter instanceof login_LoginPresenter) {
               ((login_LoginPresenter) presenter).postRegister(emails,codes,pw,pw,invites);

            }
        }
    }

}
