package com.example.newsclient.http.request;

import com.hjq.http.config.IRequestApi;

/**
 * desc   : 分类列表
 */
public class TypeApi implements IRequestApi {

    @Override
    public String getApi() {
        return "channellist/index";
    }

    private String key = "1206b4de87aa23cc915baefe88887c48";



}