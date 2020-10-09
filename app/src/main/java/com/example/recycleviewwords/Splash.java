package com.example.recycleviewwords;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {

    MediaPlayer media;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().setTitle(R.string.title_recipe_list);

        media = new MediaPlayer();
        media = MediaPlayer.create(this, R.raw.intro);
        media.start();
        TimerTask task=new TimerTask() {
            @Override
            public void run() {
                finish();
                media.stop();
                startActivity(new Intent(Splash.this, RecipeListActivity.class));
            }
        };
        Timer oppening= new Timer();
        oppening.schedule(task,5000);
    }
}