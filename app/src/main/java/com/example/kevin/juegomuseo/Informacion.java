package com.example.kevin.juegomuseo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.facebook.AccessToken;

public class Informacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion);

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        Glide.with(Informacion.this)
                .load(R.drawable.comojugar)
                .asGif()
                .placeholder(R.drawable.comojugar)
                .crossFade()
                .into(imageView);

    }

    public void goNivel(View view){

        if (AccessToken.getCurrentAccessToken() == null){
            Intent intent = new Intent(this, Login.class);
            startActivity(intent);
            Toast.makeText(Informacion.this, "Inicie sesión con FB", Toast.LENGTH_SHORT).show();
        }

        else {
            Intent intent = new Intent(this, Niveles.class);
            startActivity(intent);
        }

    }
}
