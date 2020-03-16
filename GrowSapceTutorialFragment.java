package com.android.veggitech.growapp.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.veggitech.growapp.R;
import com.android.veggitech.growapp.activity.TipDetailsActivity;
import com.android.veggitech.growapp.adapter.ListViewAdapter;
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

/**
 * A simple {@link Fragment} subclass.
 */
public class GrowSapceTutorialFragment extends Fragment {

    private ListView listViewTip;
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

    public GrowSapceTutorialFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_grow_sapce_tutorial, container, false);

        listViewTip = view.findViewById(R.id.listViewGrowTutorial);
        // Execute DownloadJSON AsyncTask
        //downloadJSON = new DownloadJSON();
       // downloadJSON.execute();
        retrieveJSON();
        // tipAdapter = new ListViewAdapter(this.getContext(),tipTitle, tipDescription);
        layoutInflater = getLayoutInflater();
        //listViewTip.setAdapter(tipAdapter);
        listViewTip.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                for(int i=0; i<=position;i++){

                    name = dataModelArrayList.get(position).getTitle().toString();
                    description = dataModelArrayList.get(position).getDescription().toString();
                    image = dataModelArrayList.get(position).getImageUrl().toString();
                    tipIntent = new Intent(getActivity(), TipDetailsActivity.class);
                    tipIntent.putExtra("Title",name);
                    tipIntent.putExtra("Des", description);
                    tipIntent.putExtra("Image", image);
                    startActivity(tipIntent);
                }
            }
        });

        //listViewTip.setNestedScrollingEnabled(true);
        return view;
    }

    private void retrieveJSON() {
        //mProgressDialog.show();
        requestQueue = Volley.newRequestQueue(getActivity());
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
                        //Toast.makeText(getActivity(), "Data" +name, Toast.LENGTH_LONG).show();
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

    private class DownloadJSON extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog.show();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            //setupListview();
            mProgressDialog.dismiss();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            retrieveJSON();
            return null;
        }
    }
    private void setupListview(){
        //removeSimpleProgressDialog();  //will remove progress dialog
        tipAdapter = new ListViewAdapter(getActivity(), dataModelArrayList);
        listViewTip.setAdapter(tipAdapter);
    }

}
