package com.wd.login.presenter;

import com.wd.common.Base.BasePresenter;
import com.wd.common.Base.IBaseView;
import com.wd.login.bean.login_CheckCodeBean;
import com.wd.login.contarct.login_CheckContarct;
import com.wd.login.model.login_CheckIModel;

/*
 *@Auther:cln
 *@Date: 2020/5/22
 *@Time:19:58
 *@Description:
 * */public class login_CheckIPresenter extends BasePresenter implements login_CheckContarct.onCheckPresenter {

    private login_CheckIModel mModel;

    public login_CheckIPresenter(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void initModel() {
        mModel = new login_CheckIModel();
    }

    @Override
    public void postCheck(String email, String code) {
        mModel.postCheck(email, code, new login_CheckContarct.onCheckModel.CheckICallBack() {
            @Override
            public void onCheckSuccess(login_CheckCodeBean checkCodeBean) {
                IBaseView view = getView();
                if (view instanceof login_CheckContarct.onCheckView){
                    ((login_CheckContarct.onCheckView) view).onCheckSuccess(checkCodeBean);
                }
            }

            @Override
            public void onCheckError(String str) {
                IBaseView view = getView();
                if (view instanceof login_CheckContarct.onCheckView){
                    ((login_CheckContarct.onCheckView) view).onCheckError(str);
                }
            }
        });
    }
}
