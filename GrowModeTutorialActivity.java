package com.android.veggitech.growapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.android.veggitech.growapp.R;
import com.android.veggitech.growapp.adapter.ListViewAdapter;
import com.android.veggitech.growapp.fragment.GrowSapceTutorialFragment;
import com.android.veggitech.growapp.javaclass.DownloadJSON;
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

public class GrowModeTutorialActivity extends AppCompatActivity {

    ListView listView;
    private ListViewAdapter tipAdapter;
    Bundle bundle;
    LayoutInflater layoutInflater;
    ImageView call, email, chat;
    Context context;
    FragmentTransaction transaction;
    Intent tipIntent;
    //private String urlString = "https://growspace.000webhostapp.com/planttip.json";
    private static ProgressDialog mProgressDialog;
    ArrayList<TipModel> dataModelArrayList = new ArrayList<TipModel>();
    private String urlString = "https://Veggitech.com/GrowApp/planttip.json";
    private RequestQueue requestQueue;
    private JsonArrayRequest jsonArrayRequest;
    JSONObject jsonObject;
    String name, description, image ;
    TipModel tipModel;
    DownloadJSON downloadJSON;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grow_mode_tutorial);
        listView = findViewById(R.id.listViewGrowModeTutorial);
        retrieveJSON();

        layoutInflater = getLayoutInflater();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                for(int i=0; i<=position;i++){

                    name = dataModelArrayList.get(position).getTitle().toString();
                    description = dataModelArrayList.get(position).getDescription().toString();
                    image = dataModelArrayList.get(position).getImageUrl().toString();
                    tipIntent = new Intent(getApplicationContext(), TipDetailsActivity.class);
                    tipIntent.putExtra("Title",name);
                    tipIntent.putExtra("Des", description);
                    tipIntent.putExtra("Image", image);
                    startActivity(tipIntent);
                }
            }
        });
    }

    private void retrieveJSON() {
        //mProgressDialog.show();
        requestQueue = Volley.newRequestQueue(getApplicationContext());
        jsonArrayRequest = new JsonArrayRequest(urlString, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                jsonObject = null;
                for(int i=0;i<response.length(); i++){
                    try {
                        jsonObject = response.getJSONObject(i);
                        name = jsonObject.getString("tip_title");
                        description = jsonObject.getString("tip_description");
                        image = jsonObject.getString("tip_image");
                        //Toast.makeText(getActivity(), "Data" +description, Toast.LENGTH_LONG).show();*/
                        tipModel = new TipModel();


                        tipModel.setTitle(name);
                        tipModel.setDescription(description);
                        tipModel.setImageUrl(image);

                        dataModelArrayList.add(tipModel);

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

    private void setupListview(){
        //removeSimpleProgressDialog();  //will remove progress dialog
        tipAdapter = new ListViewAdapter(getApplicationContext(), dataModelArrayList);
        listView.setAdapter(tipAdapter);
    }
}
