package com.example.androidmobile0909;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Button btnEnviarNome, btnOndeEstou;
    EditText textNome;
    TextView textLatitude, textLongetude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        btnEnviarNome = findViewById(R.id.btnEnviarNome);
        btnOndeEstou = findViewById(R.id.btnOndeEstou);

        textNome = findViewById(R.id.textNome);
        textLatitude = findViewById(R.id.TextLatitute);
        textLongetude = findViewById(R.id.TextLongetude);

        btnEnviarNome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivitySensor.class);
                intent.putExtra("Chave",textNome.getText().toString());
                startActivity(intent);
            }
        });

    }



}