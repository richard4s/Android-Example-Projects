package com.example.richard.whatsappdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Button myBtn = (Button) findViewById(R.id.myBtn);
//        myBtn.setOnClickListener((e -> {
//            Intent intent = new Intent(this, SimpleCursorTest.class);
//            startActivity(intent);
//        }));

        final String[] list = new String[]{"TabView", "ListView", "TextView", "WebView"};

        ListView lv = (ListView) findViewById(R.id.mainList);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(list[position].equalsIgnoreCase("TabView")) {
                    Intent intent = new Intent(MainActivity.this, TabViewTest.class);
                    startActivity(intent);
                } else if(list[position].equalsIgnoreCase("WebView")) {
                    Intent intent = new Intent(MainActivity.this, WebViewTest.class);
                    startActivity(intent);
                }
            }
        });

    }
}
