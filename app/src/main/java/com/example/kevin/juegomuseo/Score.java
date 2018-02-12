package com.example.kevin.juegomuseo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class Score extends AppCompatActivity {
    private ImageView estrellas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        Intent intent = getIntent();
        String message = intent.getStringExtra(EXTRA_MESSAGE);
        estrellas = (ImageView) findViewById(R.id.imageView13);
       Integer score = Integer.valueOf(message.split(",")[1]);
       String nivel = message.split(",")[0];
        TextView nivelText = (TextView) findViewById(R.id.textView13);
        nivelText.setText(nivel);
        TextView puntajeText = (TextView) findViewById(R.id.textViewPuntaje);
        puntajeText.setText(Integer.valueOf(score));
        if(score>=70){
            estrellas.setImageResource(R.drawable.estrella1);
        }else if(score>=35&&score<70){
            estrellas.setImageResource(R.drawable.estrella2);
        }else{
            estrellas.setImageResource(R.drawable.estrella3);
        }


    }



}
