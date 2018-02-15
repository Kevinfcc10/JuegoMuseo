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

public class Nivel4 extends AppCompatActivity {

    GridView grid3;
    int[] imageId = { R.drawable.vicuna, R.drawable.mamut, R.drawable.delfin,R.drawable.tigre,R.drawable.puma};
    String []tags={"vicuna","mamut","delfin","tigre","puma"};
    private Intent intent;

    private Integer score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ImageView chimborazo;
        ImageView prehistorico;
        ImageView rio;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel4);
        chimborazo =(ImageView) findViewById(R.id.chimborazo);
        chimborazo.setTag("chimborazo");
        prehistorico =(ImageView) findViewById(R.id.prehistoria);
        prehistorico.setTag("prehistorico");
        rio =(ImageView) findViewById(R.id.rio);
        rio.setTag("rio");
        CustomGrid2 adapter = new CustomGrid2(this, imageId,tags);
        grid3=(GridView)findViewById(R.id.grid3);
        grid3.setAdapter(adapter);
        score=0;
        chimborazo.setOnDragListener(new ChimborazoDragListener());
        prehistorico.setOnDragListener(new PrehistoricoDragListener());
        rio.setOnDragListener(new RioDragListener());
        grid3.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
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
        String message = 4+","+score;
        scoreIntent.putExtra(EXTRA_MESSAGE, message);
        startActivity(scoreIntent);
    }

    public class ChimborazoDragListener implements View.OnDragListener {
        private static final String TAG = "ChimborazoDragListener";

        private boolean hit;

        public ChimborazoDragListener() {
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
                        case "vicuna":
                            if(containerView.getTag().equals("chimborazo")){
                                containerView.setImageResource(R.drawable.vicuna_chimborazo);
                                containerView.setTag("vicuna_chimborazo");
                                Log.d(TAG, "onDrag: ACTION_DRAG_EXITED3");
                                hit = true;
                                draggedView.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        draggedView.setVisibility(View.GONE);
                                    }
                                });
                                score+=20;
                            }else{
                                containerView.setImageResource(R.drawable.vicuna_liebre_chimborazo);
                                Log.d(TAG, "onDrag: ACTION_DRAG_EXITED3");
                                hit = true;
                                draggedView.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        draggedView.setVisibility(View.GONE);
                                    }
                                });
                                score+=20;
                            }
                            break;
                        case "liebre":
                            if(containerView.getTag().equals("chimborazo")){
                                containerView.setImageResource(R.drawable.liebre_chimborazo);
                                containerView.setTag("liebre_chimborazo");
                                Log.d(TAG, "onDrag: ACTION_DRAG_EXITED3");
                                hit = true;
                                draggedView.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        draggedView.setVisibility(View.GONE);
                                    }
                                });
                                score+=20;
                            }else{
                                containerView.setImageResource(R.drawable.vicuna_liebre_chimborazo);
                                Log.d(TAG, "onDrag: ACTION_DRAG_EXITED3");
                                hit = true;
                                draggedView.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        draggedView.setVisibility(View.GONE);
                                    }
                                });
                                score+=20;
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

    public class PrehistoricoDragListener implements View.OnDragListener {
        private static final String TAG = "PrehistoDragListener";

        private boolean hit;

        public PrehistoricoDragListener() {
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
                        case "mamut":
                            if(containerView.getTag().equals("prehistorico")){
                                containerView.setImageResource(R.drawable.mamut_prehistoria);
                                containerView.setTag("mamut_prehistoria");
                                Log.d(TAG, "onDrag: ACTION_DRAG_EXITED3");
                                hit = true;
                                draggedView.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        draggedView.setVisibility(View.GONE);
                                    }
                                });
                                score+=16;
                            }else{
                                containerView.setImageResource(R.drawable.mamut_tigre_prehistoria);
                                Log.d(TAG, "onDrag: ACTION_DRAG_EXITED3");
                                hit = true;
                                draggedView.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        draggedView.setVisibility(View.GONE);
                                    }
                                });
                                score+=20;
                            }
                            break;
                        case "tigre":
                            if(containerView.getTag().equals("prehistorico")){
                                containerView.setImageResource(R.drawable.tigre_prehistoria);
                                containerView.setTag("tigre_prehistoria");
                                Log.d(TAG, "onDrag: ACTION_DRAG_EXITED3");
                                hit = true;
                                draggedView.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        draggedView.setVisibility(View.GONE);
                                    }
                                });
                                score+=20;
                            }else{
                                containerView.setImageResource(R.drawable.mamut_tigre_prehistoria);
                                Log.d(TAG, "onDrag: ACTION_DRAG_EXITED3");
                                hit = true;
                                draggedView.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        draggedView.setVisibility(View.GONE);
                                    }
                                });
                                score+=20;
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

    public class RioDragListener implements View.OnDragListener {
        private static final String TAG = "RioDragListener";

        private boolean hit;

        public RioDragListener() {
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
                        case "delfin":
                            if(containerView.getTag().equals("rio")){
                                containerView.setImageResource(R.drawable.delfin_rio);
                                containerView.setTag("delfin_rio");
                                Log.d(TAG, "onDrag: ACTION_DRAG_EXITED3");
                                hit = true;
                                draggedView.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        draggedView.setVisibility(View.GONE);
                                    }
                                });
                                score+=16;
                            }else{
                                containerView.setImageResource(R.drawable.delfin_puma_rio);
                                Log.d(TAG, "onDrag: ACTION_DRAG_EXITED3");
                                hit = true;
                                draggedView.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        draggedView.setVisibility(View.GONE);
                                    }
                                });
                                score+=16;
                            }
                            break;
                        case "puma":
                            if(containerView.getTag().equals("rio")){
                                containerView.setImageResource(R.drawable.puma_rio);
                                containerView.setTag("puma_rio");
                                Log.d(TAG, "onDrag: ACTION_DRAG_EXITED3");
                                hit = true;
                                draggedView.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        draggedView.setVisibility(View.GONE);
                                    }
                                });
                                score+=16;
                            }else{
                                containerView.setImageResource(R.drawable.delfin_puma_rio);
                                Log.d(TAG, "onDrag: ACTION_DRAG_EXITED3");
                                hit = true;
                                draggedView.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        draggedView.setVisibility(View.GONE);
                                    }
                                });
                                score+=16;
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
