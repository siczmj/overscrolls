package com.nirigo.mobile.view.overscrolls;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebView;

import com.nirigo.mobile.view.overscrolls.interfaces.OverScrollMeasure;
import com.nirigo.mobile.view.overscrolls.internal.OverScrollHelper;

/**
 * Created by Sicz-Mesziár János on 2015.08.11..
 */
public class OverScrollWebView extends WebView {

    private OverScrollHelper overScroll;

    public OverScrollWebView(Context context) {
        super(context);
        init();
    }

    public OverScrollWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public OverScrollWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public OverScrollWebView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }


    private void init() {
        this.setOverScrollMode(OVER_SCROLL_ALWAYS);
        this.overScroll = new OverScrollHelper(this);
        this.overScroll.setOnOverScrollMeasure(new OverScrollMeasure() {
            public int getScrollY() {
                return computeVerticalScrollOffset();
            }
        });
    }

    // Events --------------------------------------------------------------------------------------
    @Override
    public boolean onTouchEvent(@NonNull MotionEvent event) {
        return overScroll.onTouchEvent(event) || super.onTouchEvent(event);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        overScroll.onScrollChanged();
        super.onScrollChanged(l, t, oldl, oldt);
    }


    // Getters -----------------------------------------------------------------------------------
    public OverScrollHelper getOverScroll() {
        return overScroll;
    }

}
