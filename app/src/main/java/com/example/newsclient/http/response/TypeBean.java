package com.example.newsclient.http.response;

/**
 * @Description: java类作用描述
 * @Author: mjq
 * @CreateDate: 2020/6/17$ 12:33$
 */
public class TypeBean {

    /**
     * apiid : 188
     * colid : 42
     * name : 垃圾分类新闻
     * nameid : lajifenleinews
     * jianjie : 垃圾分类新闻资讯接口
     */

    private int apiid;
    private int colid;
    private String name;
    private String nameid;
    private String jianjie;

    public int getApiid() {
        return apiid;
    }

    public void setApiid(int apiid) {
        this.apiid = apiid;
    }

    public int getColid() {
        return colid;
    }

    public void setColid(int colid) {
        this.colid = colid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameid() {
        return nameid;
    }

    public void setNameid(String nameid) {
        this.nameid = nameid;
    }

    public String getJianjie() {
        return jianjie;
    }

    public void setJianjie(String jianjie) {
        this.jianjie = jianjie;
    }
}
