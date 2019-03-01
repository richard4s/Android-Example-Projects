package com.example.richard.fragmentapptest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public class RAdapter extends RecyclerView.Adapter<RViewHolder> {

    Context context;

    @Override
    public RViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        return null;
    }

    @Override
    public void onBindViewHolder(RViewHolder holder, int position) {
        holder.getText().setText(DataClass.musician[position]);
    }

    @Override
    public int getItemCount() {
        return DataClass.musician.length;
    }
}
