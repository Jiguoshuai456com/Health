package com.wd.login.model;

import com.wd.login.bean.login_SinckCircleBean;
import com.wd.login.contarct.SickCircleContarct;
import com.wd.login.utile.NetUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/*
 *@Auther:cln
 *@Date: 2020/5/26
 *@Time:22:52
 *@Description:
 * */public class SinckCircleIModel implements SickCircleContarct.SinckCircleModel {

    @Override
    public void getSinckCircle(int departmentId, int page, int count, SinckCircleICallBack iCallBack) {
        NetUtils.getInstance().getApis().doSinckCircle(departmentId,page,count)
                . subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<login_SinckCircleBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(login_SinckCircleBean sinckCircleBean) {
                        if (iCallBack!=null){
                            iCallBack.SinckCircleSuccess(sinckCircleBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (iCallBack!=null){
                            iCallBack.SinckCircleError(e.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
