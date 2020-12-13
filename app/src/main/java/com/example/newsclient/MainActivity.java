package com.example.newsclient;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.newsclient.adapter.BaseFragmentAdapter;
import com.example.newsclient.view.NoScrollViewPager;
import com.google.android.material.bottomnavigation.BottomNavigationView;

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
        mPagerAdapter.addFragment(HomeFragment.newInstance());
        mPagerAdapter.addFragment(MineFragment.newInstance());

        mViewPager.setAdapter(mPagerAdapter);

        // 限制页面数量
        mViewPager.setOffscreenPageLimit(mPagerAdapter.getCount());
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_news:
                mPagerAdapter.setCurrentItem(HomeFragment.class);
                return true;
            case R.id.menu_video:
                mPagerAdapter.setCurrentItem(MineFragment.class);
                return true;
            default:
                break;
        }
        return false;
    }

}