package com.wd.first.moudle;


import com.wd.common.utiuls.NetUtils;
import com.wd.first.bean.ShiPinBean;
import com.wd.first.bean.ShiPinLeiMu;
import com.wd.first.bean.ShiPinPingLieBiao;
import com.wd.first.contract.FirstApis;
import com.wd.first.contract.HomePageContral;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HomePageModel implements HomePageContral.getModel {
    @Override
    public void getLeiMu(CallBackLeiMu callBackLeiMu) {
        createrRetrofit().getLeiMu()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe(new Observer<ShiPinLeiMu>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ShiPinLeiMu shiPinLeiMu) {
                        if(callBackLeiMu!=null){
                            callBackLeiMu.getLeiMuSucc(shiPinLeiMu);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if(callBackLeiMu!=null){
                            callBackLeiMu.getLeiMuFiuld(e.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getShiPin(int categoryId, int page, int count, CallBackShiPin callBackShiPin) {
        createrRetrofit().getShiPin(categoryId,page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ShiPinBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ShiPinBean shiPinBean) {
                        if(callBackShiPin!=null){
                            callBackShiPin.getShiPinSucc(shiPinBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if(callBackShiPin!=null){
                            callBackShiPin.getShiPinFiuld(e.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getShiPinPingLieBiao(int videoId, CallBackShiPinPingLieBiao callBackShiPinPingLieBiao) {
        createrRetrofit().getShiPinPingLieBiao(videoId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ShiPinPingLieBiao>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ShiPinPingLieBiao shiPinPingLieBiao) {
                        if(callBackShiPinPingLieBiao!=null){
                            callBackShiPinPingLieBiao.getShiPinPingLieBiaoSucc(shiPinPingLieBiao);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if(callBackShiPinPingLieBiao!=null){
                            callBackShiPinPingLieBiao.getShiPinPingLieBiaoFiuld(e.getMessage());
                        }
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
