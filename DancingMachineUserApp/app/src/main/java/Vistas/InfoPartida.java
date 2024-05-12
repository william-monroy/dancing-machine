package Vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import dev.wimo.dancingmachineuserapp.R;
import Application.applicationPartida;

public class InfoPartida extends AppCompatActivity {

    applicationPartida app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_partida);

        app =(applicationPartida) getApplicationContext();
        TextView txtId = findViewById(R.id.txtId);
        TextView txtCancion = findViewById(R.id.txtP1);
        TextView txtDificultad = findViewById(R.id.txtP3);
        TextView txtLatitud = findViewById(R.id.txtP2);
        TextView txtLongitud = findViewById(R.id.txtP4);
        txtId.setText(app.getActual().getId());
        txtCancion.setText(app.getActual().getCancion());
        txtDificultad.setText(app.getActual().getDificultad());
        txtLatitud.setText(Float.toString(app.getActual().getLatitud()));
        txtLongitud.setText(Float.toString(app.getActual().getLongitud()));

    }

    public void Volver(View view){
        setResult(2);
        finish();
    }
    public void verInfoMaquina(View view){
        Intent intent = new Intent(getApplicationContext(), InfoMaquina.class);
        Log.d("Intencion de abir InfoMaquina","Estado: " + 1);
        startActivityForResult(intent, 1);
    }

    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }
}