package com.example.kevin.juegomuseo;

import android.content.ClipData;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class NivelN extends AppCompatActivity {

    GridView grid2;
    int[] imageId = { R.drawable.ardilla, R.drawable.zorro, R.drawable.tortuga};
    String []tags={"ardilla","zorro","tortuga"};
    private Intent intent;
    private ImageView bosque;
    private ImageView paramo;
    private ImageView galapagos;
    private Integer score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel_n);
        bosque=(ImageView) findViewById(R.id.bosque);
        bosque.setTag("bosque");
        paramo=(ImageView) findViewById(R.id.paramo);
        paramo.setTag("paramo");
        galapagos=(ImageView) findViewById(R.id.galapagos);
        galapagos.setTag("galapagos");
        CustomGrid2 adapter = new CustomGrid2(this, imageId,tags);
        grid2=(GridView)findViewById(R.id.grid2);
        grid2.setAdapter(adapter);
        score=0;
        bosque.setOnDragListener(new NivelN.BosqueDragListener());
        paramo.setOnDragListener(new NivelN.ParamoDragListener());
        galapagos.setOnDragListener(new NivelN.GalapagosDragListener());
        grid2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                view.startDrag(data, shadowBuilder, view, 0);
                view.setVisibility(View.INVISIBLE);
                return false;
            }
        });


    }

    public void finalizarNivel(View view){
        Intent scoreIntent=new Intent(this,Score.class);
        String message = 3+","+score;
        scoreIntent.putExtra(EXTRA_MESSAGE, message);
        startActivity(scoreIntent);
    }

    public class BosqueDragListener implements View.OnDragListener {
        private static final String TAG = "BosqueDragListener";

        private boolean hit;

        public BosqueDragListener() {
        }
        @Override
        public boolean onDrag(View v, DragEvent event) {
            final ImageView containerView = (ImageView) v;
            final RelativeLayout draggedView1 = (RelativeLayout) event.getLocalState();
            final ImageView draggedView=(ImageView)draggedView1.getChildAt(0);
            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    Log.d(TAG, "onDrag: ACTION_DRAG_STARTED");
                    hit = false;
                    return true;
                case DragEvent.ACTION_DRAG_ENTERED:
                    Log.d(TAG, "onDrag: ACTION_DRAG_ENTERED");
                    return true;
                case DragEvent.ACTION_DRAG_EXITED:
                    Log.d(TAG, "onDrag: ACTION_DRAG_EXITED");
                    return true;
                case DragEvent.ACTION_DROP:
                    Log.d(TAG, "onDrag: ACTION_DROP");
                    switch ((String)draggedView.getTag()){
                        case "ardilla":
                            if(containerView.getTag().equals("bosque")){
                                containerView.setImageResource(R.drawable.ardilla_bosque);
                                Log.d(TAG, "onDrag: ACTION_DRAG_EXITED3");
                                hit = true;
                                draggedView.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        draggedView.setVisibility(View.GONE);
                                    }
                                });
                                score+=33;
                            }
                            break;
                        default:
                            break;
                    }
                    return true;
                case DragEvent.ACTION_DRAG_ENDED:
                    Log.d(TAG, "onDrag: ACTION_DRAG_ENDED");

                    v.setVisibility(View.VISIBLE);
                    if (!hit) {

                        draggedView.post(new Runnable() {
                            @Override
                            public void run() {
                                draggedView1.setVisibility(View.VISIBLE);
                                score-=10;
                            }
                        });
                    }
                    return true;
                default:
                    return true;
            }
        }
    }

    public class ParamoDragListener implements View.OnDragListener {
        private static final String TAG = "ParamoDragListener";

        private boolean hit;

        public ParamoDragListener() {
        }
        @Override
        public boolean onDrag(View v, DragEvent event) {
            final ImageView containerView = (ImageView) v;
            final RelativeLayout draggedView1 = (RelativeLayout) event.getLocalState();
            final ImageView draggedView=(ImageView)draggedView1.getChildAt(0);
            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    Log.d(TAG, "onDrag: ACTION_DRAG_STARTED");
                    hit = false;
                    return true;
                case DragEvent.ACTION_DRAG_ENTERED:
                    Log.d(TAG, "onDrag: ACTION_DRAG_ENTERED");
                    return true;
                case DragEvent.ACTION_DRAG_EXITED:
                    Log.d(TAG, "onDrag: ACTION_DRAG_EXITED");
                    return true;
                case DragEvent.ACTION_DROP:
                    Log.d(TAG, "onDrag: ACTION_DROP");
                    switch ((String)draggedView.getTag()){
                        case "zorro":
                            if(containerView.getTag().equals("paramo")){
                                containerView.setImageResource(R.drawable.zorro_paramo);
                                Log.d(TAG, "onDrag: ACTION_DRAG_EXITED3");
                                hit = true;
                                draggedView.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        draggedView.setVisibility(View.GONE);
                                    }
                                });
                                score+=33;
                            }
                            break;
                        default:
                            score-=10;
                            break;
                    }
                    return true;
                case DragEvent.ACTION_DRAG_ENDED:
                    Log.d(TAG, "onDrag: ACTION_DRAG_ENDED");

                    v.setVisibility(View.VISIBLE);
                    if (!hit) {

                        draggedView.post(new Runnable() {
                            @Override
                            public void run() {
                                draggedView1.setVisibility(View.VISIBLE);
                            }
                        });
                    }
                    return true;
                default:
                    return true;
            }
        }
    }

    public class GalapagosDragListener implements View.OnDragListener {
        private static final String TAG = "GalapagosDragListener";

        private boolean hit;

        public GalapagosDragListener() {
        }
        @Override
        public boolean onDrag(View v, DragEvent event) {
            final ImageView containerView = (ImageView) v;
            final RelativeLayout draggedView1 = (RelativeLayout) event.getLocalState();
            final ImageView draggedView=(ImageView)draggedView1.getChildAt(0);
            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    Log.d(TAG, "onDrag: ACTION_DRAG_STARTED");
                    hit = false;
                    return true;
                case DragEvent.ACTION_DRAG_ENTERED:
                    Log.d(TAG, "onDrag: ACTION_DRAG_ENTERED");
                    return true;
                case DragEvent.ACTION_DRAG_EXITED:
                    Log.d(TAG, "onDrag: ACTION_DRAG_EXITED");
                    return true;
                case DragEvent.ACTION_DROP:
                    Log.d(TAG, "onDrag: ACTION_DROP");
                    switch ((String)draggedView.getTag()){
                        case "tortuga":
                            if(containerView.getTag().equals("galapagos")){
                                containerView.setImageResource(R.drawable.tortuga_galapagos);
                                Log.d(TAG, "onDrag: ACTION_DRAG_EXITED3");
                                hit = true;
                                draggedView.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        draggedView.setVisibility(View.GONE);
                                    }
                                });
                                score+=33;
                            }
                            break;
                        default:
                            score-=10;
                            break;
                    }
                    return true;
                case DragEvent.ACTION_DRAG_ENDED:
                    Log.d(TAG, "onDrag: ACTION_DRAG_ENDED");

                    v.setVisibility(View.VISIBLE);
                    if (!hit) {

                        draggedView.post(new Runnable() {
                            @Override
                            public void run() {
                                draggedView1.setVisibility(View.VISIBLE);
                            }
                        });
                    }
                    return true;
                default:
                    return true;
            }
        }
    }
}
