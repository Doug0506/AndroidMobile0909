package com.example.androidmobile0909;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivitySensor extends AppCompatActivity {


    private int[] numerosDoDado = {
            R.drawable.lado1,
            R.drawable.lado2,
            R.drawable.lado3,
            R.drawable.lado4,
            R.drawable.lado5,
            R.drawable.lado6
    };
    int whip = 0;
    SensorManager sensorManager;
    Sensor sensor;
    SensorEventListener sensorEventListener;

    TextView textNome;
    ImageView dado;
    Button btnProsseguir;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sensor);

        sensorManager=(SensorManager)getSystemService(SENSOR_SERVICE);
        sensor=sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        dado = findViewById(R.id.dado);
        textNome = findViewById(R.id.sensorNome);

        getSupportActionBar().hide();

        String nome;
        SharedPreferences prefs = getSharedPreferences("ChaveGeral", MODE_PRIVATE);
        nome = prefs.getString("ChaveNome","");
        textNome.setText(nome);

        sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                float x = sensorEvent.values[0];
                int numerosAleatorios = new Random().nextInt(numerosDoDado.length);
                if (x<-5 && whip==0) {
                    whip++;
                    dado.setImageResource(numerosDoDado[numerosAleatorios]);

                } else if (x>5 && whip==1){
                    whip++;
                    dado.setImageResource(numerosDoDado[numerosAleatorios]);
                }

                if(whip==2){
                    Som();
                    whip=0;
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };
        Start();

        btnProsseguir = findViewById(R.id.btnProsseguir);

        btnProsseguir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivitySensor.this, MainActivityCamera.class);
                intent.putExtra("Chave",textNome.getText().toString());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onPause() {
        Stop();
        super.onPause();
    }

    @Override
    protected void onResume() {
        Start();
        super.onResume();
    }

    private void Som(){
        MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.dado);
        mediaPlayer.start();
    }

    private void Start(){
        sensorManager.registerListener(sensorEventListener,sensor,SensorManager.SENSOR_DELAY_NORMAL);
    }

    private void Stop(){
        sensorManager.unregisterListener(sensorEventListener);
    }
}