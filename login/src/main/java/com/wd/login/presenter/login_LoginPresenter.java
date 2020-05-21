package com.wd.login.presenter;

import com.wd.common.Base.BasePresenter;
import com.wd.common.Base.IBaseView;
import com.wd.login.bean.login_EmailBean;
import com.wd.login.bean.login_LoginBean;
import com.wd.login.bean.login_RegisterBean;
import com.wd.login.contarct.login_LoginContract;
import com.wd.login.model.login_LoginModel;

/*
 *@Auther:cln
 *@Date: 2020/5/20
 *@Time:21:33
 *@Description:
 * */public class login_LoginPresenter extends BasePresenter implements login_LoginContract.LogPresenter {

    private login_LoginModel mModel;

    public login_LoginPresenter(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void initModel() {
        mModel = new login_LoginModel();
    }

    @Override
    public void postLogin(String email, String pwd) {
        mModel.postLogin(email, pwd, new login_LoginContract.LogModel.LoginICallBack() {
            @Override
            public void onLogSuccess(login_LoginBean loginBean) {
                IBaseView view = getView();
                if (view instanceof login_LoginContract.LoginIView){
                    ((login_LoginContract.LoginIView) view).onLogSuccess(loginBean);
                }
            }

            @Override
            public void onLogError(String str) {
                IBaseView view = getView();
                if (view instanceof login_LoginContract.LoginIView){
                   ((login_LoginContract.LoginIView) view).onLogError(str);
                }
            }
        });
    }

    @Override
    public void postRegister(String email, String code, String pwd1, String pwd2,String invitationCode) {
        mModel.postRegister(email, code, pwd1, pwd2,invitationCode, new login_LoginContract.LogModel.RegisterICallBack() {
            @Override
            public void onRegisterSuccess(login_RegisterBean registerBean) {
                IBaseView view = getView();
                if (view instanceof login_LoginContract.LoginIView){
                    ((login_LoginContract.LoginIView) view).onRegisterSuccess(registerBean);
                }
            }

            @Override
            public void onRegisterError(String str) {
                IBaseView view = getView();
                if (view instanceof login_LoginContract.LoginIView){
                   ((login_LoginContract.LoginIView) view).onRegisterError(str);
                }
            }
        });
    }

    @Override
    public void postEmail(String email) {
        mModel.postEmail(email, new login_LoginContract.LogModel.EmailICallBack() {
            @Override
            public void onEmailSuccess(login_EmailBean emailBean) {
                IBaseView view = getView();
                if (view instanceof login_LoginContract.LoginIView){
                    ((login_LoginContract.LoginIView) view).onEmailSuccess(emailBean);
                }
            }

            @Override
            public void onEmailError(String str) {
                IBaseView view = getView();
                if (view instanceof login_LoginContract.LoginIView){
                    ((login_LoginContract.LoginIView) view).onEmailError(str);
                }
            }
        });
    }
}
