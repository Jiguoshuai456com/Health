package com.wd.login.api;

import com.wd.login.bean.login_CheckCodeBean;
import com.wd.login.bean.login_EmailBean;
import com.wd.login.bean.login_LoginBean;
import com.wd.login.bean.login_RegisterBean;
import com.wd.login.bean.login_ResetUserPwdBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

/*
 *@Auther:cln
 *@Date: 2020/5/20
 *@Time:16:24
 *@Description:
 * */public interface Login_Apis {
     //邮箱
     @POST("user/v1/sendOutEmailCode")
     @FormUrlEncoded
     Observable<login_EmailBean>doemail(@Field("email") String email);

    //登录接口
    @POST("user/v1/login")
    @FormUrlEncoded
    Observable<login_LoginBean>doLog(@Field("email")String email,@Field("pwd")String pwd);
    //注册接口     邀请码（非必须参数）@Field("invitationCode")String invitationCode
    @POST("user/v1/register")
    @FormUrlEncoded
    Observable<login_RegisterBean>doRegister(@Field("email")String email,@Field("code")String code
            ,@Field("pwd1")String pwd1,@Field("pwd2")String pwd2,@Field("invitationCode")String invitationCode);
    //忘记密码
    @POST("user/v1/checkCode")
    @FormUrlEncoded
    Observable<login_CheckCodeBean>doCheckCode(@Field("email")String email,@Field("code")String code);
    //重置用户密码
//    @PUT("user/v1/resetUserPwd")
//    Observable<login_ResetUserPwdBean>doResetUserPwd(@Query("email")String email,@Query("pwd1")String pwd1,@Query("pwd2")String pwd2);

}
