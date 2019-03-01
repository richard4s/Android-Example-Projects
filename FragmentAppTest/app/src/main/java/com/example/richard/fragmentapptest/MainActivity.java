package com.example.richard.fragmentapptest;

import android.app.FragmentManager;
import android.content.res.Configuration;
import android.graphics.Color;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);

        RecyclerView rv = (RecyclerView) findViewById(R.id.mainRv);
    }

    boolean onMode() {
        return (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE);
    }

    void onLoadFragment() {
        PotraitApp pa = (PotraitApp) getSupportFragmentManager().findFragmentById(R.id.firstLandFrame);
        LandscapeApp la = (LandscapeApp) getSupportFragmentManager().findFragmentById(R.id.secondLandFrame);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        if (!onMode()) {
            if (pa == null) {
                pa = PotraitApp.newInstance(Color.rgb(0, 12, 35));
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.replace(R.id.firstLandFrame, pa);
                ft.commit();
            } else if (la != null) {
                ft.remove(la);
            }
        } else if (pa == null || la == null) {
                la = LandscapeApp.newInstance(Color.GRAY);
                pa = PotraitApp.newInstance(Color.BLUE);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.replace(R.id.firstLandFrame, pa);
                ft.replace(R.id.secondLandFrame, la);
                ft.commit();
            }
        }

    }
