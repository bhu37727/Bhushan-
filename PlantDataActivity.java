package com.android.veggitech.growapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.veggitech.growapp.R;
import com.android.veggitech.growapp.database.DbHandler;
import com.android.veggitech.growapp.database.DbHandlerPlants;

import java.io.ByteArrayOutputStream;

public class PlantDataActivity extends AppCompatActivity {

    Button chooseFile, save;
    EditText name, botanicalName, variety, sowDepth, distancePlants, growMode, plantsSqm, germinationPeriod, location, height, harvestPeriod, minTemperature, maxTemperature, transplantingTime, plantingTime, wateringPeriod, fertilisingPeriod, minPh, maxPh;
    ImageView plantImage;
    private static int RESULT_LOAD_IMAGE = 1;
    Bitmap photo;
    String pName, bName, varty, mode, pTime, lctn, minph, maxph, sDepth, distance;
    int sqm, gp, hp, tranTime, water, fertilise;
    Float depth, plantDistance, h, minTemp, maxTemp, minPH, maxPH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_data);

        chooseFile = findViewById(R.id.buttonChooseFile);
       /* chooseFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(galleryIntent, RESULT_LOAD_IMAGE);
            }
        });*/

        plantImage = findViewById(R.id.imageViewPlant);
        name = findViewById(R.id.editTextPlantName);
        botanicalName = findViewById(R.id.editTextBotanicalName);
        variety = findViewById(R.id.editTextVariety);
        sowDepth = findViewById(R.id.editTextSowDepth);
        distancePlants = findViewById(R.id.editTextDistance);
        growMode = findViewById(R.id.editTextGrowMode);
        plantsSqm = findViewById(R.id.editTextPlantSqm);
        germinationPeriod = findViewById(R.id.editTextGermination);
        location = findViewById(R.id.editTextLocation);
        height = findViewById(R.id.editTextHeight);
        harvestPeriod = findViewById(R.id.editTextHarvest);
        minTemperature = findViewById(R.id.editTextMinTemperature);
        maxTemperature = findViewById(R.id.editTextMaxTemperature);
        transplantingTime = findViewById(R.id.editTextTransplant);
        plantingTime = findViewById(R.id.editTextPlanting);
        wateringPeriod = findViewById(R.id.editTextWater);
        fertilisingPeriod = findViewById(R.id.editTextFertilise);
        minPh = findViewById(R.id.editTextMinPh);
        maxPh = findViewById(R.id.editTextMaxPh);


        save = findViewById(R.id.buttonSave);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               /* photo = ((BitmapDrawable)plantImage.getDrawable()).getBitmap();
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                photo.compress(Bitmap.CompressFormat.PNG, 100, bos);
                byte[] bArray = bos.toByteArray();*/
                Bitmap b = BitmapFactory.decodeResource(getResources(),
                        R.drawable.cucumber);
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                b.compress(Bitmap.CompressFormat.JPEG, 100, bos);
                byte[] bArray = bos.toByteArray();
                //Toast.makeText(getApplicationContext(), "Image" +bArray, Toast.LENGTH_LONG).show();

                pName = name.getText().toString();
                bName = botanicalName.getText().toString();
                varty = variety.getText().toString();
                sDepth = sowDepth.getText().toString();
                depth = Float.parseFloat(sDepth);
                distance = distancePlants.getText().toString();
                plantDistance = Float.parseFloat(distance);
                String hgt = height.getText().toString();
                h = Float.parseFloat(hgt);
                mode = growMode.getText().toString();
                String pSqm = plantsSqm.getText().toString();
                sqm = Integer.parseInt(pSqm);
                String gPeriod = germinationPeriod.getText().toString();
                gp = Integer.parseInt(gPeriod);
                lctn = location.getText().toString();
                String hPeriod = harvestPeriod.getText().toString();
                hp = Integer.parseInt(hPeriod);
                String tmp = minTemperature.getText().toString();
                minTemp = Float.parseFloat(tmp);
                String mtmp = maxTemperature.getText().toString();
                maxTemp = Float.parseFloat(mtmp);
                String tTime = transplantingTime.getText().toString();
                tranTime = Integer.parseInt(tTime);
                pTime = plantingTime.getText().toString();
                String wPeriod = wateringPeriod.getText().toString();
                water = Integer.parseInt(wPeriod);
                String fPeriod = fertilisingPeriod.getText().toString();
                fertilise = Integer.parseInt(fPeriod);
                minph = minPh.getText().toString();
                minPH = Float.parseFloat(minph);
                maxph = maxPh.getText().toString();
                maxPH = Float.parseFloat(maxph);

                DbHandlerPlants dbHandlerPlants = new DbHandlerPlants(PlantDataActivity.this);
                boolean isInserted = dbHandlerPlants.insertPlantDetails(pName,bName,varty,bArray,depth,plantDistance,mode,sqm,gp,lctn,h,hp,minTemp, maxTemp, tranTime,pTime,water,fertilise,minPH, maxPH);
                //Toast.makeText(getApplicationContext(), "Details Inserted Successfully",Toast.LENGTH_SHORT).show();
                if (isInserted == true)
                    Toast.makeText(getApplicationContext(), "Data Inserted", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getApplicationContext(), "Data NOT Inserted", Toast.LENGTH_LONG).show();

                Intent plantIntent = new Intent(PlantDataActivity.this,MainActivity.class);
                startActivity(plantIntent);
                PlantDataActivity.this.finish();
            }
        });

    }

   /* @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();

            //ImageView imageView = (ImageView) findViewById(R.id.imgView);
            plantImage.setImageBitmap(BitmapFactory.decodeFile(picturePath));

        }
    }*/
}
