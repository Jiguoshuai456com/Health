package com.wd.login.contarct;

import com.wd.common.Base.IBaseView;
import com.wd.login.bean.login_EmailBean;
import com.wd.login.bean.login_LoginBean;
import com.wd.login.bean.login_RegisterBean;

/*
 *@Auther:cln
 *@Date: 2020/5/20
 *@Time:16:46
 *@Description:
 * */public interface login_LoginContract {
     interface LoginIView extends IBaseView{
         void onLogSuccess(login_LoginBean loginBean);
         void onLogError(String str);
         void onRegisterSuccess(login_RegisterBean registerBean);
         void onRegisterError(String str);
         void onEmailSuccess(login_EmailBean emailBean);
         void onEmailError(String str);
     }
     interface LogPresenter{
         void postLogin(String email,String pwd);
         void postRegister(String email,String code,String pwd1,String pwd2,String invitationCode);
        void postEmail(String email);
     }
     interface LogModel{
         void postLogin(String email,String pwd,LoginICallBack iCallBack);
         interface LoginICallBack{
             void onLogSuccess(login_LoginBean loginBean);
             void onLogError(String str);
         }
         void postRegister(String email,String code,String pwd1,String pwd2,String invitationCode,RegisterICallBack iCallBack);
         interface RegisterICallBack{
             void onRegisterSuccess(login_RegisterBean registerBean);
             void onRegisterError(String str);
         }
         void postEmail(String email,EmailICallBack iCallBack);
         interface EmailICallBack{
             void onEmailSuccess(login_EmailBean emailBean);
             void onEmailError(String str);
         }
     }
}
