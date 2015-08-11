package com.nirigo.mobile.overscrolls.other;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.nirigo.mobile.overscrolls.EdgeEffectActivity;
import com.nirigo.mobile.overscrolls.OverscrollActivity;
import com.nirigo.mobile.overscrolls.ParallaxActivity;
import com.nirigo.mobile.overscrolls.PullToRefreshActivity;
import com.nirigo.mobile.overscrolls.R;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Sicz-Mesziár János on 2015.08.11..
 */
public class MenuAdapter extends BaseAdapter {

    List<Menu> items = Arrays.asList(
            new Menu("Overscroll", OverscrollActivity.class),
            new Menu("Pull-to-refresh", PullToRefreshActivity.class),
            new Menu("Parallax", ParallaxActivity.class),
            new Menu("EdgeEffect", EdgeEffectActivity.class)
    );

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Menu getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Menu menu = getItem(position);

        if(convertView == null){
            convertView = View.inflate(parent.getContext(), R.layout.listitem_menu, null);
        }


        TextView title = (TextView) convertView.findViewById(R.id.title);
        title.setText(menu.toString());

        return convertView;

    }


    // Model ...
    public class Menu{

        private String name;
        private Class<?> className;

        public Menu(String name, Class<?> className) {
            this.name = name;
            this.className = className;
        }

        public String getName() {
            return name;
        }

        public Class<?> getClassName() {
            return className;
        }

        @Override
        public String toString() {
            return name;
        }
    }

}
