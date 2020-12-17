package com.example.newsclient;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsclient.adapter.ImageTextAdapter;
import com.example.newsclient.adapter.NewsListAdapter;
import com.example.newsclient.bean.ImageTextView;
import com.example.newsclient.http.model.HttpData;
import com.example.newsclient.http.request.NewsListApi;
import com.example.newsclient.http.request.TypeApi;
import com.example.newsclient.http.response.NewsBean;
import com.example.newsclient.http.response.TypeBean;
import com.google.android.material.tabs.TabLayout;
import com.hjq.http.EasyHttp;
import com.hjq.http.listener.HttpCallback;
import com.hjq.http.listener.OnHttpListener;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

public class ImageFragment extends Fragment {

    private View inflate;

    private ListView listView;

    public static ImageFragment newInstance() {

        Bundle args = new Bundle();

        ImageFragment fragment = new ImageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_image, null, false);
        initView();
        return inflate;
    }

    public void initView() {
        listView = inflate.findViewById(R.id.listview);
        List<ImageTextView> imageTextViews = new ArrayList<>();
        imageTextViews.add(new ImageTextView(R.mipmap.image, "学习强国助手"));
        listView.setAdapter(new ImageTextAdapter(getContext(), R.layout.item_lsit, imageTextViews));
    }

}
