package Vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import Modelo.Maquina;
import dev.wimo.dancingmachineuserapp.R;
import Application.applicationPartida;

public class InfoMaquina extends AppCompatActivity {

    applicationPartida app;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_maquina);

        app = (applicationPartida) getApplicationContext();
//        TextView textView = findViewById(R.id.textoPartida);
//        textView.setText(app.imprimePartida());
        TextView txtId = findViewById(R.id.txtId);
        TextView txtP1 = findViewById(R.id.txtP1);
        TextView txtP2 = findViewById(R.id.txtP2);
        TextView txtP3 = findViewById(R.id.txtP3);
        TextView txtP4 = findViewById(R.id.txtP4);
        TextView txtPuntuacion = findViewById(R.id.txtPuntuacion);

        Maquina maquina = app.getMaquina(app.getActual().getId());

        txtId.setText(maquina.getIdPartida());
        txtP1.setText(Boolean.toString(maquina.getPulsa1()));
        txtP2.setText(Boolean.toString(maquina.getPulsa2()));
        txtP3.setText(Boolean.toString(maquina.getPulsa3()));
        txtP4.setText(Boolean.toString(maquina.getPulsa4()));
        txtPuntuacion.setText(Integer.toString(maquina.getPuntuacion()));
    }

    public void Volver(View view){
        setResult(1);
        finish();
    }
}