package com.android.veggitech.growapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.android.veggitech.growapp.R;
import com.android.veggitech.growapp.adapter.PlantGrowthMonitorAdapter;
import com.android.veggitech.growapp.model.MonitorModel;

import java.util.ArrayList;

public class PlantGrowthMonitorActivity extends AppCompatActivity {

    private RecyclerView recyclerView ;

    private PlantGrowthMonitorAdapter adapter;
    private ArrayList<MonitorModel> list = new ArrayList<MonitorModel>();
    Context context;

    String Name[]={"Watering", "Nutrition", "Protection"};

    String Desp[]={"Water is essential for life. It is one of the most important requirements for plant growth. Water is the main component of plant cells, it keeps the plant turgid (stiff),and it transports nutrients throughout the plant",
            " Although plants are able to use a few nutrients from the air, most of the nutrients are present in the the growing medium . Minerals such as nitrogen, and magnesium are taken up through the plant's roots. ",
            "Prevent  disease and weed problems through optimized cropping system as a "};

    Integer image[]={R.drawable.img48,R.drawable.img50 ,R.drawable.img51};



    //Integer image2[]={R.drawable.img39,R.drawable.img44 ,R.drawable.img45};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_growth_monitor);

        recyclerView = findViewById(R.id.my_recycler_view);

        for(int i=0; i<Name.length; i++)
        {
            MonitorModel monitor= new MonitorModel();
            monitor.setTitle1(Name[i]);
            monitor.setTitle2 ( Desp[i] );
            monitor.setImg1(image[i] );
            list.add(monitor);
        };

        adapter = new PlantGrowthMonitorAdapter(this, list );
        final LinearLayoutManager layoutManager=new LinearLayoutManager (this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
