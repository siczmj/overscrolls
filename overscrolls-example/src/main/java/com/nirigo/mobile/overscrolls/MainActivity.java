package com.nirigo.mobile.overscrolls;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.nirigo.mobile.view.overscrolls.OverScrollScrollView;
import com.nirigo.mobile.view.overscrolls.interfaces.OverScrollListener;

public class MainActivity extends AppCompatActivity {

    private OverScrollScrollView scrollView;
    private ImageView icon;
    private int tempHeight;
    private int tempY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        icon = (ImageView) findViewById(R.id.icon);


        scrollView = (OverScrollScrollView) findViewById(R.id.scrollview);
        scrollView.getOverScroll().setOnOverScrollListener(new OverScrollListener() {
            public void onScroll(ViewGroup parent, int scrollX, int scrollY) {

            }
            public void onOverScrollStart(ViewGroup parent) {
                tempHeight = icon.getMeasuredHeight();
                tempY = (int) icon.getY();
            }
            public void onOverScroll(ViewGroup parent, int overscrollX, int overscrollY) {
                setIconHeight(tempHeight + overscrollY);
                // icon.setY(tempY + overscrollY);
            }
            public void onOverScrollCancel(ViewGroup parent) {
                setIconHeight(ViewGroup.MarginLayoutParams.WRAP_CONTENT);
                // icon.setY(tempY);
            }
        });

    }

    private void setIconHeight(int newHeight){
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) icon.getLayoutParams();
        params.height = newHeight;
        icon.setLayoutParams(params);
    }


}
