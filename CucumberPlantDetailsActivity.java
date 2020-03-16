package com.android.veggitech.growapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.android.veggitech.growapp.R;
import com.android.veggitech.growapp.adapter.CucumberFragmentPagerAdapter;
import com.android.veggitech.growapp.database.DbHandler;
import com.android.veggitech.growapp.fragment.CucumberAboutPlantFragment;
import com.android.veggitech.growapp.fragment.CucumberAttackFragment;
import com.android.veggitech.growapp.fragment.CucumberSeedFragment;
import com.android.veggitech.growapp.fragment.CucumberVideoFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CucumberPlantDetailsActivity extends AppCompatActivity {

    FrameLayout frameLayout;
    TabLayout tabLayoutPlant;
    Fragment fragment;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    FloatingActionButton floatingButton;
    ViewPager viewPagerTab;
    CucumberFragmentPagerAdapter cucumberFragmentPagerAdapter;
    Intent intent;
    String plantName = "Cucumber";
    String plantDays = "70";
    private Calendar calendar;
    private SimpleDateFormat dateFormat;
    private String startDate, endDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cucumber_activity_plant_details);
        //getSupportActionBar().hide();

        frameLayout = findViewById(R.id.frame_container);
        //tabLayoutPlant = findViewById(R.id.tabLayoutPlant);
        /*viewPagerTab = findViewById(R.id.viewPagerTabCucumber);
        cucumberFragmentPagerAdapter = new CucumberFragmentPagerAdapter(getApplicationContext(), getSupportFragmentManager());
        viewPagerTab.setAdapter(cucumberFragmentPagerAdapter);
        tabLayoutPlant.setupWithViewPager(viewPagerTab);*/
        //startDate = Calendar.getInstance().getTime();
        calendar = Calendar.getInstance();
        dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        startDate = dateFormat.format(calendar.getTime());
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(dateFormat.parse(startDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.add(Calendar.DATE, 40);  // number of days to add, can also use Calendar.DAY_OF_MONTH in place of Calendar.DATE
        //SimpleDateFormat sdf1 = new SimpleDateFormat("MM-dd-yyyy");
        endDate = dateFormat.format(c.getTime());
        floatingButton = findViewById(R.id.fab);
        floatingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //DbHandler dbHandler = new DbHandler(getApplicationContext());
               // dbHandler.insertMyPlantDetails(plantName,plantDays,startDate,endDate);
                Toast.makeText(getApplicationContext(), "Cucumber Planted...",Toast.LENGTH_SHORT).show();
                intent = new Intent(getApplicationContext(), MyGrowSpaceActivity.class);
                intent.putExtra("name", plantName);
                intent.putExtra("days", plantDays);
                intent.putExtra("start", startDate);
                intent.putExtra("end", endDate);
                startActivity(intent);
            }
        });

       /* viewPagerTab = findViewById(R.id.viewPagerTab);
        fragmentPagerAdapter = new FragmentPagerAdapter(this, getSupportFragmentManager());
        viewPagerTab.setAdapter(fragmentPagerAdapter);
        tabLayoutHome.setupWithViewPager(viewPagerTab);*/

        fragment = new CucumberAboutPlantFragment();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_container, fragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();

        /*tabLayoutPlant.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment fragment = null;
                switch (tab.getPosition()) {
                    case 0:
                        fragment = new CucumberAboutPlantFragment();
                        break;
                    case 1:
                        fragment = new CucumberSeedFragment();
                        break;
                    case 2:
                        fragment = new CucumberAttackFragment();
                        break;
                    case 3:
                         fragment = new CucumberVideoFragment();
                        break;
                }
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.frame_container, fragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.commit();*/
            }


          /*  @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }*/
}