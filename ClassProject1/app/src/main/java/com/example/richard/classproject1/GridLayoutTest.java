package com.example.richard.classproject1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class GridLayoutTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_layout_test);

//        String[] images = new String[]{"image1", "image2", "image3", "images4"};
//        GridView gview = (GridView) findViewById(R.id.gview);

//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1, images);
//        gview.setAdapter(adapter);

        GridView gview = (GridView) findViewById(R.id.gview);
        gview.setAdapter(new ImageAdpt(this));

        gview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(GridLayoutTest.this, FullDisplayActivity.class);
                intent.putExtra("id", position);
                startActivity(intent);
            }
        });
    }
}
