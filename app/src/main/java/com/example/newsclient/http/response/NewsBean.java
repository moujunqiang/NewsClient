package com.example.newsclient.http.response;

public class NewsBean {


    /**
     * ctime : 2019-03-20 14:21
     * title : 副局长开会跷二郎腿抖脚韩国瑜怒：哪个单位的！
     * description : 中华国内
     * picUrl : https://img1.utuku.china.com/162x110/news/20190320/44eb97f1-344a-4700-b346-cee5042ab302.jpg
     * url : https://news.china.com/focus/taiwan/11165943/20190320/35472297.html
     */

    private String ctime;
    private String title;
    private String description;
    private String picUrl;
    private String url;

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
