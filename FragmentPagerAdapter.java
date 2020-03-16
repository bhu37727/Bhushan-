package com.android.veggitech.growapp.adapter;

import androidx.fragment.app.Fragment;

import android.content.Context;
import androidx.fragment.app.FragmentManager;

import com.android.veggitech.growapp.fragment.GalleryFragment;
import com.android.veggitech.growapp.fragment.HomeFragment;
import com.android.veggitech.growapp.R;
import com.android.veggitech.growapp.fragment.TipFragment;

public class FragmentPagerAdapter extends androidx.fragment.app.FragmentPagerAdapter {

    private Context mContext;

    public FragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new HomeFragment();
        } else if (position == 1){
            return new TipFragment();
        } else {
            return new GalleryFragment();
        }
    }

    @Override
    public int getCount() {

        return 3;
    }

    // This determines the title for each tab
    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        switch (position) {
            case 0:
                return mContext.getString(R.string.plants);
            case 1:
                return mContext.getString(R.string.tips);
            case 2:
                return mContext.getString(R.string.gallery);
            default:
                return null;
        }
    }
}
