package com.example.richard.fragmentapptest;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class RViewHolder extends RecyclerView.ViewHolder {

    TextView tv;

    public RViewHolder(View v) {
        super(v);
        tv = (TextView) v.findViewById(R.id.tv1);
    }

    TextView getText() {
        return tv;
    }
}
