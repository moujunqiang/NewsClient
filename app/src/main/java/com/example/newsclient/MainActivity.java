package com.example.newsclient;

import android.os.Bundle;
import android.text.style.EasyEditSpan;
import android.view.MenuItem;

import com.example.newsclient.adapter.BaseFragmentAdapter;
import com.example.newsclient.bean.ImageTextView;
import com.example.newsclient.view.NoScrollViewPager;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.hjq.http.EasyConfig;
import com.hjq.http.EasyHttp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private NoScrollViewPager mViewPager;
    private BottomNavigationView mBottomNavigationView;
    private BaseFragmentAdapter<Fragment> mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mViewPager = (NoScrollViewPager) findViewById(R.id.vp_home_pager);
        mBottomNavigationView = (BottomNavigationView) findViewById(R.id.bv_home_navigation);
        mBottomNavigationView.setItemIconTintList(null);
        mBottomNavigationView.setOnNavigationItemSelectedListener(this);
        mPagerAdapter = new BaseFragmentAdapter<>(this);
        mPagerAdapter.addFragment(NewListFragment.newInstance());
        mPagerAdapter.addFragment(VideoListFragment.newInstance());
        mPagerAdapter.addFragment(ImageFragment.newInstance());
        mPagerAdapter.addFragment(TextFragment.newInstance());
        mPagerAdapter.addFragment(Text2Fragment.newInstance());

        mViewPager.setAdapter(mPagerAdapter);

        // 限制页面数量
        mViewPager.setOffscreenPageLimit(mPagerAdapter.getCount());
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_news:
                mPagerAdapter.setCurrentItem(NewListFragment.class);
                return true;
            case R.id.menu_video:
                mPagerAdapter.setCurrentItem(VideoListFragment.class);
                return true;
            case R.id.menu_image:
                mPagerAdapter.setCurrentItem(ImageFragment.class);
                return true;
            case R.id.menu_text1:
                mPagerAdapter.setCurrentItem(TextFragment.class);
                return true;
            case R.id.menu_text2:
                mPagerAdapter.setCurrentItem(Text2Fragment.class);
                return true;
            default:
                break;
        }
        return false;
    }

}