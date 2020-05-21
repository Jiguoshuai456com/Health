package com.wd.login.bean;

/*
 *@Auther:cln
 *@Date: 2020/5/22
 *@Time:1:43
 *@Description:
 * */public class login_CheckCodeBean {

    /**
     * message : 验证通过
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
