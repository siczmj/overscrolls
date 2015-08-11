package com.nirigo.mobile.view.overscrolls.internal;

import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.ListView;

import com.nirigo.mobile.view.overscrolls.interfaces.OverScrollListener;
import com.nirigo.mobile.view.overscrolls.interfaces.OverScrollMeasure;

/**
 * Created by Sicz-Mesziár János on 2015.08.06..
 */
public class OverScrollHelper {

    //@formatter:off
    public final static int STATE_SCROLL_STOPPED    = 0,
                            STATE_SCROLL            = 1,
                            STATE_SCROLL_OVER_START = 2,
                            STATE_SCROLL_OVER       = 3,
                            STATE_SCROLL_OVER_END   = 4;
    //@formatter:on

    private ViewGroup targetView;
    private float startOverScrollY = 0;
    private float currentOverScrollY = 0;
    private int scrollState = STATE_SCROLL_STOPPED;
    private boolean scrollKinetic = false;

    private OverScrollListener onOverScrollListener = null;
    private OverScrollMeasure onOverScrollMeasure = null;


    // Constructor ---------------------------------------------------------------------------------
    public OverScrollHelper(ViewGroup targetView) {
        this.targetView = targetView;
    }

    // Events --------------------------------------------------------------------------------------
    public boolean onTouchEvent(MotionEvent event) {

        // When nobody watch then do nothing
        if (onOverScrollListener == null)
            return false;

        int action = event.getAction();
        if (action == MotionEvent.ACTION_DOWN) {

            scrollKinetic = false;
            // Do nothing...

        } else if (action == MotionEvent.ACTION_MOVE) {

            if (getScrollY() > 0) {

                if (scrollState == STATE_SCROLL_OVER) {
                    scrollState = STATE_SCROLL_OVER_END;
                    postOverScrollCancel();
                } else {
                    scrollState = STATE_SCROLL;
                    postScroll(0, getScrollY());
                }

            } else {

                if (scrollState != STATE_SCROLL_OVER && scrollState != STATE_SCROLL_OVER_START) {
                    scrollState = STATE_SCROLL_OVER_START;
                    startOverScrollY = event.getY();
                    postOverScrollStart();
                } else {
                    scrollState = STATE_SCROLL_OVER;
                    currentOverScrollY = event.getY() - startOverScrollY;
                    if (currentOverScrollY > 0) {
                        postOverScroll(0, (int) currentOverScrollY);
                        return true;
                    }
                }

            }

        } else if (action == MotionEvent.ACTION_UP) {

            scrollKinetic = true;

            if (scrollState == STATE_SCROLL_OVER) {
                scrollState = STATE_SCROLL_STOPPED;
                postOverScrollCancel();
            }

        }

        return false;
    }

    public void onScrollChanged() {
        // Report scroll after release screen
        int newScrollY = getScrollY();
        if (scrollKinetic && newScrollY >= 0)
            postScroll(0, newScrollY);
    }

    // Functions -----------------------------------------------------------------------------------
    public int getScrollY() {
        if (onOverScrollMeasure != null) {
            return onOverScrollMeasure.getScrollY();
        } else {
            return targetView.getScrollY();
        }
    }

    // NOTIFY --------------------------------------------------------------------------------------
    private void postScroll(int scrollX, int scrollY) {
        Log.d("o", "Scroll {" + scrollX + " - " + scrollY + "}");
        if (onOverScrollListener != null) {
            onOverScrollListener.onScroll(targetView, scrollX, scrollY);
        }
    }

    private void postOverScrollStart() {
        Log.d("o", "Overscroll START...");
        if (onOverScrollListener != null) {
            onOverScrollListener.onOverScrollStart(targetView);
        }
    }

    private void postOverScroll(int overscrollX, int overScrollY) {
        Log.d("o", "Overscroll ....... " + overscrollX + " - " + overScrollY);
        if (onOverScrollListener != null) {
            onOverScrollListener.onOverScroll(targetView, overscrollX, overScrollY);
        }
    }

    private void postOverScrollCancel() {
        Log.d("o", "Overscroll ...CANCEL");
        if (onOverScrollListener != null) {
            onOverScrollListener.onOverScrollCancel(targetView);
        }
    }

    // Getters -------------------------------------------------------------------------------------
    public float getStartOverScrollY() {
        return startOverScrollY;
    }

    public float getCurrentOverScrollY() {
        return currentOverScrollY;
    }

    public int getScrollState() {
        return scrollState;
    }

    public ViewGroup getTargetView() {
        return targetView;
    }

    // Setters -------------------------------------------------------------------------------------
    public void setOnOverScrollListener(OverScrollListener onOverScrollListener) {
        this.onOverScrollListener = onOverScrollListener;
    }

    public void setOnOverScrollMeasure(OverScrollMeasure onOverScrollMeasure) {
        this.onOverScrollMeasure = onOverScrollMeasure;
    }
}
