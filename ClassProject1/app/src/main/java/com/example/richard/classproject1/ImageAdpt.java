package com.example.richard.classproject1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageAdpt extends BaseAdapter {
    private Context context;

    public ImageAdpt(Context context) {
        this.context = context;
    }

    static Integer[] myImages = new Integer[]{R.drawable.error2,
                                        R.drawable.error3,
                                        R.drawable.error4,
                                        R.drawable.error5};
    static String[] imgText = new String[]{"First Image", "Second Image", "Third Image", "Fourth Image"};

    @Override
    public int getCount() {
        return myImages.length;
    }

    @Override
    public Object getItem(int position) {
        return myImages[position];
    }

    @Override
    public long getItemId(int position) {

        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = (View) inflater.inflate(R.layout.glayout, null);

        if(v != null) {
            ImageView img = v.findViewById(R.id.img);
            img.setImageResource(myImages[position]);

            TextView tView = v.findViewById(R.id.tView);
            tView.setText(imgText[position]);
        } else{
             v =(View) convertView;
//             convertView = v;
        }

        return v;
    }
}
