package com.nirigo.mobile.overscrolls.examples.overscroll;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nirigo.mobile.overscrolls.R;
import com.nirigo.mobile.overscrolls.other.BaseFragment;
import com.nirigo.mobile.overscrolls.other.FakeListViewAdapter;
import com.nirigo.mobile.view.overscrolls.OverScrollListView;
import com.nirigo.mobile.view.overscrolls.interfaces.OverScrollListener;

/**
 * Created by Sicz-Mesziár János on 2015.08.06..
 */
public class ListViewExampleFragment extends BaseFragment {

    private OverScrollListView listview;
    private FakeListViewAdapter adapter;
    private View headerView;
    private TextView indicatorTextView;

    private String initalText;
    private int initialSize;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflateFragmentLayout(inflater, container, R.layout.fragment_overscroll_listview);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listview = (OverScrollListView) this.view;
        headerView = getLayoutInflater(savedInstanceState).inflate(R.layout.listheader_overscroll_listview, listview, false);
        indicatorTextView = (TextView) headerView.findViewById(R.id.indicator);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        adapter = new FakeListViewAdapter();
        listview.setAdapter(adapter);
        listview.addHeaderView(headerView);
        listview.getOverScroll().setOnOverScrollListener(new OverScrollListener() {
            public void onScroll(ViewGroup parent, int scrollX, int scrollY) {
                // On normal scroll
                showScrollInfo("onScroll: " + scrollY); // Just show on screen
            }

            public void onOverScrollStart(ViewGroup parent) {
                initalText = indicatorTextView.getText().toString();
                initialSize = indicatorTextView.getMeasuredHeight();
            }

            public void onOverScroll(ViewGroup parent, int overscrollX, int overscrollY) {
                indicatorTextView.setText(overscrollX + " ▪ " + overscrollY);
                if(overscrollY < initialSize){
                    float angle = 360 * (float)overscrollY / initialSize;
                    indicatorTextView.setRotationX(angle);
                }else {
                    indicatorTextView.setRotationX(0);
                    setIndicatorSize(overscrollY);
                }

                showScrollInfo("onOverScroll: " + overscrollY); // Just show on screen
            }

            public void onOverScrollCancel(ViewGroup parent) {
                indicatorTextView.setText(initalText);
                indicatorTextView.setRotationX(0f);
                setIndicatorSize(initialSize);
            }
        });

    }



    private void setIndicatorSize(int newSize) {
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) indicatorTextView.getLayoutParams();
        params.height = newSize;
        params.width = newSize;
        indicatorTextView.setLayoutParams(params);
    }


}
