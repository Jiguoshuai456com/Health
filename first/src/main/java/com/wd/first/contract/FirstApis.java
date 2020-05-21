package com.wd.first.contract;

import com.wd.first.bean.BannerBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface FirstApis {
    @GET("v1/bannersShow")
    Observable<BannerBean> getBanner();
}
