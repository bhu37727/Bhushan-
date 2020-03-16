package com.android.veggitech.growapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.android.veggitech.growapp.model.MyPlantModel;

import java.util.ArrayList;

public class DbHandler extends SQLiteOpenHelper{

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "Grow App";

    private static final String TABLE_USER = "User";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PHONE = "phone";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";

    private static final String TABLE_GROW_SPACE = "GrowSpace";
    private static final String KEY_GROW_ID = "id";
    private static final String KEY_LOCATION = "location";
    private static final String KEY_LENGTH = "length";
    private static final String KEY_WIDTH = "width";

    public static final String TABLE_MY_PLANT = "MyPlant";
    private static final String KEY_PLANT_ID = "id";
    private static final String KEY_PLANT_NAME = "plant_name";
    private static final String KEY_PLANT_DAYS = "plant_days";
    private static final String KEY_START_DATE = "start_date";
    private static final String KEY_END_DATE = "end_date";
    private static final String TAG = "";


    public DbHandler(Context context){
        super(context,DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TABLE = "CREATE TABLE " + TABLE_USER + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_NAME + " TEXT,"
                + KEY_EMAIL + " TEXT,"
                + KEY_PHONE + " INTEGER,"
                + KEY_USERNAME + " TEXT,"
                + KEY_PASSWORD + " TEXT"+ ")";
        db.execSQL(CREATE_TABLE);

        String CREATE_TABLE_GROW_SPACE = "CREATE TABLE " + TABLE_GROW_SPACE + "("
                + KEY_GROW_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_LOCATION + " TEXT,"
                + KEY_LENGTH + " DOUBLE,"
                + KEY_WIDTH + " DOUBLE" +")";
        db.execSQL(CREATE_TABLE_GROW_SPACE);

        String CREATE_TABLE_MY_PLANT = "CREATE TABLE " + TABLE_MY_PLANT + "("
                + KEY_PLANT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_PLANT_NAME + " TEXT,"
                + KEY_PLANT_DAYS + " INTEGER,"
                + KEY_START_DATE + " TEXT,"
                + KEY_END_DATE + " TEXT" +")";
        Log.e(TAG, "onCreate Database");
        db.execSQL(CREATE_TABLE_MY_PLANT);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // Drop older table if exist
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        // Create tables again
        onCreate(db);

        // Drop older table if exist
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GROW_SPACE);
        // Create tables again
        onCreate(db);

        // Drop older table if exist
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MY_PLANT);
        // Create tables again
        onCreate(db);

    }

    // **** CRUD (Create, Read, Update, Delete) Operations ***** //

    // Adding new User Details
    public void insertUserDetails(String name, String email, int phone, String username, String password){
        //Get the Data Repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();
        //Create a new map of values, where column names are the keys
        ContentValues cValues = new ContentValues();
        cValues.put(KEY_NAME, name);
        cValues.put(KEY_EMAIL, email);
        cValues.put(KEY_PHONE, phone);
        cValues.put(KEY_USERNAME, username);
        cValues.put(KEY_PASSWORD, password);
        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(TABLE_USER,null, cValues);
        db.close();
    }

    //check for user
    public boolean checkUserExist(String username, String password){
        String[] columns = {"username"};
        SQLiteDatabase db = this.getWritableDatabase();

        String selection = "username=? and password = ?";
        String[] selectionArgs = {username, password};

        Cursor cursor = db.query(TABLE_USER, columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();

        cursor.close();
        close();

        if(count > 0){
            return true;
        } else {
            return false;
        }
    }

    // Adding new GrowSpace Details
    public void insertGrowSpaceDetails(String location, Double length, Double width){
        //Get the Data Repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();
        //Create a new map of values, where column names are the keys
        ContentValues cValues = new ContentValues();
        cValues.put(KEY_LOCATION, location);
        cValues.put(KEY_LENGTH, length);
        cValues.put(KEY_WIDTH, width);

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(TABLE_GROW_SPACE,null, cValues);
        db.close();
    }


    // Adding new MyPlant Details
    public void insertMyPlantDetails(String plantName, int plantDays, String start, String end){
        //Get the Data Repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();
        //Create a new map of values, where column names are the keys
        ContentValues cValues = new ContentValues();
        cValues.put(KEY_PLANT_NAME, plantName);
        cValues.put(KEY_PLANT_DAYS, plantDays);
        cValues.put(KEY_START_DATE, start);
        cValues.put(KEY_END_DATE, end);

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(TABLE_GROW_SPACE,null, cValues);
        db.close();
    }

    public void getPlantData(){

        //Get the Data Repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();
        /*retrieve data from database */
        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_MY_PLANT, null);

        int Column1 = c.getColumnIndex("plant_name");
        int Column2 = c.getColumnIndex("plant_days");
        int Column3 = c.getColumnIndex("start_date");
        int Column4 = c.getColumnIndex("end_date");

        // Check if our result was valid.
        c.moveToFirst();
        String sData="";
        if (c != null) {
            // Loop through all Results
            do {
                String Name = c.getString(Column1);
                String Days = c.getString(Column2);
                String StartDate = c.getString(Column3);
                String EndDate = c.getString(Column4);
               // sData = sData + Name + " " + Script + " " + su + "\n";
            } while (c.moveToNext());
        }
    }

    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_MY_PLANT;
        Cursor data = db.rawQuery(query, null);
        return data;
    }


    // Get User Details
    public ArrayList<MyPlantModel> GetMyPlants(){
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<MyPlantModel> plantList = new ArrayList<MyPlantModel>();
        String query = "SELECT * FROM "+ TABLE_MY_PLANT;
        Cursor cursor = db.rawQuery(query,null);
        while (cursor.moveToNext()){
            MyPlantModel plant = new MyPlantModel();
            plant.setPlantName(cursor.getString(cursor.getColumnIndex(KEY_PLANT_NAME)));
            plant.setPlantDays(cursor.getInt(cursor.getColumnIndex(KEY_PLANT_DAYS)));
            plant.setStartDate(cursor.getString(cursor.getColumnIndex(KEY_START_DATE)));
            plant.setEndDate(cursor.getString(cursor.getColumnIndex(KEY_END_DATE)));
            plantList.add(plant);
        }
        return plantList;
    }
}
