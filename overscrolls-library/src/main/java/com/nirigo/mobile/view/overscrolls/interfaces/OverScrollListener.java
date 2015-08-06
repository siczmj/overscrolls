package com.nirigo.mobile.view.overscrolls.interfaces;

import android.view.ViewGroup;

/**
 * Created by Sicz-Mesziár János on 2015.08.04..
 */
public interface OverScrollListener {
    void onScroll(ViewGroup parent, int scrollX, int scrollY);
    void onOverScrollStart(ViewGroup parent);
    void onOverScroll(ViewGroup parent, int overscrollX, int overscrollY);
    void onOverScrollCancel(ViewGroup parent);
}
