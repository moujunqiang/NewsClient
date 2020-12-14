package com.example.newsclient;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.newsclient.bean.VideoEntity;
import com.example.newsclient.http.response.NewsBean;

import java.io.Serializable;

public class WebActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mIvBack;
    private TextView mTvTitle;
    private WebView mWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        initView();
    }

    private void initView() {
        NewsBean newsBean = (NewsBean) getIntent().getSerializableExtra("news");
        mIvBack = (ImageView) findViewById(R.id.iv_back);
        mIvBack.setOnClickListener(this);
        mTvTitle = (TextView) findViewById(R.id.tv_title);
        //设置标题
        mTvTitle.setText(newsBean.getTitle());
        mWeb = (WebView) findViewById(R.id.web);
        WebSettings settings = mWeb.getSettings();
        settings.setJavaScriptEnabled(true);

        mWeb.setWebChromeClient(new WebChromeClient());
        mWeb.setWebViewClient(new WebViewClient());
        //加载网址
        mWeb.loadUrl(newsBean.getUrl());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.iv_back:
                finish();
                break;
        }
    }
}