package com.android.veggitech.growapp.javaclass;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.ListView;

import com.android.veggitech.growapp.adapter.ListViewAdapter;
import com.android.veggitech.growapp.fragment.TipFragment;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class DownloadJSON extends AsyncTask<Void, Void, Void> {

    JSONObject jsonobject;
    JSONArray jsonarray;
    ListView listview;
    ListViewAdapter adapter;
    ProgressDialog mProgressDialog;
    ArrayList<HashMap<String, String>> arraylist;
    static String RANK = "rank";
    static String COUNTRY = "country";
    static String POPULATION = "population";
    static String FLAG = "flag";
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        return null;
    }
}
