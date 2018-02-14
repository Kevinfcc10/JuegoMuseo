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
import android.widget.Toast;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class Nivel2 extends AppCompatActivity {


    GridView grid1;
    int[] imageId = { R.drawable.garza, R.drawable.guacamayo, R.drawable.iguana};
    String[] tags={"garza","guacamayo","iguana"};
    private ImageView manglar;
    private ImageView costa;
    private Integer score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel2);
        costa = (ImageView) findViewById(R.id.costa);
        costa.setTag("costa");
        manglar = (ImageView) findViewById(R.id.manglar);
        manglar.setTag("manglar");
        score=0;
        costa.setOnDragListener(new Nivel2.TrashDragListener(
                R.drawable.costa,
                R.drawable.costa));
        manglar.setOnDragListener(new Nivel2.TrashDragListener(
                R.drawable.manglar,
                R.drawable.manglar));
        CustomGrid2 adapter = new CustomGrid2(Nivel2.this, imageId,tags);
        grid1=(GridView)findViewById(R.id.grid1);
        grid1.setAdapter(adapter);
        grid1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
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
        String message = 2+","+score;
        scoreIntent.putExtra(EXTRA_MESSAGE, message);
        startActivity(scoreIntent);
    }
    private class TrashDragListener implements View.OnDragListener {

        private static final String TAG = "TrashDragListener";

        private int enterShape;
        private int normalShape;
        private boolean hit;

        public TrashDragListener(int enterShape, int normalShape) {
            this.enterShape = enterShape;
            this.normalShape = normalShape;
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
                    if(containerView.getTag().toString().contains("manglar") && (draggedView.getTag().equals("garza") || draggedView.getTag().equals("iguana"))){
                        draggedView1.setVisibility(View.VISIBLE);
                    }else if(containerView.getTag().toString().contains("costa") && draggedView.getTag().equals("guacamayo")){
                        draggedView1.setVisibility(View.VISIBLE);
                    }
                    return true;
                case DragEvent.ACTION_DROP:
                    Log.d(TAG, "onDrag: ACTION_DROP");
                    switch ((String)draggedView.getTag()){
                        case "garza":
                            if(containerView.getTag().toString().contains("manglar") && containerView.getTag().equals("iguana_manglar")){
                                containerView.setImageResource(R.drawable.garza_iguana_manglar);
                                Log.d(TAG, "onDrag: ACTION_DRAG_EXITED1");
                                hit = true;
                                draggedView.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        draggedView.setVisibility(View.GONE);
                                    }
                                });
                                score+=33;
                            }else if(containerView.getTag().toString().contains("manglar")){
                                containerView.setImageResource(R.drawable.garza_manglar);
                                containerView.setTag("garza_manglar");
                                Log.d(TAG, "onDrag: ACTION_DRAG_EXITED2");
                                hit = true;
                                draggedView.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        draggedView.setVisibility(View.GONE);
                                    }
                                });
                                score+=33;
                            }else{
                                draggedView1.setVisibility(View.VISIBLE);
                            }
                            hit = true;
                            break;
                        case "guacamayo":
                            if(containerView.getTag().equals("costa")){
                                containerView.setImageResource(R.drawable.guacamayo_costa);
                                Log.d(TAG, "onDrag: ACTION_DRAG_EXITED3");
                                hit = true;
                                draggedView.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        draggedView.setVisibility(View.GONE);
                                    }
                                });
                                score+=33;
                            }else {
                                draggedView1.setVisibility(View.VISIBLE);
                            }
                            break;
                        case "iguana":
                            if(containerView.getTag().toString().contains("manglar") && containerView.getTag().equals("garza_manglar")){
                                containerView.setImageResource(R.drawable.garza_iguana_manglar);
                                Log.d(TAG, "onDrag: ACTION_DRAG_EXITED3");
                                hit = true;
                                draggedView.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        draggedView.setVisibility(View.GONE);
                                    }
                                });
                                score+=33;
                            }else if(containerView.getTag().toString().contains("manglar")){
                                containerView.setImageResource(R.drawable.iguana_manglar);
                                containerView.setTag("iguana_manglar");
                                Log.d(TAG, "onDrag: ACTION_DRAG_EXITED4");
                                hit = true;
                                draggedView.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        draggedView.setVisibility(View.GONE);
                                    }
                                });
                                score+=33;
                            }else{
                                draggedView1.setVisibility(View.VISIBLE);
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
