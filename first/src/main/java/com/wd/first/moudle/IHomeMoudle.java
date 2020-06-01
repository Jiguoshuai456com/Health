package com.wd.first.moudle;

import com.wd.common.utiuls.NetUtils;
import com.wd.first.bean.BannerBean;
import com.wd.first.bean.NewsBean;
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

    @Override
    public void onNews(int plateId, int page, int count, ICallBack2 iCallBack2) {
        createrRetrofit().getNews(plateId,page,count).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NewsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(NewsBean newsBean) {
                        if (iCallBack2!=null)
                            iCallBack2.getNews(newsBean);
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
