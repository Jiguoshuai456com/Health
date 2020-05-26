package com.wd.login.presenter;

import com.wd.common.Base.BasePresenter;
import com.wd.common.Base.IBaseView;
import com.wd.login.bean.login_SinckCircleBean;
import com.wd.login.contarct.SickCircleContarct;
import com.wd.login.model.SinckCircleIModel;

/*
 *@Auther:cln
 *@Date: 2020/5/27
 *@Time:0:15
 *@Description:
 * */public class SinckCircleIPresenter extends BasePresenter implements SickCircleContarct.SinckCirclePresenter {

    private SinckCircleIModel mModel;

    public SinckCircleIPresenter(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void initModel() {
        mModel = new SinckCircleIModel();
    }

    @Override
    public void getSinckCircle(int departmentId, int page, int count) {
        mModel.getSinckCircle(departmentId, page, count, new SickCircleContarct.SinckCircleModel.SinckCircleICallBack() {
            @Override
            public void SinckCircleSuccess(login_SinckCircleBean sinckCircleBean) {
                IBaseView view = getView();
               if (view instanceof SickCircleContarct.SinckCircleView){
                   ((SickCircleContarct.SinckCircleView) view).SinckCircleSuccess(sinckCircleBean);
               }
            }

            @Override
            public void SinckCircleError(String str) {
                IBaseView view = getView();
                if (view instanceof SickCircleContarct.SinckCircleView){
                   ((SickCircleContarct.SinckCircleView) view).SinckCircleError(str);
                }
            }
        });
    }
}
