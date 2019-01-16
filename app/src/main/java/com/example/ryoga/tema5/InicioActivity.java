package com.example.ryoga.tema5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InicioActivity extends AppCompatActivity {
    Button toast;
    Button notificacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);


       toast =(Button)findViewById(R.id.btnToast);
       toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toast = new Intent(InicioActivity.this, ToastActivity.class);
                startActivity(toast);
            }
        });

        notificacion =(Button)findViewById(R.id.btnNotificacion);
        notificacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent notificacion = new Intent(InicioActivity.this, NotificacionActivity.class);
                startActivity(notificacion);
            }
        });

    }
}
