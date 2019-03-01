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
 * to handle interaction events.
 * Use the {@link LandscapeApp#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LandscapeApp extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    static String color = "color";

    public LandscapeApp() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment LandscapeApp.
     */
    // TODO: Rename and change types and number of parameters
    public static LandscapeApp newInstance(int c) {
        LandscapeApp fragment = new LandscapeApp();
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
        View v = inflater.inflate(R.layout.fragment_landscape_app, container, false);
        v.setBackgroundColor(getArguments().getInt(color));
        TextView tView = (TextView) v.findViewById(R.id.tview);
        return v;
    }


}
