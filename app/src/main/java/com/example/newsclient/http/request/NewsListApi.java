package com.example.newsclient.http.request;

import com.hjq.http.config.IRequestApi;

/**
 * desc   : 新闻列表
 */
public class NewsListApi implements IRequestApi {

    @Override
    public String getApi() {
        return "allnews/index";
    }

    String col;
    String key = "1206b4de87aa23cc915baefe88887c48";
    private String num="10";
    public NewsListApi setCol(String type) {
        this.col = type;
        return this;
    }


}