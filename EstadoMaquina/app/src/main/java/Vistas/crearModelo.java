package Vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ToggleButton;

import com.example.estadomaquina.R;

import Application.applicationMaquina;

public class crearModelo extends AppCompatActivity {

    private applicationMaquina app;
    private boolean b1=false;
    private boolean b2 = false;
    private boolean b3 = false;
    private boolean b4 = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_modelo);
        app = (applicationMaquina) getApplicationContext();
        app.iniciarActual();
    }
    public void guardar(View view){
        EditText editText = (EditText) findViewById(R.id.Puntuacion);
        String dato = editText.getText().toString();
        app.setPuntuacion(Integer.parseInt(dato));

        editText = (EditText) findViewById(R.id.Id);
        dato = editText.getText().toString();
        app.asociarPartida(dato);

        ToggleButton t1 = (ToggleButton) findViewById(R.id.Boton1);
        ToggleButton t2 = (ToggleButton) findViewById(R.id.Boton2);
        ToggleButton t3 = (ToggleButton) findViewById(R.id.Boton3);
        ToggleButton t4 = (ToggleButton) findViewById(R.id.Boton4);
        if(b1) {
            app.pulsar1();
        }
        if(b2) {
            app.pulsar2();
        }
        if(b3) {
            app.pulsar3();
        }
        if(b4) {
            app.pulsar4();
        }

        app.guardarActual();
        setResult(1);
        finish();
    }
    public void bot1(View view){
        b1 = !b1;
    }
    public void bot2(View view){
        b2 = !b2;
    }
    public void bot3(View view){
        b3 = !b3;
    }
    public void bot4(View view){
        b4 = !b4;
    }


}