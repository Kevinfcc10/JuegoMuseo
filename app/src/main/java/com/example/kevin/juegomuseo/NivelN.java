package com.example.kevin.juegomuseo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

public class NivelN extends AppCompatActivity {

    GridView grid2;
    int[] imageId = { R.drawable.rana, R.drawable.mataje, R.drawable.tortuga, R.drawable.delfin, R.drawable.sahino};
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel_n);

        //CustomGrid2 adapter = new CustomGrid2(NivelN.this, imageId);
        //grid2=(GridView)findViewById(R.id.grid2);
        //grid2.setAdapter(adapter);



    }
}
