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
import com.android.veggitech.growapp.adapter.PlantAdapter;
import com.android.veggitech.growapp.model.PlantItemModel;
import com.android.veggitech.growapp.model.TipModel;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class PlantActivity extends AppCompatActivity {

    int[] images = {R.drawable.cucumber, R.drawable.brinjal, R.drawable.tomato, R.drawable.kale, R.drawable.corn, R.drawable.carrot, R.drawable.zucchini, R.drawable.bellpepper, R.drawable.beetroot, R.drawable.radish, R.drawable.water, R.drawable.okra};
    String[] plantName = {"Cucumber", "Egg Plant", "Tomato", "Kale", "Sweet Corn", "Carrot", "Zucchini", "Capsicum", "Beetroot", "Radish", "Water Melon", "Okra"};
    String[] numberOfPlants = {"4 Per Sqm", "4 Per Sqm", "3 Per Sqm", "8 Per Sqm", "16 Per Sqm", "30 Per Sqm", "3 Per Sqm", "3 Per Sqm", "20 Per Sqm", "30 Per Sqm", "4 Per Sqm", "9 Per Sqm"};
    String[] plantDays = {"65 Days", "90 Days", "75 Days", "80 Days", "80 Days", "70 Days", "100 Days", "90 Days", "130 Days", "30 Days", "85 Days", "100 Days"};
    ListView listViewPlant;
    PlantAdapter plantAdapter;
    ArrayList<String> names;
    String string;
    private String urlString = "https://growspace.000webhostapp.com/plant";
    private RequestQueue requestQueue;
    private JsonArrayRequest jsonArrayRequest;
    JSONObject jsonObject;
    String pName, pNumber, pDays, pImage;
    ArrayList<PlantItemModel> dataModelArrayList = new ArrayList<PlantItemModel>();
    PlantItemModel plantItemModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       // DbHandlerPlants db = new DbHandlerPlants(this);
       /* ArrayList<HashMap<String, String>> plantList = db.GetPlantList();
        for (int i=0;i<plantList.size();i++)
        {
            HashMap<String, String> hashmap= plantList.get(i);
            string= hashmap.get("Your_Key_Name");
        }
  //
            Toast.makeText(this, "Data" +string, Toast.LENGTH_SHORT).show();*/
      /*  Cursor cursor = db.viewData();

        if (cursor.moveToFirst()){
            do{
                String data = cursor.getString(cursor.getColumnIndex("data"));
                // do what ever you want here
            }while(cursor.moveToNext());
        }
        cursor.close();*/


        listViewPlant = (ListView) findViewById(R.id.listViewPlant);
        retrieveJSON();
       // plantAdapter  = new PlantAdapter(PlantActivity.this, plantList, R.layout.plant_item,new String[]{"name","plantsqm","harvest"}, new int[]{R.id.textViewPlantName, R.id.textViewPlantNumber, R.id.textViewDays});
        //plantAdapter = new PlantAdapter(PlantActivity.this, plantName, numberOfPlants, plantDays, images);
        //listViewPlant.setAdapter(plantAdapter);
        listViewPlant.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent plantIntent;
                switch (position){
                    case 0:
                        plantIntent = new Intent(PlantActivity.this, CucumberPlantDetailsActivity.class);
                        plantIntent.putExtra("Position", position);
                        startActivity(plantIntent);
                        break;
                    case 1:
                        //plantIntent = new Intent(PlantActivity.this, BrinjalPlantDetailsActivity.class);
                        //plantIntent.putExtra("Position", position);
                        //startActivity(plantIntent);
                        Toast.makeText(PlantActivity.this, "Launch Soon", Toast.LENGTH_LONG).show();
                        break;
                    case 2:
                        Toast.makeText(PlantActivity.this, "Launch Soon", Toast.LENGTH_LONG).show();
                        break;
                    case 3:
                        Toast.makeText(PlantActivity.this, "Launch Soon", Toast.LENGTH_LONG).show();
                        break;
                    case 4:
                        Toast.makeText(PlantActivity.this, "Launch Soon", Toast.LENGTH_LONG).show();
                        break;
                    case 5:
                        Toast.makeText(PlantActivity.this, "Launch Soon", Toast.LENGTH_LONG).show();
                        break;
                    case 6:
                        Toast.makeText(PlantActivity.this, "Launch Soon", Toast.LENGTH_LONG).show();
                        break;
                    case 7:
                        Toast.makeText(PlantActivity.this, "Launch Soon", Toast.LENGTH_LONG).show();
                        break;
                    case 8:
                        Toast.makeText(PlantActivity.this, "Launch Soon", Toast.LENGTH_LONG).show();
                        break;
                    case 9:
                        Toast.makeText(PlantActivity.this, "Launch Soon", Toast.LENGTH_LONG).show();
                        break;
                    case 10:
                        Toast.makeText(PlantActivity.this, "Launch Soon", Toast.LENGTH_LONG).show();
                        break;
                    case 11:
                        Toast.makeText(PlantActivity.this, "Launch Soon", Toast.LENGTH_LONG).show();
                        break;

                }
            }
        });
    }

    private void retrieveJSON() {
        requestQueue = Volley.newRequestQueue(getApplicationContext());
        jsonArrayRequest = new JsonArrayRequest(urlString, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                jsonObject = null;
                for(int i=0;i<response.length(); i++){
                    try {
                        jsonObject = response.getJSONObject(i);
                        pName = jsonObject.getString("plant_name");
                        pDays = jsonObject.getString("harvest_period");
                        pNumber = jsonObject.getString("plants_sqm");
                        pImage = jsonObject.getString("plant_image");
                        //Toast.makeText(getActivity(), "Data" +name, Toast.LENGTH_LONG).show();
                        plantItemModel = new PlantItemModel();


                        plantItemModel.setPlantName(pName);
                        plantItemModel.setHarvestPeriod(pDays);
                        plantItemModel.setPlantSqm(pNumber);
                        plantItemModel.setImageUrl(pImage);

                        dataModelArrayList.add(plantItemModel);

                        setupListview();
                        //mProgressDialog.dismiss();
                        //Toast.makeText(getActivity(), "Data" +tipModel.toString() , Toast.LENGTH_LONG).show();

                    }
                    catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue.add(jsonArrayRequest);
    }

    private void setupListview() {
        plantAdapter = new PlantAdapter(getApplicationContext(), dataModelArrayList);
        listViewPlant.setAdapter(plantAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }
}
