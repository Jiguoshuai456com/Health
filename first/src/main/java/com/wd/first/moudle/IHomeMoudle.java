package com.wd.first.moudle;

import com.wd.common.utiuls.NetUtils;
import com.wd.first.bean.BannerBean;
import com.wd.first.contract.FirstApis;
import com.wd.first.contract.IHomeContract;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class IHomeMoudle implements IHomeContract.IMoudle {
    @Override
    public void onBanner(ICallBck iCallBck) {
        createrRetrofit().getBanner().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BannerBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BannerBean bannerBean) {
                        if (iCallBck!=null)
                            iCallBck.getBanner(bannerBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    public static FirstApis createrRetrofit(){
        return NetUtils.getInstance().getRetrofitServie(FirstApis.class);
    }
}
