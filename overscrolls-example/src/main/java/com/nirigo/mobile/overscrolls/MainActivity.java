package com.nirigo.mobile.overscrolls;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.nirigo.mobile.overscrolls.examples.ListViewExampleFragment;
import com.nirigo.mobile.overscrolls.examples.ScrollViewExampleFragment;
import com.nirigo.mobile.overscrolls.other.BaseFragment;
import com.nirigo.mobile.overscrolls.other.ViewPagerAdapter;
import com.nirigo.mobile.view.overscrolls.OverScrollScrollView;
import com.nirigo.mobile.view.overscrolls.interfaces.OverScrollListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewpager;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewpager = (ViewPager) findViewById(R.id.viewpager);

        List<Class<? extends BaseFragment>> fragments = new ArrayList<>();
        fragments.add(ScrollViewExampleFragment.class);
        fragments.add(ListViewExampleFragment.class);

        adapter = new ViewPagerAdapter(getSupportFragmentManager(), fragments);
        viewpager.setAdapter(adapter);

    }




}
