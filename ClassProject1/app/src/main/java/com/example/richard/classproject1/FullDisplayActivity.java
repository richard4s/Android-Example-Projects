package com.example.richard.classproject1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class FullDisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_display);

        ImageView img = (ImageView) findViewById(R.id.newImage);
        Intent intent = getIntent();

        int index = intent.getIntExtra("id", 0);

        img.setImageResource(ImageAdpt.myImages[index]);

        Toast.makeText(FullDisplayActivity.this, "Name of image is " + ImageAdpt.imgText[index], Toast.LENGTH_LONG).show();
        Toast.makeText(FullDisplayActivity.this, "Index is " + (index + 1), Toast.LENGTH_LONG).show();
    }
}
