package com.example.newsclient.http.request;

import com.hjq.http.config.IRequestApi;
import com.hjq.http.config.IRequestHost;

/**
 * desc   : 视频请求地址
 */
public class VideoApi implements IRequestApi, IRequestHost {

    @Override
    public String getApi() {
        return "";
    }

    @Override
    public String getHost() {
        return "http://baobab.kaiyanapp.com/api/v5/index/tab/allRec?udid=a53873ffaa4430bbb41ea178c1187e97c4b3c4a";
    }
}