package com.example.richard.classproject1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class CheckRadio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_radio);

        RadioGroup rd = (RadioGroup)findViewById(R.id.rdgroup);
        rd.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
               if(checkedId == R.id.rb1) {
                   Toast.makeText(CheckRadio.this, "Button One Clicked", Toast.LENGTH_LONG).show();
               }
           }
        });

        CheckBox chb = (CheckBox)findViewById(R.id.checkbox1);
        chb.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(CheckRadio.this, "Checked checkbox", Toast.LENGTH_LONG).show();
            }
        });

        chb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((CheckBox)v).isChecked()) {
                    Log.e(CheckBox.class.getSimpleName(), "Value is: True");
                }
                Toast.makeText(CheckRadio.this, "Another Button has been clicked", Toast.LENGTH_LONG).show();
            }
        });
    }
}
