package com.wd.login.contarct;

import com.wd.common.Base.IBaseView;
import com.wd.login.bean.login_CheckCodeBean;

/*
 *@Auther:cln
 *@Date: 2020/5/22
 *@Time:1:50
 *@Description:忘记密码和充值密码
 * */public interface login_CheckContarct {
     interface onCheckView extends IBaseView{
         void onCheckSuccess(login_CheckCodeBean checkCodeBean);
         void onCheckError(String str);

//         void onResetPwdSuccess();
     }
     interface onCheckPresenter{
         void postCheck(String email,String code);
     }
     interface onCheckModel{
         void postCheck(String email,String code,CheckICallBack iCallBack);
         interface CheckICallBack{
             void onCheckSuccess(login_CheckCodeBean checkCodeBean);
             void onCheckError(String str);
         }
     }

}
