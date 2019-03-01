package com.example.richard.whatsappdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.TabActivity;
import android.widget.TabHost;

public class TabViewTest extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_view_test);

        TabHost tab = getTabHost();

        TabHost.TabSpec firstTab = tab.newTabSpec("First Tab");
        firstTab.setIndicator("First Tab");
        Intent firstIntent = new Intent(this, FirstTabActivity.class);
        firstTab.setContent(firstIntent);
        tab.addTab(firstTab);

        TabHost.TabSpec secondTab = tab.newTabSpec("Second Tab");
        secondTab.setIndicator("Second Tab");
        Intent secondIntent = new Intent(this, SecondTabActivity.class);
        secondTab.setContent(secondIntent);
        tab.addTab(secondTab);
    }
}
