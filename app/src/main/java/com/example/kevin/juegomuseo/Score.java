package com.example.kevin.juegomuseo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class Score extends AppCompatActivity {
    private ImageView estrellas;
    private Button compartirFb;
    ShareDialog shareDialog;
    CallbackManager callbackManager;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_score);

        //asiganmos boton compartir
        compartirFb = findViewById(R.id.CompartirFb);

        callbackManager = CallbackManager.Factory.create();
        shareDialog = new ShareDialog(this);

        final Intent intent = getIntent();
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

        /*compartirFb.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Intent.ACTION_SEND);
                intent1.setType("text/plain");
                intent1.setPackage("com.facebook.katana");
                intent1.putExtra(Intent.EXTRA_TEXT, "Prueba, valiendo en el proyecto");
                intent1.putExtra(Intent.EXTRA_TEXT, "El mejor blog de android");
                startActivity(intent1);
            }
        });
        */

        if (AccessToken.getCurrentAccessToken() == null){
            compartirFb.setVisibility(4);
        }
        else {
            compartirFb.setVisibility(0);
        }
    }

    public void publicar(View view){
            compartirFb.setVisibility(View.VISIBLE);
            try {
                if (ShareDialog.canShow(ShareLinkContent.class)) {
                    ShareLinkContent linkContent = new ShareLinkContent.Builder()
                            .setContentTitle("Prueba Compartir Fb")
                            .setContentDescription("mi puntaje es: ")
                            .setContentUrl(Uri.parse("http://google.com"))
                            .build();

                    shareDialog.show(linkContent);
                }
            } catch (Exception e) {
                Toast.makeText(this, "Error Inicio de sesion" + e.getMessage(), Toast.LENGTH_LONG).show();
            }
    }

    public void irNiveles(View view){
        Intent nivelesIntent=new Intent(this,Niveles.class);
        startActivity(nivelesIntent);
    }


}
