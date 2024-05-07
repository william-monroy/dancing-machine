package Vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.estadomaquina.R;

import Application.applicationMaquina;

public class estadoPartida extends AppCompatActivity {

    applicationMaquina app;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estado_partida);

        app =(applicationMaquina) getApplicationContext();
        TextView textView = findViewById(R.id.textoPartida);
        textView.setText(app.imprimePartida());
    }
    public void Volver(View view){
        setResult(1);
        finish();
    }
}