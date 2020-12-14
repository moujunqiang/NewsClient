package com.example.newsclient.http.server;


import com.example.newsclient.http.model.UrlContant;

/**
 * desc   : 测试环境
 */
public class TestServer extends ReleaseServer {

    @Override
    public String getHost() {
        return UrlContant.BASE_URL;
    }
}