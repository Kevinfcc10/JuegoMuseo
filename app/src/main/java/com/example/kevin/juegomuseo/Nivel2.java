package com.example.kevin.juegomuseo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

public class Nivel2 extends AppCompatActivity {


    GridView grid1;
    int[] imageId = { R.drawable.rana, R.drawable.perico, R.drawable.tortuga, R.drawable.delfin, R.drawable.mono, R.drawable.tigrillo};
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel2);

        CustomGrid2 adapter = new CustomGrid2(Nivel2.this, imageId);
        grid1=(GridView)findViewById(R.id.grid1);
        grid1.setAdapter(adapter);

    }
}
