package com.example.richard.classproject1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Button;
import android.content.Intent;


import android.util.Log;

public class MainActivity extends AppCompatActivity {

    String logData = getClass().getSimpleName();
    String LOG_TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(logData, "onCreate Executed");

        loadPreference();
        Button btn = (Button)findViewById(R.id.btn);
        btn.setOnClickListener(e -> {
            Log.e(LOG_TAG, "Button Clicked");
            System.out.println("Button has been clicked");
            Intent intent = new Intent(this, ClassProjectActivity.class);

            startActivity(intent);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(logData, "onStart Executed");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(logData, "onDestroy Executed");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.navmenu_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.myItem:
                Toast.makeText(this, "Item one selected", Toast.LENGTH_LONG).show();
                return true;
            case R.id.myListView:
                Toast.makeText(this, "Item two selected", Toast.LENGTH_LONG).show();
                return true;
            default:
                Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(logData, "onPause Executed");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(logData, "onResume Executed");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(logData, "onStop Executed");
    }

    public void loadPreference() {
        Toast.makeText(getApplicationContext(), "Load Preference Run", Toast.LENGTH_LONG).show();
        SharedPreferences sf = android.preference.PreferenceManager.getDefaultSharedPreferences(this);


        if(sf != null) {
            boolean value = (boolean) sf.getBoolean("checkbox1", false);
            String text = (String) sf.getString("name_preferences",null);
            String  text2 = (String) sf.getString("List", null);
            Toast.makeText(getApplicationContext(), "Checkbox 1 value is: " + value + "Edittext value: " + text, Toast.LENGTH_LONG).show();
            Toast.makeText(getApplicationContext(), "List value is: " + text2, Toast.LENGTH_LONG).show();
        }
    }
}
