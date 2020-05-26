package com.wd.login.activity;


import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
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
import com.wd.login.utile.NetUtils;
import com.wd.login.utile.RsaCoder;
import com.wd.login.utile.SPUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 设置新密码页
 */
public class SetPasswordActivity extends BaseActivity implements login_LoginContract.LoginIView {
    @BindView(R2.id.setpassword_pwd1)
    EditText pwd1;
    @BindView(R2.id.setpassword_pwd2)
    EditText pwd2;
    @BindView(R2.id.setpassword_bt)
    Button bt;
    @BindView(R2.id.setpassword_back_zuo)
    ImageView zuo;
    private String mpwd1;
    private String mpwd2;
    @Override
    protected int getLayout() {
        return R.layout.activity_set_password;
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

    @Override
    public void onCheckSuccess(login_CheckCodeBean checkCodeBean) {

    }

    @Override
    public void onCheckError(String str) {

    }

    @Override
    public void onSetPassSuccess(login_ResetUserPwdBean resetUserPwdBean) {

        Toast.makeText(this, ""+resetUserPwdBean.getMessage(), Toast.LENGTH_SHORT).show();
        if (resetUserPwdBean.getMessage()!=null){
            Intent intent = new Intent(SetPasswordActivity.this, HealthPageActivity.class);
            startActivity(intent);
            finish();
        }

    }

    @Override
    public void onSetPassError(String str) {
        Log.i("xxx",str+"");
    }
    @OnClick(R2.id.setpassword_bt)
    public void setpasswordClick(){
        Log.i("pass","password");
        boolean netWork = NetUtils.getInstance().isNetWork(SetPasswordActivity.this);
        if (netWork){
            String  email = SPUtils.getString(SetPasswordActivity.this, SPUtils.NAME, "email");
            String pwd = pwd1.getText().toString();
            try {
                mpwd1 = RsaCoder.encryptByPublicKey(pwd);
            } catch (Exception e) {
                e.printStackTrace();
            }
            String mpwd = pwd2.getText().toString();
            try {
                mpwd2 = RsaCoder.encryptByPublicKey(mpwd);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (!TextUtils.isEmpty(pwd)&&!TextUtils.isEmpty(mpwd)&&mpwd1.equals(mpwd2)){
                BasePresenter presenter = getPresenter();
                if (presenter!=null&&presenter instanceof login_LoginPresenter){
                    ((login_LoginPresenter) presenter).putSetPass(email,mpwd1,mpwd1);
                }

            }else{
                Toast.makeText(SetPasswordActivity.this, "请输入一致的密码", Toast.LENGTH_SHORT).show();

            }
        }else{
            Toast.makeText(SetPasswordActivity.this, "请检查网络", Toast.LENGTH_SHORT).show();
        }
    }
    //返回上一页
    @OnClick(R2.id.setpassword_back_zuo)
    public void onClickzuo(){
        Intent intent = new Intent(SetPasswordActivity.this, login_CopyActivity.class);
        startActivity(intent);
    }

}
