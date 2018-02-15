package com.example.kevin.juegomuseo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

public class Nivel4 extends AppCompatActivity {

    GridView grid3;
    int[] imageId = { R.drawable.rana, R.drawable.mataje, R.drawable.tortuga, R.drawable.delfin, R.drawable.sahino};
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel4);

        //CustomGrid2 adapter = new CustomGrid2(Nivel4.this, imageId);
        //grid3=(GridView)findViewById(R.id.grid3);
        //grid3.setAdapter(adapter);

    }
}
