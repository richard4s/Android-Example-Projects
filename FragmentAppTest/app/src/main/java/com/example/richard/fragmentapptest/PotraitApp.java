package com.example.richard.fragmentapptest;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 *
 * to handle interaction events.
 * Use the {@link PotraitApp#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PotraitApp extends Fragment {

    static String color = "color";

    public PotraitApp() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static PotraitApp newInstance(int c) {
        PotraitApp fragment = new PotraitApp();
        Bundle args = new Bundle();
        args.putInt(color, c);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.activity_main, container, false);
        v.setBackgroundColor(getArguments().getInt(color));
        TextView tView = (TextView) v.findViewById(R.id.tview);
        return v;
    }

    public interface FragmentTestOneListener{
        void fOneonClick(int i);
    }


}
