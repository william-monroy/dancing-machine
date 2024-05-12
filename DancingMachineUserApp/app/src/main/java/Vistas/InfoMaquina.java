package Vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import Modelo.modeloMaquina;
import dev.wimo.dancingmachineuserapp.R;
import Application.applicationPartida;

public class InfoMaquina extends AppCompatActivity {

    applicationPartida app;
//    ProgressDialog progressDialog = new ProgressDialog(this);
    TextView txtId = findViewById(R.id.txtId);
    TextView txtP1 = findViewById(R.id.txtP1);
    TextView txtP2 = findViewById(R.id.txtP2);
    TextView txtP3 = findViewById(R.id.txtP3);
    TextView txtP4 = findViewById(R.id.txtP4);
    TextView txtPuntuacion = findViewById(R.id.txtPuntuacion);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_maquina);

        app = (applicationPartida) getApplicationContext();
//        TextView textView = findViewById(R.id.textoPartida);
//        textView.setText(app.imprimePartida());


        modeloMaquina modeloMaquina = app.getMaquina(app.getActual().getId());
//        modeloMaquina modeloMaquina = new modeloMaquina();
//        modeloMaquina = modeloMaquina.createModeloMaquina(app.getActual().getId());

        txtId.setText(modeloMaquina.getIdPartida());
        txtP1.setText(Boolean.toString(modeloMaquina.getPulsa1()));
        txtP2.setText(Boolean.toString(modeloMaquina.getPulsa2()));
        txtP3.setText(Boolean.toString(modeloMaquina.getPulsa3()));
        txtP4.setText(Boolean.toString(modeloMaquina.getPulsa4()));
        txtPuntuacion.setText(Integer.toString(modeloMaquina.getPuntuacion()));
    }

//    public void updateValues(int puntuacion,boolean p1,boolean p2,boolean p3, boolean p4, String idPartida){
//        txtId.setText(idPartida);
//        txtP1.setText(Boolean.toString(p1));
//        txtP2.setText(Boolean.toString(p2));
//        txtP3.setText(Boolean.toString(p3));
//        txtP4.setText(Boolean.toString(p4));
//        txtPuntuacion.setText(Integer.toString(puntuacion));
//    }

    public void Volver(View view){
        setResult(2);
        finish();
    }
}