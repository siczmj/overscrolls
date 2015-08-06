package com.nirigo.mobile.overscrolls.examples;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.nirigo.mobile.overscrolls.R;
import com.nirigo.mobile.overscrolls.other.BaseFragment;
import com.nirigo.mobile.overscrolls.other.ListViewAdapter;

/**
 * Created by Sicz-Mesziár János on 2015.08.06..
 */
public class ListViewExampleFragment extends BaseFragment {

    private ListView listview;
    private ListViewAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflateFragmentLayout(inflater, container, R.layout.fragment_listview);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listview = (ListView) this.view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        adapter = new ListViewAdapter();
        listview.setAdapter(adapter);


    }




}
