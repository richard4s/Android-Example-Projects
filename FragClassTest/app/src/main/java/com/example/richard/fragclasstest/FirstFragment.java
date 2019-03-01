package com.example.richard.fragclasstest;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;



public class FirstFragment extends Fragment {


    private OnFragmentInteractionListener mListener;

    public FirstFragment() {
        // Required empty public constructor
    }

    public static FirstFragment newInstance() {
        FirstFragment fragment = new FirstFragment();
        Bundle args = new Bundle();

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
        View v= inflater.inflate(R.layout.fragment_first, container, false);
        Button btn=(Button) v.findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                OnFragmentInteractionListener onl=(OnFragmentInteractionListener) getActivity();
                onl.onAction();
            }
        });
        return v;
    }




    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onAction();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new ClassCastException();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        void onAction();
    }
}
