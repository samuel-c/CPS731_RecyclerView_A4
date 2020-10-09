package com.example.recycleviewwords;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class GalleryActivity extends AppCompatActivity {

    private static final String TAG = "GalleryActivity";



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_detail);

        //getActionBar().setTitle(getIntent().getStringExtra("recipe_title"));

        Log.d(TAG, "onCreate: started.");

        getSupportActionBar().setTitle(R.string.title_recipe_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getIncomingIntent();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id==android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    private void getIncomingIntent(){
        Log.d(TAG, "getIncomingIntent: checking for incoming intents.");

        if(getIntent().hasExtra("image_id") && getIntent().hasExtra("recipe_title") && getIntent().hasExtra("recipe_text")){
            Log.d(TAG, "getIncomingIntent: found intent extras.");

            String recipeTitle = getIntent().getStringExtra("recipe_title");
            String recipeText = getIntent().getStringExtra("recipe_text");
            int imageId = getIntent().getIntExtra("image_id", 0);


            setImage(imageId, recipeTitle, recipeText);
        }
    }


    private void setImage(int imageId, String recipeTitle, String recipeText){
        Log.d(TAG, "setImage: setting te image and name to widgets.");

        TextView title = findViewById(R.id.recipe_title);
        title.setText(recipeTitle);

        TextView text = findViewById(R.id.recipe_text);
        text.setText(recipeText);
        
        ImageView image = findViewById(R.id.image);
        image.setImageDrawable(getResources().getDrawable(imageId));

    }

}


















