package com.nirigo.mobile.overscrolls.other;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.nirigo.mobile.overscrolls.R;

/**
 * Created by Sicz-Mesziár János on 2015.08.11..
 */
public class BaseActivity extends AppCompatActivity {

    private TextView scrollInfoTextView;

    protected void findScrollInfoTextView(){
        scrollInfoTextView = (TextView) findViewById(R.id.scroll_info);
    }

    public void hideScrollInfo(){
        if(scrollInfoTextView != null)
            scrollInfoTextView.setVisibility(View.INVISIBLE);
    }

    public void showScrollInfo(String text){
        if(scrollInfoTextView != null) {
            scrollInfoTextView.setText(text);
            scrollInfoTextView.setVisibility(View.VISIBLE);
        }
    }
}
