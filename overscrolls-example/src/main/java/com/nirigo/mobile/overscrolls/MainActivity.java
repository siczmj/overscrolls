package com.nirigo.mobile.overscrolls;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.nirigo.mobile.overscrolls.other.MenuAdapter;

/**
 * Created by Sicz-Mesziár János on 2015.08.11..
 */
public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MenuAdapter adapter = new MenuAdapter();
        final ListView listView = (ListView) findViewById(R.id.menu);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                MenuAdapter.Menu menu = (MenuAdapter.Menu) listView.getItemAtPosition(position);
                if(menu.getClassName() != null){
                    startActivity(new Intent(MainActivity.this, menu.getClassName()));
                }

            }
        });

    }


}
