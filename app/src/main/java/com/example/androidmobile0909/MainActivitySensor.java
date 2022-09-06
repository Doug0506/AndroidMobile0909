package com.example.androidmobile0909;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivitySensor extends AppCompatActivity {

    TextView textNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sensor);
        getSupportActionBar().hide();

        textNome = findViewById(R.id.sensorNome);
        String nome = getIntent().getStringExtra("Chave");
        textNome.setText(nome);
    }
}