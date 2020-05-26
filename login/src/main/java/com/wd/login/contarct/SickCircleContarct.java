package com.wd.login.contarct;

import com.wd.common.Base.IBaseView;
import com.wd.login.bean.login_SinckCircleBean;

/*
 *@Auther:cln
 *@Date: 2020/5/26
 *@Time:22:25
 *@Description:
 * */public interface SickCircleContarct {
     interface SinckCircleView extends IBaseView{
        void SinckCircleSuccess(login_SinckCircleBean sinckCircleBean);
        void SinckCircleError(String str);
     }
     interface SinckCirclePresenter{
         void getSinckCircle(int departmentId,int page,int count);
     }
     interface SinckCircleModel{
         void getSinckCircle(int departmentId,int page,int count,SinckCircleICallBack iCallBack);
         interface SinckCircleICallBack{
             void SinckCircleSuccess(login_SinckCircleBean sinckCircleBean);
             void SinckCircleError(String str);
         }
     }
}
