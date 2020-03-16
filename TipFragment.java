package com.android.veggitech.growapp.fragment;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
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
import com.android.veggitech.growapp.database.DbHandler;
import com.android.veggitech.growapp.model.TipModel;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class TipFragment extends Fragment {

    private ListView listViewTip;
    private ListViewAdapter tipAdapter;
    Bundle bundle;
    LayoutInflater layoutInflater;
    ImageView call, email, chat;
    Context context;
    FragmentTransaction transaction;
    Intent  tipIntent;
    //private String urlString = "https://growspace.000webhostapp.com/planttip.json";
    private static ProgressDialog mProgressDialog;
    ArrayList<TipModel> dataModelArrayList = new ArrayList<TipModel>();
    private String urlString = "https://Veggitech.com/GrowApp/planttip.json";
    private RequestQueue requestQueue;
    private JsonArrayRequest jsonArrayRequest;
    JSONObject jsonObject;
    String name, description, image ;
    TipModel tipModel;


    public TipFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tip, container, false);

        listViewTip = view.findViewById(R.id.listViewTip);
        retrieveJSON();
       // tipAdapter = new ListViewAdapter(this.getContext(),tipTitle, tipDescription);
        layoutInflater = getLayoutInflater();
        View footer = (View) layoutInflater.inflate(R.layout.listview_footer, listViewTip, false);
        listViewTip.addFooterView(footer);
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
        //View v = inflater.inflate(R.layout.listview_footer, container, false);

        chat = footer.findViewById(R.id.imageViewChat);
        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String smsNumber = "971589130116"; //without '+'
                try {
                    Intent chatIntent = new Intent("android.intent.action.MAIN");
                    //chatIntent.setComponent(new ComponentName("com.whatsapp", "com.whatsapp.Conversation"));
                    chatIntent.setAction(Intent.ACTION_SEND);
                    chatIntent.setType("text/plain");
                    chatIntent.putExtra(Intent.EXTRA_TEXT, "Hi");
                    chatIntent.putExtra("jid", smsNumber + "@s.whatsapp.net"); //phone number without "+" prefix
                    chatIntent.setPackage("com.whatsapp");
                    startActivity(chatIntent);
                } catch(Exception e) {
                    Toast.makeText(getActivity(), "Error/n" + e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        email = footer.findViewById(R.id.imageViewEmail);
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                String[] recipients = {"shabnatvtv@gmail.com"};
                emailIntent.putExtra(Intent.EXTRA_EMAIL, recipients);
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "ABC");
                emailIntent.putExtra(Intent.EXTRA_CC, "it_projects@veggitech.com");
                emailIntent.setType("message/rfc822");
                startActivity(Intent.createChooser(emailIntent, "Send mail"));
            }
        });

        call = footer.findViewById(R.id.imageViewPhone);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
                phoneIntent.setData(Uri.parse("tel:971581924604"));
                startActivity(phoneIntent);
            }
        });
        return  view;
    }

    private void retrieveJSON() {
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
                        //Toast.makeText(getActivity(), "Data" +description, Toast.LENGTH_LONG).show();*/
                        tipModel = new TipModel();


                        tipModel.setTitle(name);
                        tipModel.setDescription(description);
                        tipModel.setImageUrl(image);

                        dataModelArrayList.add(tipModel);

                        setupListview();
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
        tipAdapter = new ListViewAdapter(getActivity(), dataModelArrayList);
        listViewTip.setAdapter(tipAdapter);
    }

}

