package com.nirigo.mobile.overscrolls;

import android.support.v4.view.ViewPager;
import android.os.Bundle;

import com.nirigo.mobile.overscrolls.examples.overscroll.OverScrollListViewExampleFragment;
import com.nirigo.mobile.overscrolls.examples.overscroll.OverScrollScrollViewExampleFragment;
import com.nirigo.mobile.overscrolls.examples.overscroll.OverScrollWebViewExampleFragment;
import com.nirigo.mobile.overscrolls.other.BaseActivity;
import com.nirigo.mobile.overscrolls.other.BaseFragment;
import com.nirigo.mobile.overscrolls.other.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class OverscrollActivity extends BaseActivity {

    private ViewPager viewpager;
    private ViewPagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overscroll);
        findScrollInfoTextView();

        viewpager = (ViewPager) findViewById(R.id.viewpager);

        List<Class<? extends BaseFragment>> fragments = new ArrayList<>();
        fragments.add(OverScrollScrollViewExampleFragment.class);
        fragments.add(OverScrollListViewExampleFragment.class);
        fragments.add(OverScrollWebViewExampleFragment.class);

        adapter = new ViewPagerAdapter(getSupportFragmentManager(), fragments);
        viewpager.setAdapter(adapter);

    }







}
