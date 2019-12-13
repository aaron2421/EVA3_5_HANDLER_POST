package com.example.eva3_5_handler_post;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView texto;
    Handler handler = new Handler();

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            texto.append("Action\n");
        }
    };

    Thread thread = new Thread(){
        @Override
        public void run() {
            super.run();
            //Trabajo a realizar en segundo plano / No se puede modificar interfaz grafica
            while (true){
                try {
                    Thread.sleep(500);
                    handler.post(runnable);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texto = findViewById(R.id.text);
        thread.start();
    }
}
