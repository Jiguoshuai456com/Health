package com.wd.login.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;
import com.wd.common.Base.BaseActivity;
import com.wd.common.Base.BasePresenter;
import com.wd.common.utiuls.SPUtils;
import com.wd.login.R;
import com.wd.login.R2;
import com.wd.login.bean.login_EmailBean;
import com.wd.login.bean.login_LoginBean;
import com.wd.login.bean.login_RegisterBean;
import com.wd.login.contarct.login_LoginContract;
import com.wd.login.presenter.login_LoginPresenter;
import com.wd.login.utile.NetUtils;
import com.wd.login.utile.RsaCoder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.OnClick;

public class login_LoginActivity extends BaseActivity implements login_LoginContract.LoginIView{

    @BindView(R2.id.login_email)
    EditText email;
    @BindView(R2.id.login_pwd)
    EditText pwd;
    @BindView(R2.id.login_hide)
    ImageView hide;
    @BindView(R2.id.login_bt_login)
    Button bt;
    @BindView(R2.id.login_ljzc)
    TextView ljzc;
    @BindView(R2.id.login_weixin)
    ImageView weixin;
    @BindView(R2.id.login_forget)
    TextView forget;
    private String emails;
    private String pwds;
    private String pw;
    //邮箱正则表达式
    public static  String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
    @Override
    protected int getLayout() {
        return R.layout.activity_login__login;
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

    @Override
    public void onLogSuccess(login_LoginBean loginBean) {
        Toast.makeText(this, ""+loginBean.getMessage(), Toast.LENGTH_SHORT).show();
        if (loginBean.getStatus().equals("0000")){
            String sessionId = loginBean.getResult().getSessionId();
            int id = loginBean.getResult().getId();
            SPUtils.putString(this,SPUtils.NAME,SPUtils.SESSIONID,sessionId);
            SPUtils.putString(this,SPUtils.NAME,SPUtils.USERID,id+"");
            ARouter.getInstance().build("/homepage/HomePageActivity")
                    .withString("userName","张三")
                    .withInt("age",123)
                    .navigation();
            Toast.makeText(login_LoginActivity.this, "登陆成功 ", Toast.LENGTH_SHORT).show();
        }

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

    }

    @Override
    public void onEmailError(String str) {

    }

    //登录
    @OnClick(R2.id.login_bt_login)
    public void setOnClickbtbt(){
        boolean netWork = NetUtils.getInstance().isNetWork(this);
        if (netWork){
            emails = email.getText().toString();
            pwds = pwd.getText().toString();
            try {
                pw = RsaCoder.encryptByPublicKey(pwds);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (!TextUtils.isEmpty(emails)){
                if (!TextUtils.isEmpty(pw)){
                    BasePresenter presenter = getPresenter();
                    if (presenter!=null&&presenter instanceof  login_LoginPresenter){
                        ((login_LoginPresenter) presenter).postLogin(emails,pw);
                    }
                }else{
                    Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(this, "请输入正确的邮箱", Toast.LENGTH_SHORT).show();
            }

        }else{
            Toast.makeText(this, "请检查网络", Toast.LENGTH_SHORT).show();
        }



    }
    //立即注册
    @OnClick(R2.id.login_ljzc)
    public void setOnClickljzc(){
        Intent intent = new Intent(login_LoginActivity.this, login_RegisterActivity.class);
        startActivity(intent);
//    finish();
    }
    //忘记密码
    @OnClick(R2.id.login_forget)
    public void setOnClickforget(){

        Intent intent = new Intent(login_LoginActivity.this, login_CopyActivity.class);
        startActivity(intent);
    }
    //微信登录
    @OnClick(R2.id.login_weixin)
    public void setweixin(){

    }
    //邮箱正则
    private boolean isEmail(String str){
        if (TextUtils.isEmpty(str)){
            return false;
        }
        Pattern compile = Pattern.compile(REGEX_EMAIL);
        Matcher matcher = compile.matcher(str);
        return matcher.matches();
    }
}
