package com.android.veggitech.growapp.fragment;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.veggitech.growapp.R;
import com.android.veggitech.growapp.activity.MyPlantDetailsActivity;
import com.android.veggitech.growapp.adapter.MyPlantAdapter;
import com.android.veggitech.growapp.database.DbHandler;
import com.android.veggitech.growapp.model.MyPlantModel;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyPlantFragment extends Fragment {

    int[] images = {R.drawable.cucumber};
   // String[] plantName = {"Cucumber"};
    //int[] plantDays = {70};
    String plantName;
    String plantDays, startDate, endDate;
    ListView listViewMyPlant;
    MyPlantAdapter plantAdapter;
    TextView textView;
    Intent detailsIntent;
    Bundle bundle;
    private DbHandler handler;
    private SQLiteDatabase dataBase;
    ArrayList<MyPlantModel> arrayList = new ArrayList<MyPlantModel>();

    public MyPlantFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_plant, container, false);
        textView = view.findViewById(R.id.textViewText);
        //getPlantData();
        //textView.setVisibility(View.INVISIBLE);
        listViewMyPlant = view.findViewById(R.id.listViewMyPlant);
        //getPlantData();
        //listViewMyPlant.setVisibility(View.INVISIBLE);
        bundle = getArguments();
        plantName = bundle.getString("name");
        if(plantName == null){
            listViewMyPlant.setVisibility(View.INVISIBLE);
        }else{
            listViewMyPlant.setVisibility(View.VISIBLE);
            textView.setVisibility(View.INVISIBLE);
        }
        plantDays = bundle.getString("days");
        startDate = bundle.getString("start");
        endDate = bundle.getString("end");

        //Toast.makeText(getActivity(), "Plant Name is"  +plantName +plantDays +startDate +endDate, Toast.LENGTH_LONG).show();

        plantAdapter = new MyPlantAdapter(getActivity(), plantName, plantDays, startDate, endDate, images);
        listViewMyPlant.setAdapter(plantAdapter);

        listViewMyPlant.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position){
                    case 0:
                       detailsIntent = new Intent(getActivity(), MyPlantDetailsActivity.class);
                       detailsIntent.putExtra("start",startDate);
                       detailsIntent.putExtra("end", endDate);
                       startActivity(detailsIntent);
                }
            }
        });
        return view;

    }

    private void getPlantData() {

        DbHandler db = new DbHandler(getActivity());
        Cursor cursor = db.getData();
        if (cursor.moveToFirst()){
            do{
                String data = cursor.getString(0);
                Toast.makeText(getActivity(), "Plant Name is"  +data, Toast.LENGTH_LONG).show();
                // do what ever you want here
            }while(cursor.moveToNext());
        }
        cursor.close();
       // arrayList = db.GetMyPlants();



      /*  handler = new DbHandler(getActivity());
        dataBase = handler.getWritableDatabase();
        Cursor cursor = handler.getData();
        if(cursor.moveToFirst()){
            Toast.makeText(getActivity(), "Plant Name is", Toast.LENGTH_LONG).show();
        }*
        //the SQL command to fetched all records from the table
        /*Cursor mCursor = dataBase.rawQuery("SELECT * FROM "
                + DbHandler.TABLE_MY_PLANT, null);
        MyPlantModel myPlantModel = new MyPlantModel();
        //fetch each record
        if (mCursor.moveToFirst()) {
            do {
                //get data from field
                // stafid.add(mCursor.getString(mCursor.getColumnIndex(DbHandler.)));
                // nama.add(mCursor.getString(mCursor.getColumnIndex(DBHelper.NAMA)));
                // jbt.add(mCursor.getString(mCursor.getColumnIndex(DBHelper.JBT)));
                plantName = mCursor.getString(0);
                Toast.makeText(getActivity(), "Plant Name is" +plantName, Toast.LENGTH_LONG).show();

            } while (mCursor.moveToNext());
            //do above till data exhausted
        }*/
    }
}
