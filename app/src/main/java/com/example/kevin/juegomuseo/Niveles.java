package com.example.kevin.juegomuseo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class Niveles extends AppCompatActivity {

    GridView grid;
    String[] niveles = {"Nivel 1", "Nivel 2","Nivel 3","Nivel 4","Nivel 5","Nivel 6"} ;
    int[] imageId = { R.drawable.rana, R.drawable.perico, R.drawable.tortuga, R.drawable.delfin, R.drawable.mono, R.drawable.tigrillo};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_niveles);

        CustomGrid adapter = new CustomGrid(Niveles.this, niveles, imageId);
        grid=(GridView)findViewById(R.id.grid);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(Niveles.this, "You Clicked at " +niveles[+ position], Toast.LENGTH_SHORT).show();
            }
        });
    }
}
