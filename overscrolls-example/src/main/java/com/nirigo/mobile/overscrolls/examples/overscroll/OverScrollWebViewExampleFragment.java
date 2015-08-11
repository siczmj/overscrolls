package com.nirigo.mobile.overscrolls.examples.overscroll;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nirigo.mobile.overscrolls.R;
import com.nirigo.mobile.overscrolls.other.BaseFragment;
import com.nirigo.mobile.view.overscrolls.OverScrollScrollView;
import com.nirigo.mobile.view.overscrolls.OverScrollWebView;
import com.nirigo.mobile.view.overscrolls.interfaces.OverScrollListener;

import java.util.Iterator;

/**
 * Created by Sicz-Mesziár János on 2015.08.11..
 */
public class OverScrollWebViewExampleFragment extends BaseFragment {

    private OverScrollWebView webview;
    private TextView indicatorTextView;
    private float originalHeight;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflateFragmentLayout(inflater, container, R.layout.fragment_overscroll_webview);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.webview = (OverScrollWebView) this.view.findViewById(R.id.webview);
        this.indicatorTextView = (TextView) this.view.findViewById(R.id.indicator);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        webview.loadUrl("http://developer.android.com/index.html");
        webview.getOverScroll().setOnOverScrollListener(new OverScrollListener() {
            @Override
            public void onScroll(ViewGroup parent, int scrollX, int scrollY) {
                // On normal scroll
                showScrollInfo("onScroll: " + scrollY); // Just show on screen
            }

            @Override
            public void onOverScrollStart(ViewGroup parent) {
                originalHeight = indicatorTextView.getMeasuredHeight();
                indicatorTextView.setY(-originalHeight);
                indicatorTextView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onOverScroll(ViewGroup parent, int overscrollX, int overscrollY) {
                indicatorTextView.setText("overscroll: " + overscrollY);
                indicatorTextView.setY(overscrollY-originalHeight);

                showScrollInfo("onOverScroll: " + overscrollY); // Just show on screen
            }

            @Override
            public void onOverScrollCancel(ViewGroup parent) {
                indicatorTextView.setVisibility(View.GONE);

                showScrollInfo("Cancel");
            }
        });

    }




}
