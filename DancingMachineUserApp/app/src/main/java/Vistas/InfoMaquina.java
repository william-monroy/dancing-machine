package Vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import Modelo.modeloMaquina;
import dev.wimo.dancingmachineuserapp.R;
import Application.applicationPartida;

public class InfoMaquina extends AppCompatActivity {

    applicationPartida app;
    TextView txtId, txtP1, txtP2, txtP3, txtP4, txtPuntuacion;
    Handler mainHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_maquina);

        txtId = findViewById(R.id.txtId);
        txtP1 = findViewById(R.id.txtP1);
        txtP2 = findViewById(R.id.txtP2);
        txtP3 = findViewById(R.id.txtP3);
        txtP4 = findViewById(R.id.txtP4);
        txtPuntuacion = findViewById(R.id.txtPuntuacion);

        mainHandler = new Handler(Looper.getMainLooper());
        app = (applicationPartida) getApplicationContext();


        modeloMaquina modeloMaquina = app.getMaquina(app.getActual().getId());
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                // Post a runnable to the main thread
                mainHandler.post(() -> {
                    txtId.setText(modeloMaquina.getIdPartida());
                    txtP1.setText(Boolean.toString(modeloMaquina.getPulsa1()));
                    txtP2.setText(Boolean.toString(modeloMaquina.getPulsa2()));
                    txtP3.setText(Boolean.toString(modeloMaquina.getPulsa3()));
                    txtP4.setText(Boolean.toString(modeloMaquina.getPulsa4()));
                    txtPuntuacion.setText(Integer.toString(modeloMaquina.getPuntuacion()));
                });
            }
        }, 2000);
    }

    public void Volver(View view){
        setResult(2);
        finish();
    }
}