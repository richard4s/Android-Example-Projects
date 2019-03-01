package com.example.richard.classproject1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewActivityTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_test);

        String items[] = new String[]{"Grid View", "Progress Test", "Radio Group", "Copy File"};
        ListView myList = (ListView)findViewById(R.id.myListView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        myList.setAdapter(adapter);
        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(items[position].equalsIgnoreCase("Grid View")) {
                    Toast.makeText(getApplicationContext(), "Grid View has been clicked", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(ListViewActivityTest.this, GridLayoutTest.class);
                    startActivity(i);
                }
                if(items[position].equalsIgnoreCase("Progress Test")) {
                    Intent i = new Intent(ListViewActivityTest.this, ProgressTest.class);
                    startActivity(i);
                }
                if(items[position].equalsIgnoreCase("Radio Group")) {
                    Intent i = new Intent(ListViewActivityTest.this, CheckRadio.class);
                    startActivity(i);
                }
                if(items[position].equalsIgnoreCase("Copy File")) {
                    Intent i = new Intent(ListViewActivityTest.this, CopyingFilesTest.class);
                    startActivity(i);
                }
            }
        });


    }
}
