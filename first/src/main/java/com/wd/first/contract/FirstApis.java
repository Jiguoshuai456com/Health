package com.wd.first.contract;

import com.wd.first.bean.BIngBean;
import com.wd.first.bean.BannerBean;
import com.wd.first.bean.DepartmenBean;
import com.wd.first.bean.DetailsBean;
import com.wd.first.bean.DrgusBean;
import com.wd.first.bean.LittleBean;

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
    @GET("knowledgeBase/v1/findDiseaseKnowledge")
    Observable<DetailsBean> getDetails(@Query("id") int id);
    @GET("knowledgeBase/v1/findDrugsCategoryList")
    Observable<DrgusBean> getDrugs();
    @GET("knowledgeBase/v1/findDrugsKnowledgeList")
    Observable<LittleBean> getLittle(@Query("drugsCategoryId") int id,@Query("page")int page,@Query("count")int count);


}
