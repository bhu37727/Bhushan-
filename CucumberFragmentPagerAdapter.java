package com.android.veggitech.growapp.adapter;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.android.veggitech.growapp.R;
import com.android.veggitech.growapp.fragment.CucumberAboutPlantFragment;
import com.android.veggitech.growapp.fragment.CucumberAttackFragment;
import com.android.veggitech.growapp.fragment.CucumberSeedFragment;
import com.android.veggitech.growapp.fragment.CucumberVideoFragment;

public class CucumberFragmentPagerAdapter extends androidx.fragment.app.FragmentPagerAdapter {

    private Context mContext;

    public CucumberFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new CucumberAboutPlantFragment();
            case 1:
                return new CucumberSeedFragment();
            case 2:
                return  new CucumberAttackFragment();
            case 3:
                return  new CucumberVideoFragment();

                default:
                    return null;

        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return mContext.getString(R.string.about);
            case 1:
                return mContext.getString(R.string.seed);
            case 2:
                return mContext.getString(R.string.disease);
            case 3:
                return mContext.getString(R.string.video);
            default:
                return null;
        }
    }
}
