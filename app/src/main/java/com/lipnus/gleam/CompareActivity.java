package com.lipnus.gleam;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

public class CompareActivity extends AppCompatActivity {

    // 뷰페이저
    private ViewPager upPager;
    private ViewPager downPager;
    private PagerAdapter upPagerAdapter;
    private PagerAdapter downPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare);

        //툴바 없에기
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        upPager = (ViewPager) findViewById(R.id.up_pager);
        upPagerAdapter = new UpScreenSlidePagerAdapter(getSupportFragmentManager());
        upPager.setAdapter(upPagerAdapter);

        downPager = (ViewPager) findViewById(R.id.down_pager);
        downPagerAdapter = new DownScreenSlidePagerAdapter(getSupportFragmentManager());
        downPager.setAdapter(downPagerAdapter);

    }

    private class UpScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public UpScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return UpScreenSlidePageFragment.PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            //뷰페이저의 총 페이지수
            return 2;
        }
    }

    private class DownScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public DownScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return DownScreenSlidePageFragment.PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            //뷰페이저의 총 페이지수
            return 2;
        }
    }
}
