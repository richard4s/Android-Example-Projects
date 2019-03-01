package com.example.richard.classproject1;

import android.content.SharedPreferences;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_second);
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new TestFragment()).commit();
    }

    public static class TestFragment extends PreferenceFragment {
        SharedPreferences sf;

        @Override
        public void onStart() {
            super.onStart();
            sf = PreferenceManager.getDefaultSharedPreferences(getActivity());
        }

        @Override
        public void onCreate(Bundle savedInstance) {
            super.onCreate(savedInstance);

            addPreferencesFromResource(R.xml.preference);
            ListPreference Ipreference = (ListPreference)findPreference("List");
            Ipreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                @Override
                public boolean onPreferenceChange(Preference preference, Object newValue) {
                    String value = (String) newValue;
                    SharedPreferences.Editor editor = sf.edit();
                    editor.putString("list", value);
                    editor.commit();
                    Log.v(getActivity().getClass().getSimpleName(), "Everything worked successfully!");
                    return true;
                }
            });

            CheckBoxPreference cb=(CheckBoxPreference) findPreference("checkbox1");
            cb.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                @Override
                public boolean onPreferenceChange(Preference preference, Object newValue) {
                    Boolean value = (Boolean) newValue;
                    SharedPreferences.Editor editor = sf.edit();
                    editor.putBoolean("checkbox1", value);
                    editor.commit();
                    Log.v(getActivity().getClass().getSimpleName(), "Everything worked successfully!");
                    return true;
                }
            });
        }
    }
}

