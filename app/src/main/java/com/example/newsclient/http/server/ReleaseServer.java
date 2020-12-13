package com.example.newsclient.http.server;

import com.hjq.demo.http.model.UrlContant;
import com.hjq.http.config.IRequestServer;

/**
 * desc   : 正式环境
 */
public class ReleaseServer implements IRequestServer {

    @Override
    public String getHost() {
        return UrlContant.BASE_URL;
    }

    @Override
    public String getPath() {
        return "";
    }
}