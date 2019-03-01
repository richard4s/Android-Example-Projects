package com.example.richard.classproject1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class ClassProjectActivity extends AppCompatActivity {

    String LOG_TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classproject);

        Button btn = (Button)findViewById(R.id.submitBtn);
        btn.setOnClickListener(e -> {
            Log.e(LOG_TAG, "Button Clicked");
            System.out.println("Button has been clicked");
            Intent intent = new Intent(this, ListViewActivityTest.class);

            startActivity(intent);
        });
    }
}
