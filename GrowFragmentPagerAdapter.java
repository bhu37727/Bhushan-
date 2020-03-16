package com.android.veggitech.growapp.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.android.veggitech.growapp.fragment.GrowSapceTutorialFragment;
import com.android.veggitech.growapp.fragment.GrowSpaceVideoFragment;
import com.android.veggitech.growapp.fragment.SetupGrowSpaceFragment;

public class GrowFragmentPagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;
    public GrowFragmentPagerAdapter(FragmentManager fm, int mNumOfTabs) {
        super(fm);
        this.mNumOfTabs = mNumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                GrowSapceTutorialFragment fragment = new GrowSapceTutorialFragment();
                return fragment;
            case 1:
                SetupGrowSpaceFragment setupFragment = new SetupGrowSpaceFragment();
                return setupFragment;
            case 2:
                GrowSpaceVideoFragment videoFragment = new GrowSpaceVideoFragment();
                return  videoFragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
