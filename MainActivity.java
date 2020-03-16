package com.android.veggitech.growapp.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.android.veggitech.growapp.R;
import com.android.veggitech.growapp.adapter.FragmentPagerAdapter;
import com.android.veggitech.growapp.fragment.BlankFragment;
import com.android.veggitech.growapp.model.ItemModel;
import com.android.veggitech.growapp.fragment.GalleryFragment;
import com.android.veggitech.growapp.fragment.HomeFragment;
import com.android.veggitech.growapp.fragment.TipFragment;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.mindorks.placeholderview.PlaceHolderView;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Timer;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity implements HomeFragment.OnFragmentInteractionListener{

    TabLayout tabLayoutHome;
    FrameLayout frameLayout;
    Fragment fragment = null;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    FragmentPagerAdapter fragmentPagerAdapter;
    RelativeLayout relativeLayout;
    ArrayList<ItemModel> arrayList;
    RecyclerView recyclerView;
    ViewPager viewPagerTab;
    CircleIndicator circleIndicator;
    private PlaceHolderView mDrawerView;
    private DrawerLayout mDrawer;
    private Toolbar mToolbar;
    private PlaceHolderView mGalleryView;
    int icons[] = {R.drawable.basil, R.drawable.tomato, R.drawable.brinjal, R.drawable.rosemary, R.drawable.beetroot, R.drawable.nusturtium, R.drawable.radish, R.drawable.zucchini, R.drawable.rhubarb};
    String iconsName[] = {"Basil", "Tomato", "Egg Plant", "Rosemary", "Beetroot", "Nusturtium", "Radish", "Zucchini", "Swiss Chard"};
    private Timer timer;
    private int currentPosition = 0;
    private DrawerLayout  drawer;
    private ActionBarDrawerToggle toggle;
    private Toolbar toolbar;
    private NavigationView navigationView;
    View headerLayout;
    Intent navigationIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = setupDrawerToggle();
        // Setup toggle to display hamburger icon with nice animation
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();
        // Tie DrawerLayout events to the ActionBarToggle
        drawer.addDrawerListener(toggle);


        // Find our drawer view
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener(){

                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        switch (menuItem.getItemId()){
                            case R.id.home:
                                navigationIntent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(navigationIntent);
                                break;

                            case R.id.plants:
                                navigationIntent = new Intent(getApplicationContext(), PlantActivity.class);
                                startActivity(navigationIntent);
                                break;
                            case R.id.grow_space:
                                navigationIntent = new Intent(getApplicationContext(), MyGrowSpaceActivity.class);
                                startActivity(navigationIntent);
                                break;
                            case R.id.favourite:
                                navigationIntent = new Intent(getApplicationContext(), FavouritePlantActivity.class);
                                startActivity(navigationIntent);
                                break;
                        }
                        return true;
                    }
                });

        relativeLayout = findViewById(R.id.relativeLayout);
        tabLayoutHome = findViewById(R.id.tabLayoutHome);
       /* viewPagerTab = findViewById(R.id.viewPagerTab);
        fragmentPagerAdapter = new FragmentPagerAdapter(this, getSupportFragmentManager());
        viewPagerTab.setAdapter(fragmentPagerAdapter);
        tabLayoutHome.setupWithViewPager(viewPagerTab);*/

        fragment = new HomeFragment();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.relativeLayout, fragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();

        tabLayoutHome.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment fragment = null;
                switch (tab.getPosition()) {
                    case 0:
                        fragment = new HomeFragment();
                        break;
                    case 1:
                        fragment = new TipFragment();
                        break;
                    case 2:
                        fragment = new GalleryFragment();
                        break;
                    case 3:
                        // fragment = new PhpFragment();
                        break;
                }
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.relativeLayout, fragment);
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

    }

    private ActionBarDrawerToggle setupDrawerToggle() {
        // NOTE: Make sure you pass in a valid toolbar reference.  ActionBarDrawToggle() does not require it
        // and will not render the hamburger icon without it.
        return new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open,  R.string.navigation_drawer_close);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // The action bar home/up action should open or close the drawer.
       /* switch (item.getItemId()) {
            case R.id.home:
                fragment = new HomeFragment();
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.relativeLayout, fragment);
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                fragmentTransaction.commit();
                break;
                //return true;
        }*/

       // return super.onOptionsItemSelected(item);
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        toggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        toggle.onConfigurationChanged(newConfig);
    }


}


