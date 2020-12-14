package com.example.newsclient.bean;

import java.io.Serializable;

public class VideoEntity implements Serializable {
    private String url;
    private String title;
    private String thumb;
    private String desc;

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }
}
