package com.example.androidmobile0909;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivityCreditos extends AppCompatActivity {

    ImageButton ImageTwitch, ImageInstragram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_creditos);
        getSupportActionBar().hide();

        ImageTwitch = findViewById(R.id.imageTwitch);
        ImageInstragram = findViewById(R.id.imageInstagram);


        ImageTwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("https://www.twitch.tv/bb1nho"));
                startActivity(intent);
            }
        });

        ImageInstragram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/douglas_santos_melo/"));
                startActivity(intent);
            }
        });
    }
}