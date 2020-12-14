package com.example.newsclient;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.newsclient.adapter.NewsListAdapter;
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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class NewListFragment extends Fragment implements OnRefreshListener, OnHttpListener {

    private View inflate;

    TabLayout tabAll;
    RecyclerView rvHome;
    SmartRefreshLayout smart;
    private String typeid;
    List<String> ids;
    private List<NewsBean> newsBeans = new ArrayList<>();
    NewsListAdapter adapter;

    public static NewListFragment newInstance() {

        Bundle args = new Bundle();

        NewListFragment fragment = new NewListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_news, null, false);
        initView();
        return inflate;
    }

    public void initView() {
        tabAll = inflate.findViewById(R.id.tab_all);
        smart = inflate.findViewById(R.id.smart);
        rvHome = inflate.findViewById(R.id.rv_home);
        smart.setEnableLoadMore(false);
        smart.setOnRefreshListener(this);

        rvHome.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new NewsListAdapter();
        adapter.setNewsBeans(newsBeans);
        rvHome.setAdapter(adapter);
        //点击跳转到详情页面 webview加载网址
        adapter.setOnItemClickListener(new NewsListAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getContext(), WebActivity.class);
                intent.putExtra("news", newsBeans.get(position));
                startActivity(intent);
            }
        });
        getTypeList();
        getNews("43");
    }

    /**
     * 获取新闻列表
     *
     * @param type
     */
    public void getNews(String type) {
        EasyHttp.get(this)
                .api(new NewsListApi().setCol(type))
                .request(new HttpCallback<HttpData<List<NewsBean>>>(this) {

                    @Override
                    public void onSucceed(HttpData<List<NewsBean>> data) {
                        smart.finishRefresh();
                        newsBeans.clear();
                        newsBeans.addAll(data.getData());
                        adapter.notifyDataSetChanged();
                    }
                });
    }

    /**
     * 获取分类列表数据
     */
    public void getTypeList() {
        EasyHttp.get(this)
                .api(new TypeApi())
                .request(new HttpCallback<HttpData<List<TypeBean>>>(this) {

                    @Override
                    public void onSucceed(HttpData<List<TypeBean>> data) {
                        smart.finishRefresh();
                        initTabView(data.getData().subList(0, 6));
                    }
                });


    }

    /**
     * 自定义tablayout 的item
     */
    private void initTabView(final List<TypeBean> typeBeans) {
        for (int x = 0; x < typeBeans.size(); x++) {
            TabLayout.Tab tab = tabAll.newTab();
            View inflate = View.inflate(getContext(), R.layout.layout_type_tab, null);
            TextView textView = inflate.findViewById(R.id.tv_tab_title);
            textView.setText(typeBeans.get(x).getName());
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

                getNews(typeBeans.get(tab.getPosition()).getColid() + "");


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
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        getNews(typeid);

    }

    @Override
    public void onSucceed(Object result) {

    }

    @Override
    public void onFail(Exception e) {

    }
}
