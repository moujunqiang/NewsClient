package com.example.newsclient.http.request;

import com.hjq.http.config.IRequestApi;

/**
 * desc   : 用户登录
 */
public class LoginApi implements IRequestApi {

    @Override
    public String getApi() {
        return "ReaderLogin";
    }

    /**
     * 手机号
     */
    private String mobile;
    /**
     * 登录密码
     */
    private String password;

    public LoginApi setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public LoginApi setPassword(String password) {
        this.password = password;
        return this;
    }
}