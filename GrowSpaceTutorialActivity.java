package com.android.veggitech.growapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.veggitech.growapp.R;
import com.android.veggitech.growapp.adapter.GrowFragmentPagerAdapter;
import com.android.veggitech.growapp.fragment.GrowSapceTutorialFragment;
import com.android.veggitech.growapp.fragment.GrowSpaceVideoFragment;
import com.android.veggitech.growapp.fragment.SetupGrowSpaceFragment;
import com.android.veggitech.growapp.fragment.TipDetailsFragment;
import com.google.android.material.tabs.TabLayout;

public class GrowSpaceTutorialActivity extends AppCompatActivity {

    Fragment fragment = null;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    TextView textView;
    TabLayout tabLayout;
    ViewPager viewPager;
    GrowFragmentPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grow_space_tutorial);
        textView = findViewById(R.id.textViewSetUp);
        textView.setVisibility(View.INVISIBLE);
        tabLayout = findViewById(R.id.tabLayoutGrowTutorial);
        //viewPager = findViewById(R.id.view_pager_grow);

        fragment = new GrowSapceTutorialFragment();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
       // fragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.frame_container_grow_tutorial, fragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment fragment = null;
                switch (tab.getPosition()) {
                    case 0:
                        textView.setVisibility(View.INVISIBLE);
                        fragment = new GrowSapceTutorialFragment();
                        break;
                    case 1:
                        textView.setVisibility(View.VISIBLE);
                        fragment = new SetupGrowSpaceFragment();
                        break;
                    case 2:
                        textView.setVisibility(View.INVISIBLE);
                        fragment = new GrowSpaceVideoFragment();
                        break;
                }

                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.frame_container_grow_tutorial, fragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
       /* int tab_position=tabLayout.getSelectedTabPosition();
        if(tab_position ==1){
            textView.setVisibility(View.VISIBLE);
        }

       /* pagerAdapter = new GrowFragmentPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));*/
    }
}
