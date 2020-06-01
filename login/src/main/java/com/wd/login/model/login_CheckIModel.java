package com.wd.login.model;

import com.wd.login.bean.login_CheckCodeBean;
import com.wd.login.contarct.login_CheckContarct;
import com.wd.login.utile.NetUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/*
 *@Auther:cln
 *@Date: 2020/5/22
 *@Time:19:45
 *@Description:
 * */public class login_CheckIModel implements login_CheckContarct.onCheckModel {

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
                    public void onNext(login_CheckCodeBean login_checkCodeBean) {
                        if (iCallBack!=null){
                            iCallBack.onCheckSuccess(login_checkCodeBean);
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
}
