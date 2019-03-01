package com.example.richard.dialogguy;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sf = android.preference.PreferenceManager.getDefaultSharedPreferences(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ourSharedPreference();
        Button btn = (Button) findViewById(R.id.mybtn);
        btn.setOnClickListener((e -> {
            showClickedAlertDialog();
        }));

    }

    public void showClickedAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Missile Notice");
        builder.setMessage("Launching this missile will destroy the entire universe. Is this what you intended to do?");

        builder.setPositiveButton("Launch missile", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                launchMissile();
            }
        });
        builder.setNeutralButton("Remind me later", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                RemindLater();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                AbortMissile();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void launchMissile() {
        if(sf != null) {
            SharedPreferences.Editor e =sf.edit();
            e.putBoolean("selected", true);

            Toast.makeText(getApplicationContext(), "Missile has been launched", Toast.LENGTH_LONG).show();
        }
        Toast.makeText(this, "Launching Missile...", Toast.LENGTH_LONG).show();
    }

    public void RemindLater() {
        Toast.makeText(this, "You shall be reminded later...", Toast.LENGTH_LONG).show();
    }

    public void AbortMissile() {
        if(sf != null) {
            SharedPreferences.Editor ef = sf.edit();
            ef.putBoolean("Abortation", false);

            Toast.makeText(getApplicationContext(), "Starting Abortation...", Toast.LENGTH_LONG).show();
        }
        Toast.makeText(this, "Aborting Missile...", Toast.LENGTH_LONG).show();
    }

    public void ourSharedPreference() {
        if(sf != null) {
            boolean value = (boolean) sf.getBoolean("MissileBtn", false);
            Toast.makeText(getApplicationContext(), "MissileBtn value is: " + value, Toast.LENGTH_LONG).show();
        }
        Toast.makeText(getApplicationContext(), "Load Preference Run", Toast.LENGTH_LONG).show();



    }
}
