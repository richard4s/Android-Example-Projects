package com.example.richard.fragclasstest;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements FirstFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .replace(android.R.id.content, FirstFragment.newInstance()).commit();
//        findViewById(R.id.btn);
    }

    @Override
    public void onAction() {
        Toast.makeText(MainActivity.this, "Button clicked", Toast.LENGTH_LONG).show();
    }

    boolean isLandscape() {
        return getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE
    }

    void loadFragment(int index) {

    }
}
