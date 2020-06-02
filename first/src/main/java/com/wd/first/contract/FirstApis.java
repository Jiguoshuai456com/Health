package com.wd.first.contract;

import com.wd.first.bean.BIngBean;
import com.wd.first.bean.BannerBean;
import com.wd.first.bean.DepartmenBean;
import com.wd.first.bean.DetailsBean;
import com.wd.first.bean.DrgusBean;
import com.wd.first.bean.DrgusDetailsBean;
import com.wd.first.bean.LittleBean;
import com.wd.first.bean.NewsBean;
import com.wd.first.bean.NewsDetailsBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface FirstApis {
    @GET("share/v1/bannersShow")
    Observable<BannerBean> getBanner();
    @GET("share/information/v1/findInformationList")
    Observable<NewsBean> getNews(@Query("plateId") int id,@Query("page")int page,@Query("count")int count);
    @GET("share/knowledgeBase/v1/findDepartment")
    Observable<DepartmenBean> getDepart();
    @GET("share/knowledgeBase/v1/findDiseaseCategory")
    Observable<BIngBean> getBing(@Query("departmentId") int id);
    @GET("share/knowledgeBase/v1/findDiseaseKnowledge")
    Observable<DetailsBean> getDetails(@Query("id") int id);
    @GET("share/knowledgeBase/v1/findDrugsCategoryList")
    Observable<DrgusBean> getDrugs();
    @GET("share/knowledgeBase/v1/findDrugsKnowledgeList")
    Observable<LittleBean> getLittle(@Query("drugsCategoryId") int id,@Query("page")int page,@Query("count")int count);
    @GET("share/knowledgeBase/v1/findDrugsKnowledge")
    Observable<DrgusDetailsBean> getDrgusDetails(@Query("id") int id);
    @GET("share/information/v1/findInformation")
    Observable<NewsDetailsBean> getNewsDetails(@Query("infoId")int id);

}
