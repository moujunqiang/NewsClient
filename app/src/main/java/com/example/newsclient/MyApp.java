package com.example.newsclient;

import android.app.Application;

import com.example.newsclient.http.model.RequestHandler;
import com.example.newsclient.http.server.ReleaseServer;
import com.example.newsclient.http.server.TestServer;
import com.hjq.http.EasyConfig;
import com.hjq.http.config.IRequestServer;

import okhttp3.OkHttpClient;

/**

 * @Version 1.0
 */
public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // 网络请求框架初始化
        IRequestServer server;
        if (true) {
            server = new TestServer();
        } else {
            server = new ReleaseServer();
        }

        EasyConfig.with(new OkHttpClient())
                // 是否打印日志
                .setLogEnabled(true)
                // 设置服务器配置
                .setServer(server)
                // 设置请求处理策略
                .setHandler(new RequestHandler())
                // 设置请求重试次数
                .setRetryCount(1)
                // 添加全局请求参数
                //.addParam("token", "6666666")
                // 添加全局请求头
                //.addHeader("time", "20191030")
                // 启用配置
                .into();

    }
}
