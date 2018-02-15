package com.example.kevin.juegomuseo;

import android.content.ClipData;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class Nivel1 extends AppCompatActivity {
    private ImageView tucan;
    private ImageView sahino;
    private ImageView mataje;
    private Integer score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setFullScreen();
        setContentView(R.layout.activity_nivel1);
        tucan = (ImageView) findViewById(R.id.paper);
        tucan.setTag("tucan");
        sahino = (ImageView) findViewById(R.id.paper2);
        sahino.setTag("sahino");
        mataje = (ImageView) findViewById(R.id.trash);
        mataje.setTag("mataje");
        score=0;
        mataje.setOnDragListener(new TrashDragListener(
                R.drawable.mataje2,
                R.drawable.mataje2));

        tucan.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                view.startDrag(data, shadowBuilder, view, 0);
                view.setVisibility(View.INVISIBLE);
                return true;
            }
        });

        sahino.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                view.startDrag(data, shadowBuilder, view, 0);
                view.setVisibility(View.INVISIBLE);
                return true;
            }
        });
    }
    public void finalizarNivel(View view){
        Intent scoreIntent=new Intent(this,Score.class);
        String message = 1+","+score;
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
            final ImageView draggedView = (ImageView) event.getLocalState();
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
                    switch (draggedView.getId()){
                        case R.id.paper:
                            if(containerView.getTag().equals("sahino_mataje")){
                                containerView.setImageResource(R.drawable.tucan_sahino_mataje);
                                Log.d(TAG, "onDrag: ACTION_DRAG_EXITED1");
                            }else{
                                containerView.setImageResource(R.drawable.tucan_mataje);
                                containerView.setTag("tucan_mataje");
                                Log.d(TAG, "onDrag: ACTION_DRAG_EXITED2");
                            }
                            hit = true;
                            score+=50;
                            break;
                        case R.id.paper2:
                            if(containerView.getTag().equals("tucan_mataje")){
                                containerView.setImageResource(R.drawable.tucan_sahino_mataje);
                                Log.d(TAG, "onDrag: ACTION_DRAG_EXITED3");
                            }else{
                                containerView.setImageResource(R.drawable.sahino_mataje);
                                containerView.setTag("sahino_mataje");
                                Log.d(TAG, "onDrag: ACTION_DRAG_EXITED4");
                            }
                            hit = true;
                            score+=50;
                            break;
                        default:
                            score-=10;
                            break;
                    }
                    draggedView.post(new Runnable() {
                        @Override
                        public void run() {
                            draggedView.setVisibility(View.GONE);
                        }
                    });
                    return true;
                case DragEvent.ACTION_DRAG_ENDED:
                    Log.d(TAG, "onDrag: ACTION_DRAG_ENDED");

                    v.setVisibility(View.VISIBLE);
                    if (!hit) {
                        draggedView.post(new Runnable() {
                            @Override
                            public void run() {
                                draggedView.setVisibility(View.VISIBLE);
                            }
                        });
                    }
                    return true;
                default:
                    return true;
            }
        }
    }

    private void setFullScreen() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}
