package com.example.ryoga.tema5;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NotificacionActivity extends AppCompatActivity {
    AppCompatActivity NotificacionActivity;
    TextView txtTituloMensaje;
    TextView txtTextoMensaje;
    TextView txtTiempoMensaje;
    Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificacion);
        NotificacionActivity = this;
        txtTituloMensaje = findViewById(R.id.txtTituloMensaje);
        txtTextoMensaje = findViewById(R.id.txtTextoMensaje);
        txtTiempoMensaje = findViewById(R.id.txtTiempoMensaje);

        btnEnviar = findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder mensaje = new NotificationCompat.Builder(NotificacionActivity, "CH_ID");

                Intent notIntent =  new Intent(NotificacionActivity.this, NotificacionActivity.class);

                PendingIntent contIntent =  PendingIntent.getActivity(NotificacionActivity.this, 0, notIntent, 0);

                mensaje.setContentIntent(contIntent);

                mensaje.setAutoCancel(true)
                        .setDefaults(Notification.DEFAULT_ALL)
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(android.R.drawable.star_on)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.mi_icono))
                        .setContentTitle(txtTituloMensaje.getText().toString())
                        .setContentText(txtTextoMensaje.getText().toString());
                      //  .setTimeoutAfter(txtTiempoMensaje.wait(toString();


                NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                nm.notify(1,mensaje.build());
                ;

            }
        });
    }
}
