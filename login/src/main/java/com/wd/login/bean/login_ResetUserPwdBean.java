package com.wd.login.bean;

/*
 *@Auther:cln
 *@Date: 2020/5/22
 *@Time:1:46
 *@Description:重置用户密码
 * */public class login_ResetUserPwdBean {

    /**
     * message : 密码重置成功
     * status : 0000
     */

    private String message;
    private String status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
