package com.example.androidmobile0909;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivityCelebrar extends AppCompatActivity {

    TextView textParabens;
    Button btnCreditos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_celebrar);
        getSupportActionBar().hide();
        btnCreditos = findViewById(R.id.btnCreditos);
        textParabens = findViewById(R.id.textParabens);

        String nome;
        SharedPreferences prefs = getSharedPreferences("ChaveGeral", MODE_PRIVATE);
        nome = prefs.getString("ChaveNome","");
        textParabens.setText("Parabéns " + nome + " você completou o teste");

        btnCreditos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityCelebrar.this, MainActivityCreditos.class);
                startActivity(intent);
            }
        });
    }
}