package com.wd.login.model;

import android.util.Log;

import com.wd.login.bean.login_CheckCodeBean;
import com.wd.login.bean.login_EmailBean;
import com.wd.login.bean.login_LoginBean;
import com.wd.login.bean.login_RegisterBean;
import com.wd.login.bean.login_ResetUserPwdBean;
import com.wd.login.contarct.login_LoginContract;
import com.wd.login.utile.NetUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/*
 *@Auther:cln
 *@Date: 2020/5/20
 *@Time:17:49
 *@Description:
 * */public class login_LoginModel implements login_LoginContract.LogModel {
    @Override
    public void postLogin(String email, String pwd, LoginICallBack iCallBack) {
       NetUtils.getInstance().getApis().doLog(email,pwd)
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
               .subscribe(new Observer<login_LoginBean>() {
                   @Override
                   public void onSubscribe(Disposable d) {

                   }

                   @Override
                   public void onNext(login_LoginBean loginBean) {
                    if (iCallBack!=null){
                        iCallBack.onLogSuccess(loginBean);
                    }
                   }

                   @Override
                   public void onError(Throwable e) {
                        if (iCallBack!=null){
                            iCallBack.onLogError(e.getMessage());
                        }
                   }

                   @Override
                   public void onComplete() {

                   }
               });
    }

    @Override
    public void postRegister(String email, String code, String pwd1, String pwd2,String invitationCode, RegisterICallBack iCallBack) {
        NetUtils.getInstance().getApis().doRegister(email,code,pwd1,pwd2,invitationCode)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<login_RegisterBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(login_RegisterBean registerBean) {
                        if (iCallBack!=null){
                            iCallBack.onRegisterSuccess(registerBean);

                        }
                        Log.i("a","abc");
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (iCallBack!=null){
                            iCallBack.onRegisterError(e.getMessage());
                        }
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void postEmail(String email, EmailICallBack iCallBack) {
        NetUtils.getInstance().getApis().doemail(email)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<login_EmailBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(login_EmailBean emailBean) {
                        if (iCallBack!=null){
                            iCallBack.onEmailSuccess(emailBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (iCallBack!=null){
                            iCallBack.onEmailError(e.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void postCheck(String email, String code, CheckICallBack iCallBack) {
        NetUtils.getInstance().getApis().doCheckCode(email,code)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<login_CheckCodeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(login_CheckCodeBean checkCodeBean) {
                        if (iCallBack!=null){
                            iCallBack.onCheckSuccess(checkCodeBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (iCallBack!=null){
                            iCallBack.onCheckError(e.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        }

    @Override
    public void putSetPass(String email, String pwd1, String pwd2, SetPassICallBack iCallBack) {
        NetUtils.getInstance().getApis().doResetUserPwd(email,pwd1,pwd2)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<login_ResetUserPwdBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(login_ResetUserPwdBean resetUserPwdBean) {
                        if (iCallBack!=null){
                            iCallBack.onSetPassSuccess(resetUserPwdBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (iCallBack!=null){
                            iCallBack.onSetPassError(e.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
//    public static Wang createrRetrofit(){
//        return RetrofitUtil.getInstance().getRetrofitServie(Wang.class);
//    }
}
