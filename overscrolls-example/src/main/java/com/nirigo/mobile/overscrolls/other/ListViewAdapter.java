package com.nirigo.mobile.overscrolls.other;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.nirigo.mobile.overscrolls.R;

/**
 * Created by Sicz-Mesziár János on 2015.08.06..
 */
public class ListViewAdapter extends BaseAdapter {

    private String content = "Hello World";

    @Override
    public int getCount() {
        return 50;
    }

    @Override
    public Object getItem(int position) {
        return content;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = View.inflate(parent.getContext(), R.layout.listitem_listview, null);
        }

        return convertView;

    }
}
