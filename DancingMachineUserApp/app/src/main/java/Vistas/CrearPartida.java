package Vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import dev.wimo.dancingmachineuserapp.R;
import Application.applicationPartida;

public class CrearPartida extends AppCompatActivity {

    private applicationPartida app;
    //SPINNER
    TextView j_spinner_selected;
    Spinner j_spinner;

    int currentIndex = 0;

    String[] dificultad = {"Fácil","Medio","Difícil"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_partida);

        app = (applicationPartida) getApplicationContext();
        app.iniciarActual();

        // inputDificultad Dropdown
        j_spinner = findViewById(R.id.inputDificultad);
        j_spinner_selected = findViewById(R.id.x_spinner_selected);
        j_spinner.post(new Runnable() {
            @Override
            public void run() {

                j_spinner.setSelection(currentIndex);
                j_spinner_selected.setText(dificultad[currentIndex]);
            }
        });
        j_spinner_selected.setText(dificultad[currentIndex]);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, dificultad);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        j_spinner.setAdapter(adapter);
        j_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View view, int arg2, long arg3) {
                j_spinner_selected.setText(j_spinner.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                j_spinner.setSelection(currentIndex);
                j_spinner_selected.setText(dificultad[currentIndex]);
            }
        });
    }

    public void crearPartida(View view) {
        EditText inputId = findViewById(R.id.inputId);
        EditText inputCancion = findViewById(R.id.inputCancion);
        TextView txtDificultad = findViewById(R.id.x_spinner_selected);
        EditText inputLatitud = findViewById(R.id.inputLatitud);
        EditText inputLongitud = findViewById(R.id.inputLongitud);

        app.setId(inputId.getText().toString());
        app.setCancion(inputCancion.getText().toString());
        app.setDificultad(txtDificultad.getText().toString());
        app.setLatitud(Float.valueOf(inputLatitud.getText().toString()));
        app.setLongitud(Float.valueOf(inputLongitud.getText().toString()));

//        app.guardarActual();
        setResult(1);
        finish();
    }
}