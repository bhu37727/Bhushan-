package com.android.veggitech.growapp.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.android.veggitech.growapp.R;

public class GalleryImageAdapter extends BaseAdapter {

    private Context mContext;

    public GalleryImageAdapter(Context c)
    {
        mContext = c;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return images[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(images[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(426, 426));

        return imageView;
    }

    public Integer[] images = {
            R.drawable.rhubarb, R.drawable.basil,
            R.drawable.beetroot, R.drawable.radish,
            R.drawable.brinjal, R.drawable.tomato,
            R.drawable.zucchini};
}
