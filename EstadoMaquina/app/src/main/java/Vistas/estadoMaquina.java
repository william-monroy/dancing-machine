package Vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.estadomaquina.R;

import Application.applicationMaquina;

public class estadoMaquina extends AppCompatActivity {

    applicationMaquina app;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estado_maquina);

        app =(applicationMaquina) getApplicationContext();
        TextView textView = findViewById(R.id.Texto);
        textView.setText(app.imprimeActual());
    }
    public void Volver(View view){
        setResult(2);
        finish();
    }
    public void verPartida(View view){
        Intent intent = new Intent(getApplicationContext(), estadoPartida.class);
        startActivityForResult(intent, 1);
    }
}