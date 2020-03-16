package com.android.veggitech.growapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.veggitech.growapp.R;
import com.android.veggitech.growapp.adapter.FvtPlantAdapter;
import com.android.veggitech.growapp.adapter.PlantAdapter;

import java.util.ArrayList;

public class FavouritePlantActivity extends AppCompatActivity {

    int[] images = {R.drawable.cucumber, R.drawable.brinjal, R.drawable.tomato, R.drawable.kale, R.drawable.corn, R.drawable.carrot, R.drawable.zucchini, R.drawable.bellpepper, R.drawable.beetroot, R.drawable.radish, R.drawable.water, R.drawable.okra};
    String[] plantName = {"Cucumber", "Egg Plant", "Tomato", "Kale", "Sweet Corn", "Carrot", "Zucchini", "Capsicum", "Beetroot", "Radish", "Water Melon", "Okra"};
    String[] numberOfPlants = {"4 Per Sqm", "4 Per Sqm", "3 Per Sqm", "8 Per Sqm", "16 Per Sqm", "30 Per Sqm", "3 Per Sqm", "3 Per Sqm", "20 Per Sqm", "30 Per Sqm", "4 Per Sqm", "9 Per Sqm"};
    String[] plantDays = {"65 Days", "90 Days", "75 Days", "80 Days", "80 Days", "70 Days", "100 Days", "90 Days", "130 Days", "30 Days", "85 Days", "100 Days"};
    ListView listViewPlant;
    FvtPlantAdapter plantAdapter;
    ArrayList<String> names;
    String string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite_plant);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listViewPlant = (ListView) findViewById(R.id.listViewFvtPlant);
        // plantAdapter  = new PlantAdapter(PlantActivity.this, plantList, R.layout.plant_item,new String[]{"name","plantsqm","harvest"}, new int[]{R.id.textViewPlantName, R.id.textViewPlantNumber, R.id.textViewDays});
        plantAdapter = new FvtPlantAdapter(FavouritePlantActivity.this, plantName, numberOfPlants, plantDays, images);
        listViewPlant.setAdapter(plantAdapter);
        listViewPlant.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent plantIntent;
                switch (position){
                    case 0:
                        plantIntent = new Intent(FavouritePlantActivity.this, CucumberPlantDetailsActivity.class);
                        plantIntent.putExtra("Position", position);
                        startActivity(plantIntent);
                        break;
                    case 1:
                        plantIntent = new Intent(FavouritePlantActivity.this, BrinjalPlantDetailsActivity.class);
                        plantIntent.putExtra("Position", position);
                        startActivity(plantIntent);
                        break;
                    case 2:
                        Toast.makeText(FavouritePlantActivity.this, "Launch Soon", Toast.LENGTH_LONG).show();
                        break;
                    case 3:
                        Toast.makeText(FavouritePlantActivity.this, "Launch Soon", Toast.LENGTH_LONG).show();
                        break;
                    case 4:
                        Toast.makeText(FavouritePlantActivity.this, "Launch Soon", Toast.LENGTH_LONG).show();
                        break;
                    case 5:
                        Toast.makeText(FavouritePlantActivity.this, "Launch Soon", Toast.LENGTH_LONG).show();
                        break;
                    case 6:
                        Toast.makeText(FavouritePlantActivity.this, "Launch Soon", Toast.LENGTH_LONG).show();
                        break;
                    case 7:
                        Toast.makeText(FavouritePlantActivity.this, "Launch Soon", Toast.LENGTH_LONG).show();
                        break;
                    case 8:
                        Toast.makeText(FavouritePlantActivity.this, "Launch Soon", Toast.LENGTH_LONG).show();
                        break;
                    case 9:
                        Toast.makeText(FavouritePlantActivity.this, "Launch Soon", Toast.LENGTH_LONG).show();
                        break;
                    case 10:
                        Toast.makeText(FavouritePlantActivity.this, "Launch Soon", Toast.LENGTH_LONG).show();
                        break;
                    case 11:
                        Toast.makeText(FavouritePlantActivity.this, "Launch Soon", Toast.LENGTH_LONG).show();
                        break;

                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }
}
