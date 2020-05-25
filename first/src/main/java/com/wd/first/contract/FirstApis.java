package com.wd.first.contract;

import com.wd.first.bean.BIngBean;
import com.wd.first.bean.BannerBean;
import com.wd.first.bean.DepartmenBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface FirstApis {
    @GET("v1/bannersShow")
    Observable<BannerBean> getBanner();
    @GET("knowledgeBase/v1/findDepartment")
    Observable<DepartmenBean> getDepart();
    @GET("knowledgeBase/v1/findDiseaseCategory")
    Observable<BIngBean> getBing(@Query("departmentId") int id);
}
