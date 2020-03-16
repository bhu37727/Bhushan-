package com.android.veggitech.growapp.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.database.Cursor;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.HashMap;

import androidx.annotation.Nullable;

public class DbHandlerPlants extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "Grow App";
    private static final String TABLE_PLANT = "Plant";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "plant_name";
    private static final String KEY_BOTANICAL_NAME = "botanical_name";
    private static final String KEY_VARIETY = "variety";
    private static final String KEY_IMAGE = "image";
    private static final String KEY_SOWDEPTH = "sow_depth";
    private static final String KEY_DISTANCE = "diatnce_plants";
    private static final String KEY_GROWMODE = "grow_mode";
    private static final String KEY_PLANTS_SQM = "plants_sqm";
    private static final String KEY_GERMINATION = "germination_period";
    private static final String KEY_LOCATION = "location";
    private static final String KEY_HEIGHT = "height";
    private static final String KEY_HARVEST = "harvest_period";
    private static final String KEY_MINTEMPERATURE = "min_temperature";
    private static final String KEY_MAXTEMPERATURE = "max_temperature";
    private static final String KEY_TRANSPLANT = "transplanting_time";
    private static final String KEY_PLANTING_TIME = "planting_time";
    private static final String KEY_WATER = "watering_period";
    private static final String KEY_FERTILISER = "fertilising_period";
    private static final String KEY_MINPH = "min_ph";
    private static final String KEY_MAXPH = "max_ph";

    public DbHandlerPlants(Context context){

        super(context,DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_PLANT + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_NAME + " TEXT,"
                + KEY_BOTANICAL_NAME + " TEXT,"
                + KEY_VARIETY + " TEXT,"
                + KEY_IMAGE + " BLOB,"
                + KEY_SOWDEPTH + " FLOAT,"
                + KEY_DISTANCE + " FLOAT,"
                + KEY_GROWMODE + " TEXT,"
                + KEY_PLANTS_SQM + " INTEGER,"
                + KEY_GERMINATION + " INTEGER,"
                + KEY_LOCATION + " TEXT,"
                + KEY_HEIGHT + " FLOAT,"
                + KEY_HARVEST + " INTEGER,"
                + KEY_MINTEMPERATURE + " FLOAT,"
                + KEY_MAXTEMPERATURE + " FLOAT,"
                + KEY_TRANSPLANT + " INTEGER,"
                + KEY_PLANTING_TIME + " TEXT,"
                + KEY_WATER + " INTEGER,"
                + KEY_FERTILISER + " INTEGER,"
                + KEY_MINPH + " FLOAT,"
                + KEY_MAXPH + " FLOAT"+ ")";
        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // Drop older table if exist
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PLANT);
        // Create tables again
        onCreate(db);
    }

    // Adding new Plant Details
    public boolean insertPlantDetails(String name, String botanicalName, String variety, byte[] image, float sowDepth, float distance, String growMode, int plantSqm, int germinationPeriod, String location, float height, int harvestPeriod, float mintemperature, float maxtemperature, int transplantingTime, String plantingTime, int wateringPeriod, int fertilisingPeriod, float minph, float maxph){
        //Get the Data Repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();
        //Create a new map of values, where column names are the keys
        ContentValues cValues = new ContentValues();
        cValues.put(KEY_NAME, name);
        cValues.put(KEY_BOTANICAL_NAME, botanicalName);
        cValues.put(KEY_VARIETY, variety);
        cValues.put(KEY_IMAGE, image);
        cValues.put(KEY_SOWDEPTH, sowDepth);
        cValues.put(KEY_DISTANCE, distance);
        cValues.put(KEY_GROWMODE, growMode);
        cValues.put(KEY_PLANTS_SQM, plantSqm);
        cValues.put(KEY_GERMINATION, germinationPeriod);
        cValues.put(KEY_LOCATION, location);
        cValues.put(KEY_HEIGHT, height);
        cValues.put(KEY_HARVEST, harvestPeriod);
        cValues.put(KEY_MINTEMPERATURE, mintemperature);
        cValues.put(KEY_MAXTEMPERATURE, maxtemperature);
        cValues.put(KEY_TRANSPLANT, transplantingTime);
        cValues.put(KEY_PLANTING_TIME, plantingTime);
        cValues.put(KEY_WATER, wateringPeriod);
        cValues.put(KEY_FERTILISER, fertilisingPeriod);
        cValues.put(KEY_MINPH, minph);
        cValues.put(KEY_MAXPH, maxph);
        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(TABLE_PLANT,null, cValues);
        if (newRowId == -1)
            return false;
        else
            return true;
        //db.close();
    }

    // Get Plant Details
    public ArrayList<HashMap<String, String>> GetPlants(){
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<HashMap<String, String>> plantList = new ArrayList<>();
        String query = "SELECT name, botanicalName, variety, image, sowDepth, distance, growMode, plantSqm, germinationPeriod, location, height, harvestPeriod, temperature, transplantingTime, plantingTime, wateringPeriod, fertilisingPeriod FROM "+ TABLE_PLANT;
        Cursor cursor = db.rawQuery(query,null);
        while (cursor.moveToNext()){
            HashMap<String,String> plant = new HashMap<>();
            plant.put("name",cursor.getString(cursor.getColumnIndex(KEY_NAME)));
            plant.put("botanicalName",cursor.getString(cursor.getColumnIndex(KEY_BOTANICAL_NAME)));
            plant.put("variety",cursor.getString(cursor.getColumnIndex(KEY_VARIETY)));
            plant.put("image",cursor.getString(cursor.getColumnIndex(KEY_IMAGE)));
            plant.put("sowDepth",cursor.getString(cursor.getColumnIndex(KEY_SOWDEPTH)));
            plant.put("distance",cursor.getString(cursor.getColumnIndex(KEY_DISTANCE)));
            plant.put("growMode",cursor.getString(cursor.getColumnIndex(KEY_GROWMODE)));
            plant.put("plantSqm",cursor.getString(cursor.getColumnIndex(KEY_PLANTS_SQM)));
            plant.put("germinationPeriod",cursor.getString(cursor.getColumnIndex(KEY_GERMINATION)));
            plant.put("location",cursor.getString(cursor.getColumnIndex(KEY_LOCATION)));
            plant.put("height",cursor.getString(cursor.getColumnIndex(KEY_HEIGHT)));
            plant.put("harvestPeriod",cursor.getString(cursor.getColumnIndex(KEY_HARVEST)));
            plant.put("temperature",cursor.getString(cursor.getColumnIndex(KEY_MINTEMPERATURE)));
            plant.put("transplantingTime",cursor.getString(cursor.getColumnIndex(KEY_TRANSPLANT)));
            plant.put("plantingTime",cursor.getString(cursor.getColumnIndex(KEY_PLANTING_TIME)));
            plant.put("wateringPeriod",cursor.getString(cursor.getColumnIndex(KEY_WATER)));
            plant.put("fertilisingPeriod",cursor.getString(cursor.getColumnIndex(KEY_FERTILISER)));
            plantList.add(plant);
        }
        return  plantList;
    }

    // Get Plant Details
    public ArrayList<HashMap<String, String>> GetPlantList(){
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<HashMap<String, String>> plantList = new ArrayList<>();
        String query = "SELECT plant_name FROM "+ TABLE_PLANT;
        Cursor cursor = db.rawQuery(query,null);
        while (cursor.moveToNext()){
            HashMap<String,String> plant = new HashMap<>();
            plant.put("name",cursor.getString(cursor.getColumnIndex(KEY_NAME)));
            plantList.add(plant);
        }
        return  plantList;
    }

    public Cursor viewData()
    {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor ;

        String query = "Select plant_name from " +TABLE_PLANT;
        cursor= sqLiteDatabase.rawQuery(query, null);


        return cursor;
    }
    // Get Plant Details based on plantid
    public ArrayList<HashMap<String, String>> GetPlantByPlantId(int plantid){
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<HashMap<String, String>> plantList = new ArrayList<>();
        String query = "SELECT name, botanicalName, variety, image, sowDepth, distance, growMode, plantSqm, germinationPeriod, location, height, harvestPeriod, temperature, transplantingTime, plantingTime, wateringPeriod, fertilisingPeriod FROM "+ TABLE_PLANT;
        Cursor cursor = db.query(TABLE_PLANT, new String[]{KEY_NAME, KEY_BOTANICAL_NAME, KEY_VARIETY, KEY_IMAGE, KEY_SOWDEPTH, KEY_DISTANCE, KEY_GROWMODE, KEY_PLANTS_SQM, KEY_GERMINATION, KEY_LOCATION, KEY_HEIGHT, KEY_HARVEST, KEY_MINTEMPERATURE, KEY_TRANSPLANT, KEY_PLANTING_TIME, KEY_WATER, KEY_FERTILISER}, KEY_ID+ "=?",new String[]{String.valueOf(plantid)},null, null, null, null);
        if (cursor.moveToNext()){
            HashMap<String,String> plant = new HashMap<>();
            plant.put("name",cursor.getString(cursor.getColumnIndex(KEY_NAME)));
            plant.put("botanicalName",cursor.getString(cursor.getColumnIndex(KEY_BOTANICAL_NAME)));
            plant.put("variety",cursor.getString(cursor.getColumnIndex(KEY_VARIETY)));
            plant.put("image",cursor.getString(cursor.getColumnIndex(KEY_IMAGE)));
            plant.put("sowDepth",cursor.getString(cursor.getColumnIndex(KEY_SOWDEPTH)));
            plant.put("distance",cursor.getString(cursor.getColumnIndex(KEY_DISTANCE)));
            plant.put("growMode",cursor.getString(cursor.getColumnIndex(KEY_GROWMODE)));
            plant.put("plantSqm",cursor.getString(cursor.getColumnIndex(KEY_PLANTS_SQM)));
            plant.put("germinationPeriod",cursor.getString(cursor.getColumnIndex(KEY_GERMINATION)));
            plant.put("location",cursor.getString(cursor.getColumnIndex(KEY_LOCATION)));
            plant.put("height",cursor.getString(cursor.getColumnIndex(KEY_HEIGHT)));
            plant.put("harvestPeriod",cursor.getString(cursor.getColumnIndex(KEY_HARVEST)));
            plant.put("temperature",cursor.getString(cursor.getColumnIndex(KEY_MINTEMPERATURE)));
            plant.put("transplantingTime",cursor.getString(cursor.getColumnIndex(KEY_TRANSPLANT)));
            plant.put("plantingTime",cursor.getString(cursor.getColumnIndex(KEY_PLANTING_TIME)));
            plant.put("wateringPeriod",cursor.getString(cursor.getColumnIndex(KEY_WATER)));
            plant.put("fertilisingPeriod",cursor.getString(cursor.getColumnIndex(KEY_FERTILISER)));
            plantList.add(plant);
        }
        return  plantList;
    }
    // Delete Plant Details
    public void DeletePlant(int userid){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_PLANT, KEY_ID+" = ?",new String[]{String.valueOf(userid)});
        db.close();
    }
    // Update Plant Details
    public int UpdatePlantDetails(String name, String botanicalName, String variety, byte[] image, float sowDepth, float distance, String growMode, int plantSqm, int germinationPeriod, String location, float height, int harvestPeriod, float temperature, int transplantingTime, String plantingTime, int wateringPeriod, int fertilisingPeriod, int id){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cVals = new ContentValues();
        cVals.put(KEY_NAME, name);
        cVals.put(KEY_BOTANICAL_NAME, botanicalName);
        cVals.put(KEY_VARIETY, variety);
        cVals.put(KEY_IMAGE, image);
        cVals.put(KEY_SOWDEPTH, sowDepth);
        cVals.put(KEY_DISTANCE, distance);
        cVals.put(KEY_GROWMODE, growMode);
        cVals.put(KEY_PLANTS_SQM, plantSqm);
        cVals.put(KEY_GERMINATION, germinationPeriod);
        cVals.put(KEY_LOCATION, location);
        cVals.put(KEY_HEIGHT, height);
        cVals.put(KEY_HARVEST, harvestPeriod);
        cVals.put(KEY_MINTEMPERATURE, temperature);
        cVals.put(KEY_TRANSPLANT, transplantingTime);
        cVals.put(KEY_PLANTING_TIME, plantingTime);
        cVals.put(KEY_WATER, wateringPeriod);
        cVals.put(KEY_FERTILISER, fertilisingPeriod);
        int count = db.update(TABLE_PLANT, cVals, KEY_ID+" = ?",new String[]{String.valueOf(id)});
        return  count;
    }

    //check for plant
    public boolean checkPlantExist(String name){
        String[] columns = {"name"};
        SQLiteDatabase db = this.getWritableDatabase();

        String selection = "name=?";
        String[] selectionArgs = {name};

        Cursor cursor = db.query(TABLE_PLANT, columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();

        cursor.close();
        close();

        if(count > 0){
            return true;
        } else {
            return false;
        }
    }
}
