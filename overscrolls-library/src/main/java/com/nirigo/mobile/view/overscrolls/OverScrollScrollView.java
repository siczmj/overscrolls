package com.nirigo.mobile.view.overscrolls;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

import com.nirigo.mobile.view.overscrolls.interfaces.OverScrollListener;
import com.nirigo.mobile.view.overscrolls.internal.OverScrollHelper;

/**
 * Created by Sicz-Mesziár János on 2015.08.04..
 */
public class OverScrollScrollView extends ScrollView {

    private OverScrollHelper overScroll;

    // Constructor ---------------------------------------------------------------------------------
    public OverScrollScrollView(Context context) {
        super(context);
        init();
    }

    public OverScrollScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public OverScrollScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public OverScrollScrollView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }


    private void init() {
        this.setOverScrollMode(OVER_SCROLL_ALWAYS);
        this.overScroll = new OverScrollHelper(this);
    }


    // Events --------------------------------------------------------------------------------------
    @Override
    public boolean onTouchEvent(@NonNull MotionEvent event) {
        return overScroll.onTouchEvent(event) || super.onTouchEvent(event);
    }


    // Getters -----------------------------------------------------------------------------------
    public OverScrollHelper getOverScroll() {
        return overScroll;
    }



}
