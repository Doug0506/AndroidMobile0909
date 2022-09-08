package com.example.androidmobile0909;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivityCamera extends AppCompatActivity {

    private static final int CAPTURAR_IMAGEM = 1;
    private Uri uri;
    Button btnTirarFoto;
    ImageView ImageFoto;
    TextView textNome;

    @SuppressLint("MissingPermission")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_camera);
        getSupportActionBar().hide();

        textNome = findViewById(R.id.textCamera);
        ImageFoto = findViewById(R.id.imageFoto);
        btnTirarFoto = findViewById(R.id.btnTirarFoto);

        String nome;
        SharedPreferences prefs = getSharedPreferences("ChaveGeral", MODE_PRIVATE);
        nome = prefs.getString("ChaveNome","");
        textNome.setText(nome);

        btnTirarFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent open_camera = new Intent (MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(open_camera, CAPTURAR_IMAGEM);
            }
        });
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Bitmap photo = (Bitmap)data.getExtras().get("data");
        ImageFoto.setImageBitmap(photo);

        if (resultCode == Activity.RESULT_OK && requestCode == 123)
        {
            Uri imagemSelecionada = data.getData();
            ImageView imageView = new ImageView(this);
            imageView.setImageURI(imagemSelecionada);
            ConstraintLayout cl = (ConstraintLayout) findViewById(R.id.constraint);
            cl.addView(imageView);
        }
    }


    private void mostrarMensagem(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    private void adicionarNaGaleria() {
        Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        intent.setData(uri);
        this.sendBroadcast(intent);
    }

    public void visualizarImagem(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(uri, "image/jpeg");
        startActivity(intent);
    }

    public void visualizarGaleria(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(Intent.createChooser(intent, "Selecione uma imagem"), 123);
    }

}