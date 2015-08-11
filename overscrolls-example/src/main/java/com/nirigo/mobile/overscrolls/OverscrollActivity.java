package com.nirigo.mobile.overscrolls;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.nirigo.mobile.overscrolls.examples.overscroll.ListViewExampleFragment;
import com.nirigo.mobile.overscrolls.examples.overscroll.ScrollViewExampleFragment;
import com.nirigo.mobile.overscrolls.other.BaseFragment;
import com.nirigo.mobile.overscrolls.other.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class OverscrollActivity extends AppCompatActivity {

    private ViewPager viewpager;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overscroll);

        viewpager = (ViewPager) findViewById(R.id.viewpager);

        List<Class<? extends BaseFragment>> fragments = new ArrayList<>();
        fragments.add(ScrollViewExampleFragment.class);
        fragments.add(ListViewExampleFragment.class);

        adapter = new ViewPagerAdapter(getSupportFragmentManager(), fragments);
        viewpager.setAdapter(adapter);

    }




}
