package com.example.newsclient.bean;

public class ImageTextView {
	private int imageId;          //使用id锁定水果图片
	private String content;     //对应的水果名字
	public ImageTextView(int imageId, String content) {
		super();
		this.imageId = imageId;
		this.content = content;
	}

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}