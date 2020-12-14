package com.example.newsclient;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsclient.adapter.RecyclerViewLoadMoreAdapter;
import com.example.newsclient.bean.VideoEntity;
import com.example.newsclient.http.Urls;
import com.example.newsclient.http.response.TypeBean;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cn.jzvd.Jzvd;

/**
 * 视频列表
 */
public class VideoListFragment extends Fragment {

    private View inflate;

    RecyclerView rvVideo;
    RecyclerViewLoadMoreAdapter adapterVideoList;
    ArrayList<VideoEntity> videos;
    TabLayout tabAll;

    public static VideoListFragment newInstance() {

        Bundle args = new Bundle();

        VideoListFragment fragment = new VideoListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_videos, null, false);
        initView();
        return inflate;
    }

    public void initView() {
        tabAll = inflate.findViewById(R.id.tab_all);

        videos = new ArrayList<>();
        rvVideo = inflate.findViewById(R.id.rv_video);
        addData();
        rvVideo.setLayoutManager(new LinearLayoutManager(getContext()));
        adapterVideoList = new RecyclerViewLoadMoreAdapter(getContext(), videos);
        rvVideo.setAdapter(adapterVideoList);
        rvVideo.addOnChildAttachStateChangeListener(new RecyclerView.OnChildAttachStateChangeListener() {
            @Override
            public void onChildViewAttachedToWindow(View view) {

            }

            @Override
            public void onChildViewDetachedFromWindow(View view) {
                Jzvd jzvd = view.findViewById(R.id.videoplayer);
                if (jzvd != null && Jzvd.CURRENT_JZVD != null &&
                        jzvd.jzDataSource.containsTheUrl(Jzvd.CURRENT_JZVD.jzDataSource.getCurrentUrl())) {
                    if (Jzvd.CURRENT_JZVD != null && Jzvd.CURRENT_JZVD.screen != Jzvd.SCREEN_FULLSCREEN) {
                        Jzvd.releaseAllVideos();
                    }
                }
            }
        });
        //设置顶部标题
        List<String> videoTitles = new ArrayList<>();
        videoTitles.add("推荐");
        videoTitles.add("竖");
        videoTitles.add("炫");
        videoTitles.add("美食");
        initTabView(videoTitles);

    }

    /**
     * 添加视频数据
     */
    private void addData() {
        ArrayList<VideoEntity> tempList = new ArrayList<>();
        for (int i = 0; i < Urls.videoUrls[0].length; i++) {
            VideoEntity videoEntity = new VideoEntity();
            videoEntity.setUrl(Urls.videoUrls[0][i]);
            videoEntity.setTitle(Urls.videoTitles[0][i]);
            videoEntity.setThumb(Urls.videoPosters[0][i]);
            videoEntity.setDesc(Urls.videoDesc[0][i]);
            tempList.add(videoEntity);
        }
        //随机打乱
        Collections.shuffle(tempList);
        videos.addAll(tempList);
    }

    /**
     * 自定义tablayout 的item
     */
    private void initTabView(final List<String> typeBeans) {
        for (int x = 0; x < typeBeans.size(); x++) {
            TabLayout.Tab tab = tabAll.newTab();
            View inflate = View.inflate(getContext(), R.layout.layout_type_tab, null);
            TextView textView = inflate.findViewById(R.id.tv_tab_title);
            textView.setText(typeBeans.get(x));
            tab.setCustomView(inflate);
            tabAll.addTab(tab);
        }
        tabAll.setTabRippleColor(ColorStateList.valueOf(getResources().getColor(R.color.white)));

        tabAll.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                View view = tab.getCustomView();
                if (null != view && view instanceof TextView) {
                    ((TextView) view).setTextSize(18);
                    ((TextView) view).setTextColor(getResources().getColor(R.color.color_21B8FF));
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                View view = tab.getCustomView();
                if (null != view && view instanceof TextView) {
                    ((TextView) view).setTextSize(14);
                    ((TextView) view).setTextColor(getResources().getColor(R.color.color_444444));
                }

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                View view = tab.getCustomView();
                if (null != view && view instanceof TextView) {
                    ((TextView) view).setTextSize(18);
                    ((TextView) view).setTextColor(getResources().getColor(R.color.color_21B8FF));
                }
            }
        });
        tabAll.getTabAt(0).select();
    }

    @Override
    public void onPause() {
        super.onPause();
        Jzvd.releaseAllVideos();
    }
}
