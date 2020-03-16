package com.android.veggitech.growapp.adapter;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class BrinjalFragmentPagerAdapter extends androidx.fragment.app.FragmentPagerAdapter {

    private Context mContext;

    public BrinjalFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
