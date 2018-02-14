package com.example.kevin.juegomuseo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
        nivelText.setText("Nivel "+nivel);
        TextView puntajeText = (TextView) findViewById(R.id.textViewPuntaje);
        puntajeText.setText(score+"");
        if(score>=70){
            estrellas.setImageResource(R.drawable.estrella3);
        }else if(score>=35&&score<70){
            estrellas.setImageResource(R.drawable.estrella2);
        }else{
            estrellas.setImageResource(R.drawable.estrella1);
        }


    }

    public void irNiveles(View view){
        Intent nivelesIntent=new Intent(this,Niveles.class);
        startActivity(nivelesIntent);
    }


}
