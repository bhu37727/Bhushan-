package com.android.veggitech.growapp.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.veggitech.growapp.R;
import com.android.veggitech.growapp.adapter.CustomAdapter;
import com.android.veggitech.growapp.adapter.TutorialAdapter;
import com.android.veggitech.growapp.model.ItemModel;
import com.android.veggitech.growapp.model.TutorialModel;

import java.util.ArrayList;

public class TutorialActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Button skipTutorial;
    ArrayList<TutorialModel> arrayList;
    int images[] = {R.drawable.growspace, R.drawable.growmode, R.drawable.choice, R.drawable.seeding, R.drawable.nutrition};
    String title[] = {"Grow Space", "Grow Mode", "Choice of Plants", "Seeding", "Water & Nutrition"};
    String description[] = {"The Grow Space  should get at least six hours of sunlight daily, good drainage and air circulation, and a level location with loose, rich soil.",
                            "The nutrients the plants need are provided by the nutrient solution, and is what the growing media is watered and moistened with. ",
    "Some important plant characteristics are size, hardiness, susceptibility to insects and diseases, and soil conditions. Careful plant selection can create an attractive landscape.",
    "A seed is the first stage in the life cycle of a plant. Protected inside the tough seed coat, or testa, is the baby plant, called an embryo. ",
    "Plants draw most of their nutrients through their roots. Often, water contains a significant amount of calcium, magnesium, sodium and chloride."};
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

      /*  getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.veggitechlogo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);*/

        recyclerView = findViewById(R.id.recycler_view_tutorial);
        skipTutorial = findViewById(R.id.buttonSkip);
        skipTutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent = new Intent(getApplicationContext(), SetUpGrowSpaceActivity.class);
                startActivity(intent);
            }
        });
        arrayList = new ArrayList<>();

        recyclerView.setLayoutManager(new LinearLayoutManager(this.getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        for (int i = 0; i < images.length; i++) {
            TutorialModel tutorialModel = new TutorialModel();
            tutorialModel.setImage(images[i]);
            tutorialModel.setTitle(title[i]);
            tutorialModel.setDescription(description[i]);

            //add in array list
            arrayList.add(tutorialModel);
        }

        TutorialAdapter adapter = new TutorialAdapter(this.getApplicationContext(), arrayList);
        recyclerView.setAdapter(adapter);

        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.chat:
                String smsNumber = "971505537156"; //without '+'
                try {
                    Intent chatIntent = new Intent("android.intent.action.MAIN");
                    //chatIntent.setComponent(new ComponentName("com.whatsapp", "com.whatsapp.Conversation"));
                    chatIntent.setAction(Intent.ACTION_SEND);
                    chatIntent.setType("text/plain");
                    chatIntent.putExtra(Intent.EXTRA_TEXT, "Your Message");
                    chatIntent.putExtra("jid", smsNumber + "@s.whatsapp.net"); //phone number without "+" prefix
                    chatIntent.setPackage("com.whatsapp");
                    startActivity(chatIntent);
                } catch(Exception e) {
                    Toast.makeText(getApplicationContext(), "Error/n" + e.toString(), Toast.LENGTH_SHORT).show();
                }
                return true;

            case R.id.email:
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                String[] recipients = {"cao@veggitech.com"};
                emailIntent.putExtra(Intent.EXTRA_EMAIL, recipients);
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
                emailIntent.putExtra(Intent.EXTRA_CC, "it_projects@veggitech.com");
                emailIntent.setType("message/rfc822");
                startActivity(Intent.createChooser(emailIntent, "Send mail"));
                return true;

            case R.id.call:
                Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
                phoneIntent.setData(Uri.parse("tel:971505537156"));
                startActivity(phoneIntent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
