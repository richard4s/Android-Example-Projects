package com.example.richard.whatsappdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleAdapterTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_adapter_test);

        ListView lview = (ListView) findViewById(R.id.nlview);
        Integer[] image = new Integer[]{R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4};
        final String[] animalName = new String[]{"Pheonix 1", "Pheonix 2", "Pheonix 3", "Pheonix 4"};
        String[] from = new String[]{"nimage", "image"};
        int[] to = new int[]{R.id.tviewn, R.id.imgView};

        List<Map<String, String>> list = new ArrayList<>();
        for(int i = 0; i < image.length; i++) {
            HashMap<String, String> hmap = new HashMap<>();
            hmap.put("nimage", animalName[i]);
            hmap.put("image", String.valueOf(image[i]));
            list.add(hmap);
        }

        SimpleAdapter sa = new SimpleAdapter(this, list, R.layout.activity_simple_adapter_test, from, to);
        lview.setAdapter(sa);
        lview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SimpleAdapterTest.this, animalName[position] + "is clicked", Toast.LENGTH_LONG).show();
            }
        });
    }
}
